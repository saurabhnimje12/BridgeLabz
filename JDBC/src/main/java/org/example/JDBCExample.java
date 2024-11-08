package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class JDBCExample {

    public Connection getConnections() throws Exception {
        String url = "jdbc:mysql://localhost:3306/JDBCTest";
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public void createTable() {
        String sqlQueary = "create table employee(id int primary key, name varchar(50), age int, salary double)";
        try (Connection connection = getConnections();
             Statement statement = connection.createStatement();
        ) {
            int rows = statement.executeUpdate(sqlQueary);
            System.out.println("Table created Successfully : " + rows);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void createEmployee(Employee employee) {
        String sqlQuery = "insert into employee(id,name,age,salary) values (?,?,?,?)";
        try (Connection connection = getConnections();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setDouble(4, employee.getSalary());

            int rows = preparedStatement.executeUpdate();
            System.out.println("Employee added successfully");
            System.out.println("Rows Effected: " + rows);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void readEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        String sqlQuery = "select * from employee";
        try (Connection connection = getConnections();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            // Retrieve each employee's data from the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");

                // Create an Employee object and add it to the list
                Employee employee = new Employee(id, name, age, salary);
                employeeList.add(employee);

                // Print employee details
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

