package com.auth.controllers;

import com.auth.entities.Users;
import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("Registration successful!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}