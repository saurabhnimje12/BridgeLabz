package com.example.controller;

import com.example.entity.JwtResponse;
import com.example.entity.LoginRequest;
import com.example.entity.Register;
import com.example.service.RegisterService;
import com.example.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RegistrationController {
    @Autowired
    private TokenUtility tokenUtility;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Register register) {
        try {
            String message = registerService.registerUser(register);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // 409 Conflict
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Registration failed due to an unexpected error.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Optional<Register> login = registerService.userLogin(loginRequest);
        if (login.isPresent()) {
            return ResponseEntity.ok(new JwtResponse(tokenUtility.createToken(login.get().getUserId(), login.get().getRole())));
        } else {
            return new ResponseEntity<>("User login not successfully", HttpStatus.ACCEPTED);
        }
    }

}
