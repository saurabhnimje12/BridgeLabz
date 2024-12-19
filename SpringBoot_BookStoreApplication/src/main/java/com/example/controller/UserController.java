package com.example.controller;

import com.example.dto.DtoToUserEntity;
import com.example.dto.UserLoginRequestDto;
import com.example.entity.JwtResponse;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TokenUtility tokenUtility;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/userRegistration")
    public ResponseEntity<String> userRegistration(@RequestBody DtoToUserEntity dtoToUserEntity) {
        return new ResponseEntity<String>(userService.userRegistration(dtoToUserEntity), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        Optional<User> userOptional = userService.loginService(userLoginRequestDto);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(new JwtResponse(tokenUtility.createToken(userOptional.get().getUserId(), userOptional.get().getRole())));
        } else {
            return new ResponseEntity<>("User login not successfully", HttpStatus.ACCEPTED);
        }
    }
}