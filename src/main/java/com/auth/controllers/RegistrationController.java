package com.auth.controllers;

import com.auth.entities.Role;
import com.auth.entities.Users;
import com.auth.repos.RoleRepository;
import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody Users user) {
        try {
            Role defaultRole = roleRepository.findByRole("USER");
            user.setRoles(Collections.singletonList(defaultRole));
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}