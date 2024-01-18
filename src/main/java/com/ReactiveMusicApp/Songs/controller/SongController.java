package com.ReactiveMusicApp.Songs.controller;


import com.ReactiveMusicApp.Songs.model.Song;
import com.ReactiveMusicApp.Songs.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/songs")
public class SongController {

        private final SongService musicService;

        public SongController(SongService musicService) {
            this.musicService = musicService;
        }

        @GetMapping("/tracks")
        public String getAllTracks(Model model) {
            Flux<Song> musicTracks = musicService.getAllMusicTracks();
            model.addAttribute("musicTracks", musicTracks);
            return "tracks";
        }

        @GetMapping("/playlist")
        public String getUserPlaylist(Model model) {
            String userId = "exampleUserId";
            Flux<String> playlist = musicService.getPlaylistForUser(userId);
            model.addAttribute("playlist", playlist);
            return "playlist";
        }
}

