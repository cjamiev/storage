package com.cjv.storage.controllers;

import com.cjv.storage.models.Random;
import com.cjv.storage.services.RandomService;
import com.cjv.storage.utils.EncodeAndDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "random")
public class RandomController {

    private final RandomService randomService;

    @Autowired
    public RandomController(RandomService randomService) {
        this.randomService = randomService;
    }

    @GetMapping("/")
    public List<Random> getAllRandoms() {
        return randomService.getAllRandoms();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewRandom(@RequestBody Random random) {
        int result = randomService.addNewRandom(random);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteRandom(@PathVariable("id") String id) {
        int result = randomService.deleteRandom(id);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
