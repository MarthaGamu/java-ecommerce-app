package com.example.controllers;

import com.example.pojo.Customers;
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
    public Customers insert(@RequestBody Customers customers){
        return service.insertUser(customers);
    }
}


