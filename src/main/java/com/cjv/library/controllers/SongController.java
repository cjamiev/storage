package com.cjv.library.controllers;

import com.cjv.library.models.Song;
import com.cjv.library.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/find")
    public Song getSpecificSong(@RequestParam String id) {
        return songService.getSearchedSongs(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addSong(@RequestBody Song song) {
        int result = songService.addSong(song);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateSong(@RequestBody Song song) {
        int result = songService.updateSong(song);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Integer> deleteSong(@RequestBody String id) {
        int result = songService.deleteSong(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
