package com.lishatech.product;

public class Product {

    //attributes of products in JapaneseQuikMart Menu

    private int ItemNumber;
    private String ItemName;
    private int Quantity;
    private double Price;

    //constructor
    public Product(int ItemNumber, String ItemName, int Quantity, double Price) {
        this.ItemNumber = ItemNumber;
        this.ItemName = ItemName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    //getters and setters
    public int getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(int ItemNumber) {
        this.ItemNumber = ItemNumber;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }



}
