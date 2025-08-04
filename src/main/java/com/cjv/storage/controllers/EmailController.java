package com.cjv.storage.controllers;

import com.cjv.storage.models.Email;
import com.cjv.storage.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewEmail(@RequestBody Email email) {
        int result = emailService.addNewEmail(email);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
