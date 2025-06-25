package com.cjv.library.controllers;

import com.cjv.library.models.Word;
import com.cjv.library.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "words")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
    public List<Word> getWords() {
        return wordService.getWords();
    }

    @GetMapping("/find")
    public Word getSpecificWord(@RequestParam String name) {
        return wordService.getSearchedWords(name);
    }

    @PostMapping
    public ResponseEntity<Integer> addWord(@RequestBody Word word) {
        int result = wordService.addWord(word);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateWord(@RequestBody Word word) {
        int result = wordService.updateWord(word);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Integer> deleteWord(@RequestBody String name) {
        int result = wordService.deleteWord(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
