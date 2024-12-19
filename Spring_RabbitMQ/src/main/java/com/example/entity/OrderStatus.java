package com.example.entity;

public class OrderStatus {
    private Order order;
    private String status;      // Progress, Completed
    private String message;

    public OrderStatus() {
    }

    public OrderStatus(Order order, String status, String message) {
        this.order = order;
        this.status = status;
        this.message = message;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "order=" + order +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}