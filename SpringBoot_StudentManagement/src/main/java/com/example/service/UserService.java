package com.example.service;

import com.example.auth.AuthRequest;
import com.example.entity.User;

import java.util.Optional;

public interface UserService {
    public String userRegister(User user);

    public Optional<User> userLogin(AuthRequest authRequest);
}
