package com.example.service;

import com.example.entity.User;

public interface UserService {
    String addUser(User user);

    User viewUserDetails(Integer userId);

    String UpdateUserInfo(Integer userId, User user);
}
