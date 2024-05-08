package com.auth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.auth.entities.Users;
import com.auth.repos.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {
    @Autowired
    UserRepository userRep;

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Users> getAllUsers() {
        return userRep.findAll();
    }
}
