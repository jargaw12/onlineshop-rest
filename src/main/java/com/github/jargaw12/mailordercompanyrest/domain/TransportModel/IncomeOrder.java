package com.github.jargaw12.mailordercompanyrest.domain.TransportModel;

import java.time.LocalDate;

public class IncomeOrder {
    private String relationFrom;
    private String relationTo;
    private LocalDate orderDate;
    private LocalDate executeDate;
    private int daysQuantity;
    private double transportWeight;
    private Contractor contractor;

    public IncomeOrder(String relationFrom, String relationTo, LocalDate orderDate, LocalDate executeDate, double transportWeight) {
        this.relationFrom = relationFrom;
        this.relationTo = relationTo;
        this.orderDate = orderDate;
        this.executeDate = executeDate;
        this.transportWeight = transportWeight;
        this.daysQuantity=3;
        this.contractor=new Contractor(2);
    }

    public String getRelationFrom() {
        return relationFrom;
    }

    public IncomeOrder setRelationFrom(String relationFrom) {
        this.relationFrom = relationFrom;
        return this;
    }

    public String getRelationTo() {
        return relationTo;
    }

    public IncomeOrder setRelationTo(String relationTo) {
        this.relationTo = relationTo;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public IncomeOrder setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public LocalDate getExecuteDate() {
        return executeDate;
    }

    public IncomeOrder setExecuteDate(LocalDate executeDate) {
        this.executeDate = executeDate;
        return this;
    }

    public int getDaysQuantity() {
        return daysQuantity;
    }

    public IncomeOrder setDaysQuantity(int daysQuantity) {
        this.daysQuantity = daysQuantity;
        return this;
    }

    public double getTransportWeight() {
        return transportWeight;
    }

    public IncomeOrder setTransportWeight(double transportWeight) {
        this.transportWeight = transportWeight;
        return this;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public IncomeOrder setContractor(Contractor contractor) {
        this.contractor = contractor;
        return this;
    }
}
