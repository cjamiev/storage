package com.cjv.library.services;

import com.cjv.library.models.Game;
import com.cjv.library.repository.GameRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Game> getGames() {
        String sql = "SELECT * FROM main.games";

        return jdbcTemplate.query(sql, new GameRowMapper());
    }

    public Game getSearchedGames(String game) {
        String sql = "SELECT * FROM main.games WHERE name = ?";

        Optional<Game> retrievedGame = jdbcTemplate.query(sql, new GameRowMapper(), game).stream().findFirst();

        return retrievedGame.orElse(Game.getEmptyGame());
    }

    public int addGame(Game game) {
        String sql = "INSERT INTO main.games(name, genre, price, lowest_price, interest, release_date, notes) VALUES (?, ?, ?, ?, ?, ?, ?);";

        return jdbcTemplate.update(sql, game.getName(), game.getGenre(), game.getPrice(), game.getLowestPrice(), game.getLowestPrice(), game.getInterest(), game.getReleaseDate(), game.getNotes());
    }

    public int updateGame(Game game) {
        String sql = "UPDATE main.games SET genre=?, price=?, lowest_price=?, interest=?, release_date=?, notes=? WHERE name=?";

        return jdbcTemplate.update(sql, game.getGenre(), game.getPrice(), game.getLowestPrice(), game.getLowestPrice(), game.getInterest(), game.getReleaseDate(), game.getNotes(), game.getName());
    }

    public int deleteGame(String name) {
        String sql = "DELETE FROM main.games WHERE name = ?";

        return jdbcTemplate.update(sql, name);
    }
}
