package com.example.service;

import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String addUser(User user) {
        userRepo.save(user);
        return "User Added Successfully";
    }

    @Override
    public User viewUserDetails(Integer userId) {
        return userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User NOT Found With ID : " + userId));
    }

    @Override
    public String UpdateUserInfo(Integer userId, User user) {
        User user1 = viewUserDetails(userId);
        if (user != null) {
            user1.setUserName(user.getUserName());
            user1.setUserEmail(user.getUserEmail());
            user1.setUserPhoneNo(user.getUserPhoneNo());

            List<String> collect = user1.getRegisteredVehicles()
                    .stream()
                    .filter(user.getRegisteredVehicles()::contains)
                    .collect(Collectors.toList());
            user1.setRegisteredVehicles(collect);
            user1.setReservations(user.getReservations());
            userRepo.save(user1);
            return "User Updated Successfully";

        } else return "User Not Found With Id : " + userId;
    }
}
