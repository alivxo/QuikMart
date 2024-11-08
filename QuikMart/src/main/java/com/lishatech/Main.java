package com.lishatech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/SushQuikMart";
        String username = "root";
        String password = "YUm15510n";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Oops, there was an error connecting to the database.");
            e.printStackTrace();
        }


    }
}