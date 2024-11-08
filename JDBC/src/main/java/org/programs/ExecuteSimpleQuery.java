package org.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExecuteSimpleQuery {

    public Connection eastablishedConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/JDBCTest";
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        ExecuteSimpleQuery esq = new ExecuteSimpleQuery();

        // SQL query to retrieve all records from the "employees" table
        String sqlQuery = "SELECT * FROM employee";

        try {
            // Establish connection and execute query
            Connection connection = esq.eastablishedConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();


            System.out.println("Connection to company_db established successfully.");
            System.out.println("Employee Records:");

            // Retrieve and print details of each record
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");

                System.out.printf("ID: %d, Name: %s, Age: %d, Salary: %.2f%n", id, name, age, salary);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
