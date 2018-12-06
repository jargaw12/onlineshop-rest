package com.github.jargaw12.mailordercompanyrest.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shoppingcart", schema = "public", catalog = "mailordercompany")
public class ShoppingCartItem {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "quantity")
    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private
    Users buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private
    Product item;

    public ShoppingCartItem() {
    }

    public long getId() {
        return id;
    }

    public ShoppingCartItem setId(long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ShoppingCartItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ShoppingCartItem(Integer quantity, Users buyer, Product item) {
        this.quantity = quantity;
        this.buyer = buyer;
        this.item = item;
    }

//    public Users getBuyer() {
//        return buyer;
//    }
//
//    public ShoppingCartItem setBuyer(Users buyer) {
//        this.buyer = buyer;
//        return this;
//    }

    public Product getItem() {
        return item;
    }

    public ShoppingCartItem setItem(Product item) {
        this.item = item;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return id == that.id &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }
}
