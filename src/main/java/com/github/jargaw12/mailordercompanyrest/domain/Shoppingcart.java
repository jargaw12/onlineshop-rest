package com.github.jargaw12.mailordercompanyrest.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shoppingcart", schema = "public", catalog = "mailordercompany")
public class Shoppingcart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "quantity", nullable = true)
    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product item;

    public Shoppingcart() {
    }

    public long getId() {
        return id;
    }

    public Shoppingcart setId(long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Shoppingcart setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Shoppingcart(Integer quantity, Users buyer, Product item) {
        this.quantity = quantity;
        this.buyer = buyer;
        this.item = item;
    }

//    public Users getBuyer() {
//        return buyer;
//    }
//
//    public Shoppingcart setBuyer(Users buyer) {
//        this.buyer = buyer;
//        return this;
//    }

    public Product getItem() {
        return item;
    }

    public Shoppingcart setItem(Product item) {
        this.item = item;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingcart that = (Shoppingcart) o;
        return id == that.id &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }
}
