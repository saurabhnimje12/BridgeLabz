# JDBC (Java Database Connectivity) 💻

This branch contains examples and programs related to **JDBC** (Java Database Connectivity).  
JDBC is an API that allows Java applications to connect and interact with relational databases like MySQL, PostgreSQL, Oracle, etc.

---

## 📘 Topics Covered

- Introduction to JDBC
- JDBC Architecture
- Setting up Database Connection
- CRUD Operations (Create, Read, Update, Delete)
- PreparedStatement vs Statement
- CallableStatement (Stored Procedures)
- Transactions in JDBC
- Batch Processing
- ResultSet and Metadata
- Exception Handling in JDBC

---

## ⚙️ Prerequisites

Before running these programs, ensure you have:

- Java JDK installed (version 8 or higher)
- A relational database (e.g., MySQL/PostgreSQL/Oracle)
- JDBC driver for your database (e.g., `mysql-connector-java.jar` for MySQL)

---

## ▶️ How to Run

1. Clone the repository and switch to the `jdbc` branch:
   ```bash
   git checkout jdbc


Examples:

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
