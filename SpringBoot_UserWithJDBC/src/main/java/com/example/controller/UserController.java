package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addingUser(@RequestBody User user) {
        return userService.addingUserToJDBC(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserByID(id);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUser/{id}")
    public String updateUserById(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

}
