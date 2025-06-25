package com.cjv.library.services;

import com.cjv.library.models.Show;
import com.cjv.library.repository.ShowRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShowService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Show> getShows() {
        String sql = "SELECT * FROM main.shows";

        return jdbcTemplate.query(sql, new ShowRowMapper());
    }

    public Show getSearchedShows(String show) {
        String sql = "SELECT * FROM main.shows WHERE name = ?";

        Optional<Show> retrievedShow = jdbcTemplate.query(sql, new ShowRowMapper(), show).stream().findFirst();

        return retrievedShow.orElse(Show.getEmptyShow());
    }

    public int addShow(Show show) {
        String sql = "INSERT INTO main.shows(name, genre, platforms, is_film) VALUES (?, ?, ?, ?);";

        return jdbcTemplate.update(sql, show.getName(), show.getGenre(), show.getPlatforms(), show.getIsFilm());
    }

    public int updateShow(Show show) {
        String sql = "UPDATE main.shows SET genre=?, platforms=?, is_film=? WHERE name=?";

        return jdbcTemplate.update(sql, show.getGenre(), show.getPlatforms(), show.getIsFilm(), show.getName());
    }

    public int deleteShow(String name) {
        String sql = "DELETE FROM main.shows WHERE name = ?";

        return jdbcTemplate.update(sql, name);
    }
}
