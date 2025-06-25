package com.cjv.library.repository;

import com.cjv.library.models.Show;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowRowMapper implements RowMapper<Show> {
    @Override
    public Show mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String genre = rs.getString("genre");
        String platforms = rs.getString("genre");
        boolean isFilm = rs.getBoolean("is_film");

        return new Show(name, genre, platforms, isFilm);
    }
}
