package com.example.serviceImpl;

import com.example.auth.AuthRequest;
import com.example.entity.User;
import com.example.repo.UserRepo;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String userRegister(User user) {
        Optional<User> getUser = userRepo.findByUserName(user.getUserName());
        if (getUser.isPresent()) {
            return "User Already Exist | Try With Different UserName";
        }
        userRepo.save(user);
        return "User Register Successfully||";
    }

    @Override
    public Optional<User> userLogin(AuthRequest authRequest) {
        return userRepo.findByUserNameAndUserPwd(authRequest.getUserName(), authRequest.getUserPwd());
    }
}
