package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "subcategorydictionary", schema = "public", catalog = "mailordercompany")
public class SubcategorydictionaryEntity implements Serializable {
    private long id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public SubcategorydictionaryEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public SubcategorydictionaryEntity setName(String name) {
        this.name = name;
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
