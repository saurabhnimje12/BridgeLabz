package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap;

    public UserService() {
        userMap = new HashMap<>();
        userMap.put(101, new User(101, "Alice", 25, "NewYork"));
        userMap.put(102, new User(102, "Bob", 30, "LosAngeles"));
        userMap.put(103, new User(103, "Charlie", 25, "Chicago"));
        userMap.put(104, new User(104, "David", 25, "NewYork"));
        userMap.put(105, new User(105, "Eve", 22, "NewYork"));
    }

    public User filterUsers(Integer id) {
        return userMap.get(id);
    }
}
