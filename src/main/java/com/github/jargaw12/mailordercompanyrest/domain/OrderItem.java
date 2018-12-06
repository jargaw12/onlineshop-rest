package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderdetails", schema = "public", catalog = "mailordercompany")
public class OrderItem {
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
    private Order orderByOrderId;

    public long getId() {
        return id;
    }

    public OrderItem setId(long id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem that = (OrderItem) o;
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

    public OrderItem setProductByProductid(Product productByProductid) {
        this.productByProductid = productByProductid;
        return this;
    }
//
//    public Order getOrdersByOrderId() {
//        return orderByOrderId;
//    }
//
    public OrderItem setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
        return this;
    }
}
