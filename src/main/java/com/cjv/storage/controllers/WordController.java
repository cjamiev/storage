package com.cjv.storage.controllers;

import com.cjv.storage.models.Word;
import com.cjv.storage.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "word")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewWord(@RequestBody Word word) {
        int result = wordService.addNewWord(word);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteWord(@PathVariable("id") String id) {
        int result = wordService.deleteWord(id);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
