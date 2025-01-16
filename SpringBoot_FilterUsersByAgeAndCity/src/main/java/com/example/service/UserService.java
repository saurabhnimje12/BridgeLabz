package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1, "Alice", 25, "NewYork"));
        users.add(new User(2, "Bob", 30, "LosAngeles"));
        users.add(new User(3, "Charlie", 25, "NewYork"));
        users.add(new User(4, "Diana", 28, "Chicago"));
    }

    public List<User> filterUsers(Integer age, String city) {
        return users.stream()
                .filter(user -> (age == null || user.getAge() == age))
                .filter(user -> (city == null || user.getCity().equalsIgnoreCase(city)))
                .collect(Collectors.toList());
    }
}
