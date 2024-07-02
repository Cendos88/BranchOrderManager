package com.practice.ordermanager.models;

import java.util.Date;

public class OrderNumberDo {
    private int orderNumber;
    private java.util.Date Date;
    private int lineNumber;
    private Enum<OrderNumberStatus> status;

    public OrderNumberDo(int orderNumber, java.util.Date date, int lineNumber, Enum<OrderNumberStatus> status) {
        this.orderNumber = orderNumber;
        Date = date;
        this.lineNumber = lineNumber;
        this.status = status;
    }

    public OrderNumberDo() {
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

    public Enum<OrderNumberStatus> getStatus() {
        return status;
    }

    public void setStatus(Enum<OrderNumberStatus> status) {
        this.status = status;
    }
}
