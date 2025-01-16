package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public String addingUser(UserDto userDto);

    public Optional<User> getUserByID(Integer id);

    public List<User> getAllUser();

    public String deleteUserById(Integer id);

    public String updateUserById(Integer id, User user);
}
