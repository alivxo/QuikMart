package com.lishatech.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {


    private static final String URL = "jdbc:mysql://localhost:3306/SushQuikMart";
    private static final String USER = "root";
    private static final String PASSWORD = "YUm15510n";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
