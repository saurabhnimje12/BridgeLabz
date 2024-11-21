package com.example.service;

import com.example.entity.User;
import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String addingUser(User user) {
        if (user != null) {
            try {
                userRepo.save(user);
                return "User Added Successfully";
            } catch (Exception exception) {
                return "Exception : " + exception.getMessage();
            }
        }
        return "User Failed To Add";
    }

    public Optional<User> getUserByID(Integer id) {
        return userRepo.findById(id);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public String deleteUserById(Integer id) {
        Optional<User> userByID = getUserByID(id);
        if (userByID.isPresent()) {
            userRepo.deleteById(id);
            return "User Deleted Successfully";
        }
        return "User Not Found with ID : " + id;
    }

    public String updateUserById(Integer id, User user) {
        String str;
        Optional<User> userByID = getUserByID(id);
        if (userByID.isPresent()) {
            User user1 = userByID.get();
            user1.setName(user.getName());
            user1.setAge(user.getAge());
            user1.setCity(user.getCity());
            userRepo.save(user1);
            str = "User Updated Successfully";
        }
        return "User ID NOT Found : " + id;
    }
}
