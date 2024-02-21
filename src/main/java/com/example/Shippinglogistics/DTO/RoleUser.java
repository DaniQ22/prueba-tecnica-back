package com.example.Shippinglogistics.DTO;

import java.time.LocalDateTime;

public class RoleUser {

    private String username;

    private String roleUser;

    private LocalDateTime grantedDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public LocalDateTime getGrantedDate() {
        return grantedDate;
    }

    public void setGrantedDate(LocalDateTime grantedDate) {
        this.grantedDate = grantedDate;
    }
}
