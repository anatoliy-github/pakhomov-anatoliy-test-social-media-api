package com.pakhomov.socialmedia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BasicController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> mainPage() {
        return new ResponseEntity<>("{\n\"API Documentation\": \"/doc\",\n\"User registration\": \"/api/auth/register\",\n\"User login\": \"/api/auth/login\",\n\"User logout\": \"/api/auth/logout\"\n}", HttpStatus.OK);
    }
}
