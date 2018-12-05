package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "productsubcatery", schema = "public", catalog = "mailordercompany")
public class ProductSubcategory implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategoryname")
    private SubcategorydictionaryEntity subcategoryname;
    @Column(name = "productcateryid")
    private long categoryid;
    @ManyToOne
    @JoinColumn(name = "productcateryid", insertable = false, updatable = false)
    ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "subcategoryname", insertable = false, updatable = false)
    SubcategorydictionaryEntity subcategoryName;
//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "productsubcateryid", nullable = false)
//    @OneToMany(mappedBy = "subcategory")
//    Set<Product> products;
//    private Product productById;

    public long getId() {
        return id;
    }

    public ProductSubcategory setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSubcategory that = (ProductSubcategory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    public Product getProductById() {
//        return productById;
//    }
//
//    public ProductSubcategory setProductById(Product productById) {
//        this.productById = productById;
//        return this;
//    }


    public SubcategorydictionaryEntity getSubcategoryname() {
        return subcategoryname;
    }

    public ProductSubcategory setSubcategoryname(SubcategorydictionaryEntity subcategoryname) {
        this.subcategoryname = subcategoryname;
        return this;
    }
}
