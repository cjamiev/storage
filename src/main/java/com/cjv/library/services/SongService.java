package com.cjv.library.services;

import com.cjv.library.models.Song;
import com.cjv.library.repository.SongRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SongService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Song> getSongs() {
        String sql = "SELECT * FROM main.songs";

        return jdbcTemplate.query(sql, new SongRowMapper());
    }

    public Song getSearchedSongs(String id) {
        String sql = "SELECT * FROM main.songs WHERE id = ?";

        Optional<Song> retrievedSong = jdbcTemplate.query(sql, new SongRowMapper(), id).stream().findFirst();

        return retrievedSong.orElse(Song.getEmptySong());
    }

    public int addSong(Song song) {
        String sql = "INSERT INTO main.songs(id, name, album, platforms, interest, link) VALUES (?, ?, ?, ?, ?, ?);";

        return jdbcTemplate.update(sql, song.getId(), song.getName(), song.getAlbum(), song.getPlatforms(), song.getInterest(), song.getLink());
    }

    public int updateSong(Song song) {
        String sql = "UPDATE main.songs SET name=?, album=?, platforms=?, interest=?, link=? WHERE id=?";

        return jdbcTemplate.update(sql, song.getName(), song.getAlbum(), song.getPlatforms(), song.getInterest(), song.getLink(), song.getId());
    }

    public int deleteSong(String id) {
        String sql = "DELETE FROM main.songs WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
}