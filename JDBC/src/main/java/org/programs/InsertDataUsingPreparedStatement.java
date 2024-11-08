package org.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class InsertDataUsingPreparedStatement {

    public static Connection eastablishedConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/inventory_db";
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public void createTable() {
        String sqlQueary = "create table employee(productId int primary key, name varchar(50), price double, quantity int)";
        try (Connection connection = eastablishedConnection();
             Statement statement = connection.createStatement();
        ) {
            int rows = statement.executeUpdate(sqlQueary);
            System.out.println("Table created Successfully : " + rows);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void insertData(Product product) {
        String sqlQuery = "insert into employee(productId,name,price,quantity) values (?,?,?,?)";
        try (Connection connection = eastablishedConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());

            int rows = preparedStatement.executeUpdate();
            System.out.println("Employee added successfully");
            System.out.println("Rows Effected: " + rows);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InsertDataUsingPreparedStatement idps = new InsertDataUsingPreparedStatement();
        idps.createTable();
        idps.insertData(new Product(1, "Laptop", 25, 55000));
        idps.insertData(new Product(2, "Mobile", 20, 89000));
        idps.insertData(new Product(3, "PS5", 19, 35000));
        idps.insertData(new Product(4, "Tablet", 30, 60000));
        idps.insertData(new Product(5, "Headphone", 10, 45000));
    }
}
