package com.example.controllers;

import com.example.pojo.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
    UserService service;

    @PostMapping("/insertall")
    public User insert(@RequestBody User user){
        return service.insertUser(user);
    }
}


