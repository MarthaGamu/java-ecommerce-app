package com.example.services;

import  com.example.pojo.Admin;
import  com.example.util.Adminrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    Adminrepo repo;

    public Admin insertAdmin(Admin admin){
        return  repo.save(admin);
    }
}


