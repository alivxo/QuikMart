package com.lishatech.product; // Package declaration

import org.apache.camel.builder.RouteBuilder; // Importing RouteBuilder class from Apache Camel
import java.util.Map; // Importing Map class from java.util package

public class ProductRouteBuilder extends RouteBuilder { // Defining ProductRouteBuilder class extending RouteBuilder

    @Override
    public void configure() { // Overriding configure method
        from("timer://fetchProduct?period=10000") // Setting up a route to trigger every 10 seconds
                .setBody(constant("SELECT ItemNumber, ItemName, Quantity, Price FROM JapaneseQuikMart")) // Setting the body of the message to a SQL query
                .to("jdbc:default") // Sending the message to the JDBC component
                .split(body()) // Splitting the result set
                .process(exchange -> { // Processing each row of the result set
                    Map<String, Object> row = exchange.getIn().getBody(Map.class); // Getting the row as a Map
                    Product product = new Product( // Creating a new Product object
                            (int) row.get("ItemNumber"), // Setting ItemNumber
                            (String) row.get("ItemName"), // Setting ItemName
                            (int) row.get("Quantity"), // Setting Quantity
                            (double) row.get("Price") // Setting Price
                    );
                    System.out.println(product); // Printing the Product object
                });
    }
}