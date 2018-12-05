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
    private Deliverydictionary deliverydictionaryByDeliverytype;
    @ManyToOne
    @JoinColumn(name = "deliverycompany", referencedColumnName = "id", nullable = false)
    private Deliverycompanydictionary deliverycompanydictionaryByDeliverycompany;
    @OneToMany(mappedBy = "deliveryByDeliveryid")
    private Collection<Orders> ordersById;

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


    public Deliverydictionary getDeliverydictionaryByDeliverytype() {
        return deliverydictionaryByDeliverytype;
    }

    public Delivery setDeliverydictionaryByDeliverytype(Deliverydictionary deliverydictionaryByDeliverytype) {
        this.deliverydictionaryByDeliverytype = deliverydictionaryByDeliverytype;
        return this;
    }

    public Deliverycompanydictionary getDeliverycompanydictionaryByDeliverycompany() {
        return deliverycompanydictionaryByDeliverycompany;
    }

    public Delivery setDeliverycompanydictionaryByDeliverycompany(Deliverycompanydictionary deliverycompanydictionaryByDeliverycompany) {
        this.deliverycompanydictionaryByDeliverycompany = deliverycompanydictionaryByDeliverycompany;
        return this;
    }

//    public Collection<Orders> getOrdersById() {
//        return ordersById;
//    }

    public Delivery setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
        return this;
    }
}
