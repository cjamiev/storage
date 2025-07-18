package com.cjv.storage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "health")
public class HealthController {

    @GetMapping("/ping")
    public ResponseEntity<Integer> ping() {
        return new ResponseEntity<>(1, HttpStatus.CREATED);
    }
}
