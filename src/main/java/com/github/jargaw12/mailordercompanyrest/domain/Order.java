package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "mailordercompany")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "totalprice")
    private Double totalprice;
    @Column(name = "createdtime", nullable = false)
    private Date createdtime;
    @Column(name = "deliverycost", nullable = false)
    private double deliverycost;
    @Column(name = "invoice", length = 100)
    private String invoice;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderItem> orderItemById;
    @ManyToOne
    @JoinColumn(name = "deliveryid", referencedColumnName = "id", nullable = false)
    private Delivery deliveryByDeliveryid;
    @ManyToOne
    @JoinColumn(name = "paymentid", referencedColumnName = "id", nullable = false)
    private PaymentMethod paymentByPaymentid;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    private Users usersByUserid;
    @ManyToOne
    @JoinColumn(name = "adres_id", referencedColumnName = "id")
    private Address addressByAdresId;

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public Order setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public Order setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
        return this;
    }

    public double getDeliverycost() {
        return deliverycost;
    }

    public Order setDeliverycost(double deliverycost) {
        this.deliverycost = deliverycost;
        return this;
    }

    public String getInvoice() {
        return invoice;
    }

    public Order setInvoice(String invoice) {
        this.invoice = invoice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Double.compare(order.deliverycost, deliverycost) == 0 &&
                Objects.equals(totalprice, order.totalprice) &&
                Objects.equals(createdtime, order.createdtime) &&
                Objects.equals(invoice, order.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalprice, createdtime, deliverycost, invoice);
    }

    public Collection<OrderItem> getOrderItemById() {
        return orderItemById;
    }

    public Order setOrderItemById(Collection<OrderItem> orderItemById) {
        this.orderItemById = orderItemById;
        return this;
    }

    public Delivery getDeliveryByDeliveryid() {
        return deliveryByDeliveryid;
    }

    public Order setDeliveryByDeliveryid(Delivery deliveryByDeliveryid) {
        this.deliveryByDeliveryid = deliveryByDeliveryid;
        return this;
    }


    public PaymentMethod getPaymentByPaymentid() {
        return paymentByPaymentid;
    }

    public Order setPaymentByPaymentid(PaymentMethod paymentByPaymentid) {
        this.paymentByPaymentid = paymentByPaymentid;
        return this;
    }

//    public Users getUsersByUserid() {
//        return usersByUserid;
//    }

    public Order setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
        return this;
    }

    public Address getAddressByAdresId() {
        return addressByAdresId;
    }

    public Order setAddressByAdresId(Address addressByAdresId) {
        this.addressByAdresId = addressByAdresId;
        return this;
    }
}
