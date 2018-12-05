package com.github.jargaw12.mailordercompanyrest.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users", schema = "public", catalog = "mailordercompany")
public class Users {
    @JsonIgnore
    @OneToMany(mappedBy = "buyer")
    List<Shoppingcart> shoppingCart;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "address_id")
    private Long addressId;
    @JsonIgnore
    @NotNull
    @Column(name = "password")
    private String password;
    @Email
    @Column(name = "username")
    private String username;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "birthdate")
    private Date birthdate;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "userrole",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Role> roles;
    @JsonIgnore
    @OneToMany(mappedBy = "usersByUserid")
    private Collection<Orders> ordersById;

    @ManyToOne
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    Address address;

    public long getId() {
        return id;
    }

    public Users setId(long id) {
        this.id = id;
        return this;
    }

    public Long getAddressId() {
        return addressId;
    }

    public Users setAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Users setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Users setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Users setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Date getBirthdate() throws ParseException {
        DateFormat df= new SimpleDateFormat("yyyyy-mm-dd");
        return df.parse(birthdate.toString());
    }

    public Users setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Users setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Users setAddress(Address address) {
        this.address = address;
        return this;
    }

    //    public Collection<Orders> getOrdersById() {
//        return ordersById;
//    }

    public Users setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
        return this;
    }
}
