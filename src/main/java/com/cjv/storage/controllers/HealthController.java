package com.cjv.storage.controllers;

import com.cjv.storage.models.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "health")
public class HealthController {

    private final ConfigProperties configProperties;

    @Autowired
    public HealthController(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/ping")
    public ResponseEntity<ConfigProperties> ping() {
        return new ResponseEntity<>(this.configProperties, HttpStatus.CREATED);
    }
}
