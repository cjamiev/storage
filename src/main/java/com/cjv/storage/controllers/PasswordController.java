package com.cjv.storage.controllers;

import com.cjv.storage.models.Password;
import com.cjv.storage.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "password")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/backup")
    public ResponseEntity<Integer> backupPassword() {
        int result = passwordService.backupPasswords();
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Password> getAllPasswords() {
        return passwordService.getAllPasswords(true);
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewPassword(@RequestBody Password password) {
        int result = passwordService.addNewPassword(password);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Integer> updatePassword(@RequestBody Password password) {
        int result = passwordService.updatePassword(password);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
