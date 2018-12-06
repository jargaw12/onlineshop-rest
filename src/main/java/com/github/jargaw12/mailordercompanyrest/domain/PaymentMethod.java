package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "paymentdictionary", schema = "public", catalog = "mailordercompany")
public class PaymentMethod {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public long getId() {
        return id;
    }

    public PaymentMethod setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentMethod setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethod that = (PaymentMethod) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
