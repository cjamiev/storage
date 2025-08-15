package com.cjv.storage.controllers;

import com.cjv.storage.models.Url;
import com.cjv.storage.services.UrlService;
import com.cjv.storage.utils.EncodeAndDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "url")
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public List<Url> getAllUrls() {
        return urlService.getAllUrls();
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addNewUrl(@RequestBody Url url) {
        int result = urlService.addNewUrl(url);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Integer> updateUrl(@RequestBody Url url) {
        int result = urlService.updateUrl(url);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUrl(@PathVariable("id") String id) {
        EncodeAndDecode decoder = new EncodeAndDecode();
        String urlId = decoder.decodeStr(id);
        int result = urlService.deleteUrl(urlId);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
