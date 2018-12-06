package com.github.jargaw12.mailordercompanyrest.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    List<ShoppingCartItem> productInCarts;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "image", nullable = false, length = 200)
    private String image;
    @Column(name = "productsubcateryid")
    private long subcategoryid;
    @OneToMany(mappedBy = "productByProductid")
    private Collection<OrderItem> orderItemById;

//    @ManyToOne
//    @JoinColumn(name = "productsubcateryid")
//    ProductSubcategory subcategory;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getImage() {
        return image;
    }



//    public ProductSubcategory getSubcategory() {
//        return subcategory;
//    }
//
//    public Product setSubcategory(ProductSubcategory subcategory) {
//        this.subcategory = subcategory;
//        return this;
//    }


    public long getSubcategoryid() {
        return subcategoryid;
    }

    public Product setSubcategoryid(long subcategoryid) {
        this.subcategoryid = subcategoryid;
        return this;
    }

    public Product setImage(String image) {
        this.image = image;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, image);
    }

//    public Collection<OrderItem> getOrderItemById() {
//        return orderItemById;
//    }

    public Product setOrderItemById(Collection<OrderItem> orderItemById) {
        this.orderItemById = orderItemById;
        return this;
    }
}
