package org.example;

import java.sql.SQLException;

public class DataBaseConnectivity {
    public static void main(String[] args) throws Exception {
        JDBCExample jdbcExample = new JDBCExample();

        // Establish the connection
        jdbcExample.getConnections();
        System.out.println("Connection SuccessFully : ");

        // Create the table
        jdbcExample.createTable();

        // Insert employee records
        jdbcExample.createEmployee(new Employee(1, "John", 25, 55000));
        jdbcExample.createEmployee(new Employee(2, "Smith", 20, 89000));
        jdbcExample.createEmployee(new Employee(3, "Victoria", 19, 35000));
        jdbcExample.createEmployee(new Employee(4, "Josh", 30, 60000));
        jdbcExample.createEmployee(new Employee(5, "Alina", 24, 45000));

        // Get all employee's records
        jdbcExample.readEmployee();

    }
}
