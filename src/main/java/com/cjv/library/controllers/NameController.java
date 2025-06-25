package com.cjv.library.controllers;

import com.cjv.library.models.Name;
import com.cjv.library.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "names")
public class NameController {

    private final NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/")
    public List<Name> getNames() {
        return nameService.getNames();
    }

    @GetMapping("/find")
    public Name getSpecificName(@RequestParam String name) {
        return nameService.getSearchedNames(name);
    }

    @PostMapping
    public ResponseEntity<Integer> addName(@RequestBody Name name) {
        int result = nameService.addName(name);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updateName(@RequestBody Name name) {
        int result = nameService.updateName(name);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Integer> deleteName(@RequestBody String name) {
        int result = nameService.deleteName(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
