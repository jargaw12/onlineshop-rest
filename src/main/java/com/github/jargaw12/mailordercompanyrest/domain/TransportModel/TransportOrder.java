package com.github.jargaw12.mailordercompanyrest.domain.TransportModel;

public class TransportOrder {
    int orderNo;
    String orderDateTime;

    public int getOrderNo() {
        return orderNo;
    }

    public TransportOrder setOrderNo(int orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public TransportOrder setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
        return this;
    }
}
