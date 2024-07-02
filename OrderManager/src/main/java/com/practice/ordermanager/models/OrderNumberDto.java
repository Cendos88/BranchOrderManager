package com.practice.ordermanager.models;

public class OrderNumberDto {
    private int orderNumber;
    private String date;
    private int lineNumber;

    public OrderNumberDto(int orderNumber, String date, int lineNumber) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.lineNumber = lineNumber;
    }

    public OrderNumberDto() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}

