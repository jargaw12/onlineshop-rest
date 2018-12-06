package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "productgroup", schema = "public", catalog = "mailordercompany")
public class ProductGroup implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "productcatery",
//            joinColumns = @JoinColumn(name = "productgroupid"),
//            inverseJoinColumns = @JoinColumn(name = "productcategoryname"))
//    private List<CategorydictionaryEntity> categories;
    @OneToMany(mappedBy="group")
    private Set<ProductCategory> categories;

    public long getId() {
        return id;
    }

    public ProductGroup setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductGroup setName(String name) {
        this.name = name;
        return this;
    }

//    public List<CategorydictionaryEntity> getCategories() {
//        return categories;
//    }
//
//    public ProductGroup setCategories(List<CategorydictionaryEntity> categories) {
//        this.categories = categories;
//        return this;
//    }


    public Set<ProductCategory> getCategories() {
        return categories;
    }

    public ProductGroup setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductGroup that = (ProductGroup) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
