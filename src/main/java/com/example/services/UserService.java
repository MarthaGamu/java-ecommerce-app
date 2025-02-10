package com.example.services;

import com.example.pojo.Customers;
import com.example.util.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public Customers insertUser(Customers customers){
        return repo.save(customers);
    }
}

