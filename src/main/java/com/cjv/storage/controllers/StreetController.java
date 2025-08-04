package com.cjv.storage.controllers;

import com.cjv.storage.models.Street;
import com.cjv.storage.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "street")
public class StreetController {

    private final StreetService streetService;

    @Autowired
    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("/")
    public List<Street> getAllStreets() {
        return streetService.getAllStreets();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewStreet(@RequestBody Street street) {
        int result = streetService.addNewStreet(street);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
