package com.ReactiveMusicApp.Songs.repository;

import com.ReactiveMusicApp.Songs.model.Song;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;



public interface PlaylistRepository extends ReactiveMongoRepository<Song,String> {
}