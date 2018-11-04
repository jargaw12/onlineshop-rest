package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Column(name = "image", nullable = false, length = 200)
    private String image;
    @Column(name = "productsubcateryid")
    private long subcategoryid;

    public Product() {
    }

//    @ManyToOne
//    @JoinColumn(name = "productsubcateryid")
//    ProductSubcategory subcategory;

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

    public Product setImage(String image) {
        this.image = image;
        return this;
    }

//    public ProductSubcategory getSubcategory() {
//        return subcategory;
//    }
//
//    public Product setSubcategory(ProductSubcategory subcategory) {
//        this.subcategory = subcategory;
//        return this;
//    }

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
}
