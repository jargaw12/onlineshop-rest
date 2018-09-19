package com.github.jargaw12.mailordercompanyrest.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    long orderID;
    int totalQuantity;
    Date orderDate;
    Date deliveryDate;
    String deliveryForm;
    String payment;
    String status;
    BigDecimal totalPrice;

    public Order(long orderID, int totalQuantity, Date orderDate, Date deliveryDate, String deliveryForm, String payment, String status, BigDecimal totalPrice) {
        this.orderID = orderID;
        this.totalQuantity = totalQuantity;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.deliveryForm = deliveryForm;
        this.payment = payment;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public long getOrderID() {
        return orderID;
    }

    public Order setOrderID(long orderID) {
        this.orderID = orderID;
        return this;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public Order setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Order setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public String getDeliveryForm() {
        return deliveryForm;
    }

    public Order setDeliveryForm(String deliveryForm) {
        this.deliveryForm = deliveryForm;
        return this;
    }

    public String getPayment() {
        return payment;
    }

    public Order setPayment(String payment) {
        this.payment = payment;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
