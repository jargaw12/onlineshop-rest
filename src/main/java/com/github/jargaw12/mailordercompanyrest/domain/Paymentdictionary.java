package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Paymentdictionary {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public long getId() {
        return id;
    }

    public Paymentdictionary setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Paymentdictionary setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paymentdictionary that = (Paymentdictionary) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
