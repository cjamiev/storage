package com.cjv.library.repository;

import com.cjv.library.models.Song;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper implements RowMapper<Song> {
    @Override
    public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");
        String name = rs.getString("name");
        String album = rs.getString("album");
        String platforms = rs.getString("album");
        String interest = rs.getString("interest");
        String link = rs.getString("link");

        return new Song(id, name, album, platforms, interest, link);
    }
}


