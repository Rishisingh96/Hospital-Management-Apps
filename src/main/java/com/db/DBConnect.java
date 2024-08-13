package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection Connection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospital-management-system";
        String user = "root";
        String pass = "Rishi@9838";

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.", e);
        }

        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = Connection();
        if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Failed to establish connection");
        }
    }
}
