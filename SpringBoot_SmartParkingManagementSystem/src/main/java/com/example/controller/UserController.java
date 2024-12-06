package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<String> addUser(User user) {
        return new ResponseEntity<String>(userService.addUser(user), HttpStatus.OK);
    }

    public ResponseEntity<User> viewUserDetails(Integer userId) {
        return new ResponseEntity<User>(userService.viewUserDetails(userId), HttpStatus.OK);
    }

    public ResponseEntity<String> updateUserInfo(Integer userId, User user) {
        return new ResponseEntity<String>(userService.UpdateUserInfo(userId, user);
    }
}
