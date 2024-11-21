package com.example.repo;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
@Repository
public class UserRepo {
    public static Connection establishConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/sb_users";
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }
}
