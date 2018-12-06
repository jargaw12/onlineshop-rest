package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Delivery {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "deliverytype", referencedColumnName = "id", nullable = false)
    private DeliveryType deliveryTypeByDeliverytype;
    @ManyToOne
    @JoinColumn(name = "deliverycompany", referencedColumnName = "id", nullable = false)
    private DeliveryCompany deliveryCompanyByDeliverycompany;
    @OneToMany(mappedBy = "deliveryByDeliveryid")
    private Collection<Order> orderById;

    public long getId() {
        return id;
    }

    public Delivery setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id == delivery.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public DeliveryType getDeliveryTypeByDeliverytype() {
        return deliveryTypeByDeliverytype;
    }

    public Delivery setDeliveryTypeByDeliverytype(DeliveryType deliveryTypeByDeliverytype) {
        this.deliveryTypeByDeliverytype = deliveryTypeByDeliverytype;
        return this;
    }

    public DeliveryCompany getDeliveryCompanyByDeliverycompany() {
        return deliveryCompanyByDeliverycompany;
    }

    public Delivery setDeliveryCompanyByDeliverycompany(DeliveryCompany deliveryCompanyByDeliverycompany) {
        this.deliveryCompanyByDeliverycompany = deliveryCompanyByDeliverycompany;
        return this;
    }

//    public Collection<Order> getOrdersById() {
//        return orderById;
//    }

    public Delivery setOrderById(Collection<Order> orderById) {
        this.orderById = orderById;
        return this;
    }
}
