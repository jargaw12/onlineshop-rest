package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "street", nullable = false, length = 50)
    @NotNull
    private String street;
    @Column(name = "streetnumber", nullable = false, length = 10)
    @NotNull
    @Min(0)
    private String streetnumber;
    @Column(name = "flatnumber", nullable = false, length = 10)
    @Min(0)
    private String flatnumber;
    @Column(name = "postcode", nullable = false, length = 6)
    @NotNull
    private String postcode;
    @Column(name = "city", nullable = false, length = 50)
    @NotNull
    private String city;
    @Column(name = "country")
    private String country;
    @OneToMany(mappedBy = "addressByAdresId")
    private Collection<Order> orderById;

    @OneToMany(mappedBy = "address")
    List<Users> residents;

    public long getId() {
        return id;
    }

    public Address setId(long id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public Address setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
        return this;
    }

    public String getFlatnumber() {
        return flatnumber;
    }

    public Address setFlatnumber(String flatnumber) {
        this.flatnumber = flatnumber;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public Address setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(street, address.street) &&
                Objects.equals(streetnumber, address.streetnumber) &&
                Objects.equals(flatnumber, address.flatnumber) &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, streetnumber, flatnumber, postcode, city);
    }

//    public Collection<Order> getOrdersById() {
//        return orderById;
//    }

    public Address setOrderById(Collection<Order> orderById) {
        this.orderById = orderById;
        return this;
    }
}
