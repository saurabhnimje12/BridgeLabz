package org.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class EstablishBasicConnection {

    public Connection establishConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/JDBCTest";
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            EstablishBasicConnection ejbc = new EstablishBasicConnection();
            ejbc.establishConnection();
            System.out.println("Connection Successfully!!");
        } catch (Exception exception) {
            System.out.println("Connection NOT Established!!");
            exception.printStackTrace();
        }
    }
}
