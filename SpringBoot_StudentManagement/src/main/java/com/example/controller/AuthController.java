package com.example.controller;

import com.example.auth.AuthRequest;
import com.example.auth.AuthResponse;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.TokenUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserService userService;
    private TokenUtility tokenUtility;

    public AuthController(UserService userService, TokenUtility tokenUtility) {
        this.userService = userService;
        this.tokenUtility = tokenUtility;
    }

    @GetMapping("/test")
    public  String test(){
        return "Spring-boot : Auth Controller";
    }

    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody User user) {
        return new ResponseEntity<String>(userService.userRegister(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody AuthRequest authRequest) {
        Optional<User> user = userService.userLogin(authRequest);
        if (user.isPresent()) {
            return ResponseEntity.ok(new AuthResponse(tokenUtility.createToken(user.get().getUserId(), user.get().getRole())));
        } else {
            return new ResponseEntity<>("Token Not Valid", HttpStatus.UNAUTHORIZED);
        }
    }
}
