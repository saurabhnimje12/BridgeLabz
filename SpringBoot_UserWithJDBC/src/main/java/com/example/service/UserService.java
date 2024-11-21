package com.example.service;


import com.example.entity.User;
import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String addingUserToJDBC(User user) {
        String mesg;
        if (user == null) {
            return "User Failed To Add";
        }
        String sqlQuery = "insert into users(id,name,age,city) values (?,?,?,?)";
        try (Connection connection = userRepo.establishConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getCity());
            preparedStatement.executeUpdate();
            return "User Added Successfully";
        } catch (Exception exception) {
            mesg = "Exception : " + exception.getMessage();
        }
        return mesg;
    }

    public User getUserByID(Integer id) {
        String sqlQuery = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (Connection connection = userRepo.establishConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("city")
                );
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sqlQuery = "SELECT * FROM users";
        try (Connection connection = userRepo.establishConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("city")
                );
                users.add(user);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public String deleteUserById(Integer id) {
        String mesg;
        String sqlQuery = "DELETE FROM users WHERE id = ?";
        try (Connection connection = userRepo.establishConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            mesg = "User Deleted Successfully";
        } catch (Exception exception) {
            mesg = "Exception : " + exception.getMessage();
        }
        return mesg;
    }

    public String updateUserById(Integer id, User user) {
        String mesg;
        if (id == null || user == null) {
            return "Invalid User Data for Update";
        }
        // SQL Query to check if the user exists
        String checkQuery = "SELECT COUNT(*) FROM users WHERE id = ?";
        String updateQuery = "UPDATE users SET name = ?, age = ?, city = ? WHERE id = ?";
        try (Connection connection = userRepo.establishConnection();
             PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

            // Setting the ID parameter for the check query
            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();

            // Check if user exists
            if (rs.next() && rs.getInt(1) == 0) {
                return "Invalid ID: User not found with ID " + id;
            }
            updateStmt.setString(1, user.getName());
            updateStmt.setInt(2, user.getAge());
            updateStmt.setString(3, user.getCity());
            updateStmt.setInt(4, id);
            updateStmt.executeUpdate();
            mesg = "User Updated Successfully";
        } catch (Exception exception) {
            mesg = "Exception : " + exception.getMessage();
        }
        return mesg;
    }

}
