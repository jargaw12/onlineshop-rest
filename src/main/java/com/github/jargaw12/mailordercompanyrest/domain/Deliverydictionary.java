package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Deliverydictionary {
    private long id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public Deliverydictionary setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public Deliverydictionary setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliverydictionary that = (Deliverydictionary) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
