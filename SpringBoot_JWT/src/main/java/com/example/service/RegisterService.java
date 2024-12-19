package com.example.service;

import com.example.entity.LoginRequest;
import com.example.entity.Register;

import java.util.Optional;

public interface RegisterService {
    public String registerUser(Register registerRequest);

    Optional<Register> userLogin(LoginRequest loginRequest);
}
