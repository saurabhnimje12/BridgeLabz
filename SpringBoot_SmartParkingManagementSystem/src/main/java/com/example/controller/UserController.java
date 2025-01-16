package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return new ResponseEntity<String>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> viewUserDetails(@PathVariable Integer userId) {
        return new ResponseEntity<User>(userService.viewUserDetails(userId), HttpStatus.OK);
    }

    @PatchMapping("/patchUserById/{userId}")
    public ResponseEntity<String> updateUserInfo(@PathVariable Integer userId, @RequestBody User user) {
        return new ResponseEntity<String>(userService.UpdateUserInfo(userId, user), HttpStatus.OK);
    }
}








// update only single field
