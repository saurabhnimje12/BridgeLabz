package com.example.service;

import com.example.dto.DtoToUserEntity;
import com.example.dto.UserEntityToDto;
import com.example.dto.UserLoginRequestDto;
import com.example.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String userRegistration(DtoToUserEntity dtoToUserEntity);

    Optional<User> loginService(UserLoginRequestDto userLoginRequestDto);

    UserEntityToDto getUser(Long userId);

    String updateUser(Long userId, DtoToUserEntity dtoToUserEntity);

    String deleteUser(Long userId);

    List<UserEntityToDto> getAllUser();
}
