package com.example.entity;

public class Order {
    private String orderId;
    private String name;
    private String email;
    private int quantity;
    private double price;

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
