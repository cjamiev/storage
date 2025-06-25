package com.cjv.library.controllers;

import com.cjv.library.models.Show;
import com.cjv.library.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "shows")
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/")
    public List<Show> getShows() {
        return showService.getShows();
    }

    @GetMapping("/find")
    public Show getSpecificShow(@RequestParam String name) {
        return showService.getSearchedShows(name);
    }

    @PostMapping
    public ResponseEntity<Integer> addShow(@RequestBody Show show) {
        int result = showService.addShow(show);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateShow(@RequestBody Show show) {
        int result = showService.updateShow(show);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Integer> deleteShow(@RequestBody String name) {
        int result = showService.deleteShow(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
