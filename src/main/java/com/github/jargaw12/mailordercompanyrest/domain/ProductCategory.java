package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "productcatery", schema = "public", catalog = "mailordercompany")
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

//    @Column(name = "productgroupid", nullable = false)
//    private long groupid;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "productsubcatery",
            joinColumns = @JoinColumn(name = "productcateryid"),
            inverseJoinColumns = @JoinColumn(name = "subcategoryname"))
    private List<SubcategorydictionaryEntity> subcategories;

    @ManyToOne
    @JoinColumn(name="productgroupid", nullable=false)
    private ProductGroup group;

//    @OneToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "productcategoryname", nullable = false)
//    private CategorydictionaryEntity name;
    @ManyToOne
    @JoinColumn(name = "productcategoryname")
    CategorydictionaryEntity categoryname;

    public long getId() {
        return id;
    }

    public ProductCategory setId(long id) {
        this.id = id;
        return this;
    }

    public List<SubcategorydictionaryEntity> getSubcategories() {
        return subcategories;
    }

    public ProductCategory setSubcategories(List<SubcategorydictionaryEntity> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    public CategorydictionaryEntity getCategoryname() {
        return categoryname;
    }

    public ProductCategory setCategoryname(CategorydictionaryEntity categoryname) {
        this.categoryname = categoryname;
        return this;
    }

    //    public ProductCategory getGroup() {
//        return group;
//    }
//
//    public ProductCategory setGroup(ProductCategory group) {
//        this.group = group;
//        return this;
//    }

//    public CategorydictionaryEntity getName() {
//        return name;
//    }
//
//    public ProductCategory setName(CategorydictionaryEntity name) {
//        this.name = name;
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


//    public ProductGroup getProductgroupByProductgroupid() {
//        return productgroupByProductgroupid;
//    }
//
//    public ProductCategory setProductgroupByProductgroupid(ProductGroup productgroupByProductgroupid) {
//        this.productgroupByProductgroupid = productgroupByProductgroupid;
//        return this;
//    }
}
