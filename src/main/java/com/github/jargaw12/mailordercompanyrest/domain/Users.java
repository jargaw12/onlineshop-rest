package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "mailordercompany")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "password")
    private String password;
    @Column(name = "emailaddress")
    private String emailaddress;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "userrole",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

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

    public String getEmailaddress() {
        return emailaddress;
    }

    public Users setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
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

    public List<Role> getRoles() {
        return roles;
    }

    public Users setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return id == that.id &&
                Objects.equals(password, that.password) &&
                Objects.equals(emailaddress, that.emailaddress) &&
                Objects.equals(phonenumber, that.phonenumber) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, emailaddress, phonenumber, firstname, lastname, addressId, id);
    }
}
