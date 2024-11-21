package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String addingUser(UserDto userDto) {
        if (userDto != null) {
            try {
                User user = new User(userDto);
                userRepo.save(user);
                return "User Added Successfully";
            } catch (Exception exception) {
                log.info("Info level");
                return "Exception : " + exception.getMessage();
            }
        }
        log.error("User Failed To Add");
        return "User Failed To Add";
    }

    @Override
    public Optional<User> getUserByID(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public String deleteUserById(Integer id) {
        Optional<User> userByID = getUserByID(id);
        if (userByID.isPresent()) {
            userRepo.deleteById(id);
            return "User Deleted Successfully";
        }
        log.error("Id NOT Found For Delete");
        return "User Not Found with ID : " + id;
    }

    @Override
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
        log.error("Id NOT Found For Update");
        return "User ID NOT Found : " + id;
    }
}
