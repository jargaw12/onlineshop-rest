package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Orderdetails {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "id", nullable = false)
    private Product productByProductid;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders ordersByOrderId;

    public long getId() {
        return id;
    }

    public Orderdetails setId(long id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Orderdetails setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderdetails that = (Orderdetails) o;
        return id == that.id &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }


    public Product getProductByProductid() {
            return productByProductid;
    }

    public Orderdetails setProductByProductid(Product productByProductid) {
        this.productByProductid = productByProductid;
        return this;
    }
//
//    public Orders getOrdersByOrderId() {
//        return ordersByOrderId;
//    }
//
    public Orderdetails setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
        return this;
    }
}
