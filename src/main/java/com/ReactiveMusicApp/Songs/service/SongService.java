package com.ReactiveMusicApp.Songs.service;

import com.ReactiveMusicApp.Songs.model.Playlist;
import com.ReactiveMusicApp.Songs.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;


@Service
public class SongService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    public SongService(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    public Flux<Song> getAllMusicTracks() {
        return reactiveMongoTemplate.findAll(Song.class);
    }

    public Mono<Void> addMusicTrackToPlaylist(String userId, String id, Object trackIds) {
        // Sprawdź, czy użytkownik ma już swoją playlistę
        return reactiveMongoTemplate.exists(Query.query(Criteria.where("userId").is(userId)), Playlist.class)
                .flatMap(exists -> {
                    if (exists) {
                        // Jeśli użytkownik ma już playlistę, dodaj utwór
                        return reactiveMongoTemplate.updateFirst(
                                Query.query(Criteria.where("userId").is(userId)),
                                new Update().addToSet("trackIds", trackIds),
                                Playlist.class
                        ).then();
                    } else {
                        // Jeśli użytkownik nie ma jeszcze playlisty, stwórz nową
                        Playlist playlist = new Playlist(userId, Collections.singletonList(trackIds.toString()));
                        return reactiveMongoTemplate.save(playlist).then();
                    }
                });
    }

    public Flux<String> getPlaylistForUser(String id) {
        return reactiveMongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Playlist.class)
                .flatMapMany(playlist -> Flux.fromIterable(playlist.getTrackIds()))
                .switchIfEmpty(Flux.empty());
    }
}

