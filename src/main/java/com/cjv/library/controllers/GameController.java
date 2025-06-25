package com.cjv.library.controllers;

import com.cjv.library.models.Game;
import com.cjv.library.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/find")
    public Game getSpecificGame(@RequestParam String name) {
        return gameService.getSearchedGames(name);
    }

    @PostMapping
    public ResponseEntity<Integer> addGame(@RequestBody Game game) {
        int result = gameService.addGame(game);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateGame(@RequestBody Game game) {
        int result = gameService.updateGame(game);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Integer> deleteGame(@RequestBody String name) {
        int result = gameService.deleteGame(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
