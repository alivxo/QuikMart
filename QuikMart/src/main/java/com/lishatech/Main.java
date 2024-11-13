package com.lishatech; // Package declaration

import org.apache.camel.CamelContext; // Importing CamelContext class from Apache Camel
import org.apache.camel.component.jdbc.JdbcComponent; // Importing JdbcComponent class from Apache Camel
import org.apache.camel.impl.DefaultCamelContext; // Importing DefaultCamelContext class from Apache Camel
import org.apache.commons.dbcp2.BasicDataSource; // Importing BasicDataSource class from Apache Commons DBCP

import java.sql.Connection; // Importing Connection class from java.sql package
import java.sql.DriverManager; // Importing DriverManager class from java.sql package
import java.sql.SQLException; // Importing SQLException class from java.sql package

public class Main { // Defining Main class
    public static void main(String[] args) { // Main method

        // Create Camel Context
        CamelContext context = new DefaultCamelContext(); // Creating an instance of DefaultCamelContext

        // Configure MySQL DataSource
        String url = "jdbc:mysql://localhost:3306/SushQuikMart"; // Defining the database URL
        String username = "root"; // Defining the database username
        String password = "YUm15510n"; // Defining the database password

        // Add JDBC Component to Camel Context
        JdbcComponent jdbc = new JdbcComponent(); // Creating an instance of JdbcComponent
        javax.sql.DataSource dataSource = new BasicDataSource(); // Creating an instance of BasicDataSource
        ((BasicDataSource) dataSource).setUrl(url); // Setting the database URL on the data source
        ((BasicDataSource) dataSource).setUsername(username); // Setting the database username on the data source
        ((BasicDataSource) dataSource).setPassword(password); // Setting the database password on the data source
        jdbc.setDataSource(dataSource); // Setting the data source on the JDBC component
        context.addComponent("my-jdbc", jdbc); // Adding the JDBC component to the Camel context

        try { // Try block to handle potential SQL exceptions
            Connection connection = DriverManager.getConnection(url, username, password); // Establishing a connection to the database
            System.out.println("Connected to the database!"); // Printing a success message
        } catch (SQLException e) { // Catch block to handle SQL exceptions
            System.out.println("Oops, there was an error connecting to the database."); // Printing an error message
            e.printStackTrace(); // Printing the stack trace of the exception
        }
    }
}