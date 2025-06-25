package com.cjv.library.repository;

import com.cjv.library.models.Game;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRowMapper implements RowMapper<Game> {
    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String genre =  rs.getString("genre");
        String price = rs.getString("price");
        String lowest_price = rs.getString("price");
        String interest = rs.getString("interest");
        String release_date = rs.getString("release_date");
        String notes = rs.getString("notes");

        return new Game(name, genre, price, lowest_price, interest, release_date, notes);
    }
}

