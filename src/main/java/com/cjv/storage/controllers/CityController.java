package com.cjv.storage.controllers;

import com.cjv.storage.models.City;
import com.cjv.storage.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewCity(@RequestBody City city) {
        int result = cityService.addNewCity(city);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Integer> updateCity(@RequestBody City city) {
        int result = cityService.updateCity(city);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCity(@PathVariable("id") String id) {
        int result = cityService.deleteCity(id);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
