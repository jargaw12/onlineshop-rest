package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "totalprice", nullable = true, precision = 0)
    private Double totalprice;
    @Column(name = "createdtime", nullable = false)
    private Date createdtime;
    @Column(name = "deliverycost", nullable = false, precision = 0)
    private double deliverycost;
    @Column(name = "invoice", nullable = true, length = 100)
    private String invoice;
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<Orderdetails> orderdetailsById;
    @ManyToOne
    @JoinColumn(name = "deliveryid", referencedColumnName = "id", nullable = false)
    private Delivery deliveryByDeliveryid;
    @ManyToOne
    @JoinColumn(name = "paymentid", referencedColumnName = "id", nullable = false)
    private Paymentdictionary paymentByPaymentid;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    private Users usersByUserid;
    @ManyToOne
    @JoinColumn(name = "adres_id", referencedColumnName = "id")
    private Address addressByAdresId;

    public long getId() {
        return id;
    }

    public Orders setId(long id) {
        this.id = id;
        return this;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public Orders setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public Orders setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
        return this;
    }

    public double getDeliverycost() {
        return deliverycost;
    }

    public Orders setDeliverycost(double deliverycost) {
        this.deliverycost = deliverycost;
        return this;
    }

    public String getInvoice() {
        return invoice;
    }

    public Orders setInvoice(String invoice) {
        this.invoice = invoice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                Double.compare(orders.deliverycost, deliverycost) == 0 &&
                Objects.equals(totalprice, orders.totalprice) &&
                Objects.equals(createdtime, orders.createdtime) &&
                Objects.equals(invoice, orders.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalprice, createdtime, deliverycost, invoice);
    }

    public Collection<Orderdetails> getOrderdetailsById() {
        return orderdetailsById;
    }

    public Orders setOrderdetailsById(Collection<Orderdetails> orderdetailsById) {
        this.orderdetailsById = orderdetailsById;
        return this;
    }

    public Delivery getDeliveryByDeliveryid() {
        return deliveryByDeliveryid;
    }

    public Orders setDeliveryByDeliveryid(Delivery deliveryByDeliveryid) {
        this.deliveryByDeliveryid = deliveryByDeliveryid;
        return this;
    }


    public Paymentdictionary getPaymentByPaymentid() {
        return paymentByPaymentid;
    }

    public Orders setPaymentByPaymentid(Paymentdictionary paymentByPaymentid) {
        this.paymentByPaymentid = paymentByPaymentid;
        return this;
    }

//    public Users getUsersByUserid() {
//        return usersByUserid;
//    }

    public Orders setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
        return this;
    }

    public Address getAddressByAdresId() {
        return addressByAdresId;
    }

    public Orders setAddressByAdresId(Address addressByAdresId) {
        this.addressByAdresId = addressByAdresId;
        return this;
    }
}
