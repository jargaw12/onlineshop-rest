package com.github.jargaw12.mailordercompanyrest.domain;

public class CartPosition {
    private Product product;
    private int quantity;

    public CartPosition(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public CartPosition setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartPosition setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
