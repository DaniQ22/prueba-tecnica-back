package com.example.Shippinglogistics.DTO;

import java.util.List;

public class User {

    private String username;

    private String password;

    private String email;

    private Boolean disable;

    private Boolean locked;

    private List<RoleUser> userRoles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<RoleUser> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<RoleUser> userRoles) {
        this.userRoles = userRoles;
    }
}
