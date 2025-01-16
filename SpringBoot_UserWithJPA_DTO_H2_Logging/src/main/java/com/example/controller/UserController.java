package com.example.controller;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addingUser(@RequestBody UserDto userDto) {
        return userService.addingUser(userDto);
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> userByID = userService.getUserByID(id);
        if (userByID.isPresent()) {
            User user = userByID.get();
            return user;
        } else return null;
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
