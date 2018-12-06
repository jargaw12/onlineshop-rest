package com.github.jargaw12.mailordercompanyrest.domain.TransportModel;

public class OrderUser {
    private String usernameOrEmail;
    private String password;

    public OrderUser(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public OrderUser setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public OrderUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
