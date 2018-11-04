package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categorydictionary", schema = "public", catalog = "mailordercompany")
public class CategorydictionaryEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

//    @OneToOne(fetch = FetchType.EAGER,
//            cascade =  CascadeType.ALL,
//            mappedBy = "name")
//    private ProductCategory category;

    public long getId() {
        return id;
    }

    public CategorydictionaryEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategorydictionaryEntity setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "categoryname")
    Set<ProductCategory> categories=new HashSet<>();

//    public ProductCategory getCategory() {
//        return category;
//    }
//
//    public CategorydictionaryEntity setCategory(ProductCategory category) {
//        this.category = category;
//        return this;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorydictionaryEntity that = (CategorydictionaryEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
