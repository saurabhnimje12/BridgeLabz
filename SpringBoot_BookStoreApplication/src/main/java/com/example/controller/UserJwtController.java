package com.example.controller;

import com.example.dto.DtoToUserEntity;
import com.example.dto.UserEntityToDto;
import com.example.exception.CustomiseException;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userApi")
public class UserJwtController {
    private UserService userService;

    public UserJwtController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserEntityToDto> getUser(@RequestAttribute("userId") Long userId) {
        return new ResponseEntity<UserEntityToDto>(userService.getUser(userId), HttpStatus.OK);
    }

    @PatchMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestAttribute("userId") Long userId, @RequestBody DtoToUserEntity dtoToUserEntity) {
        return new ResponseEntity<String>(userService.updateUser(userId, dtoToUserEntity), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestAttribute("userId") Long userId) {
        return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteByAdmin/{userId}")
    public ResponseEntity<String> deleteUserByAdmin(@RequestAttribute("role") String role, @PathVariable Long userId) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Admin to Delete User!!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserEntityToDto>> getAllUser(@RequestAttribute("role") String role) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<List<UserEntityToDto>>(userService.getAllUser(), HttpStatus.OK);
        } else {
            throw new CustomiseException("NOT Valid to Access");
        }
    }
}
