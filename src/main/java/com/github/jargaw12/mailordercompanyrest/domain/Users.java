package com.github.jargaw12.mailordercompanyrest.domain;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "username")
    @NotEmpty(message = "username must not be empty")
    private String username;
    @JsonIgnore
    @Column(name = "password")
    @NotEmpty(message = "email must not be empty")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

    public Users() {
    }

    public Users(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Users(Users users) {
        this.username = users.username;
        this.password = users.password;
        this.roles = users.roles;

    }

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Users setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
