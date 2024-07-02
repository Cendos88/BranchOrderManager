package com.practice.ordermanager.models;

import java.util.Date;

public class OrderNumberDto {
    private int orderNumber;
    private Date Date;
    private int lineNumber;

    public OrderNumberDto(int orderNumber, java.util.Date date, int lineNumber) {
        this.orderNumber = orderNumber;
        Date = date;
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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}

