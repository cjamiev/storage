package com.cjv.storage.controllers;

import com.cjv.storage.models.Location;
import com.cjv.storage.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewLocation(@RequestBody Location location) {
        int result = locationService.addNewLocation(location);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
