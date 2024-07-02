package com.practice.ordermanager.models;

import java.util.Date;

public class OrderNumberDo {
    private final int orderNumber;
    private final Date date;
    private int lineNumber;
    private Enum<OrderNumberStatus> status;

    public OrderNumberDo(int orderNumber, java.util.Date date, int lineNumber, Enum<OrderNumberStatus> status) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.lineNumber = lineNumber;
        this.status = status;
    }


    public int getOrderNumber() {
        return orderNumber;
    }


    public Date getDate() {
        return date;
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
