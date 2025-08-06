package com.cjv.storage.controllers;

import com.cjv.storage.models.Name;
import com.cjv.storage.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "name")
public class NameController {

    private final NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/")
    public List<Name> getAllNames() {
        return nameService.getAllNames();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewName(@RequestBody Name name) {
        int result = nameService.addNewName(name);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteName(@PathVariable("id") String id) {
        int result = nameService.deleteName(id);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
