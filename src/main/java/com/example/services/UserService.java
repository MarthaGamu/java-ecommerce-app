package com.example.services;

import com.example.pojo.User;
import com.example.util.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public User insertUser(User user){
        return repo.save(user);
    }
}

