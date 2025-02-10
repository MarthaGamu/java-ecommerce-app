package com.example.controllers;

import com.example.pojo.Admin;
import com.example.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService service;

    @PostMapping("/add")

    public Admin insert(@RequestBody Admin admin){
        return service.insertAdmin(admin);
    }
}


