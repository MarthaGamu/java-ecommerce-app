package com.example.controller;

import com.example.common.ApiResponse;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(new ApiResponse(true, "User has been added"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "User not found"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByid/{id}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("id") int id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteUserById(id);
            return new ResponseEntity<>(new ApiResponse(true, "Deleted the user " + id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "User not found"), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable("id") int id, @RequestBody @Valid User user) {
        Optional<User> existingUser = userService.findById(id);
        if (existingUser.isPresent()) {
            user.setId(id);
            userService.saveUser(user);
            return new ResponseEntity<>(new ApiResponse(true, "User has been updated"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(false, "User not found"), HttpStatus.NOT_FOUND);
        }
    }
}
