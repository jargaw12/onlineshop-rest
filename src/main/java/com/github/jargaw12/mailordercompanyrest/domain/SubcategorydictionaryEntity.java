package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subcategorydictionary", schema = "public", catalog = "mailordercompany")
public class SubcategorydictionaryEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy = "subcategoryName")
    List<ProductSubcategory> subcategories;


    public long getId() {
        return id;
    }

    public SubcategorydictionaryEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubcategorydictionaryEntity setName(String name) {
        this.name = name;
        return this;
    }

//    public List<ProductSubcategory> getSubcategories() {
//        return subcategories;
//    }

    public SubcategorydictionaryEntity setSubcategories(List<ProductSubcategory> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubcategorydictionaryEntity that = (SubcategorydictionaryEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
