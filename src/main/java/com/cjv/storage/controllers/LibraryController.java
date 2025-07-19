package com.cjv.storage.controllers;

import com.cjv.storage.models.Library;
import com.cjv.storage.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/backup")
    public ResponseEntity<Integer> backupLibrary(@RequestParam String type) {
        int result = libraryService.backupLibrary(type);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/specific-type")
    public Library getSpecificType(@RequestParam String type) {
        return libraryService.getSpecificType(type);
    }

    @PostMapping("/new-type")
    public ResponseEntity<Integer> addNewTypeToLibrary(@RequestBody Library library) {
        int result = libraryService.addNewTypeToLibrary(library.getType());

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update-records")
    public ResponseEntity<Integer> updateRecordsInLibrary(@RequestBody Library library) {
        int result = libraryService.updateRecordsInLibrary(library);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
