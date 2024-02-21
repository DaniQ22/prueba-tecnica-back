package com.example.Shippinglogistics.entitys;

import java.io.Serializable;
import java.util.Objects;

public class RolUser implements Serializable {

    private String nombreUsuario;

    private String role;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolUser rolUser)) return false;
        return Objects.equals(nombreUsuario, rolUser.nombreUsuario) && Objects.equals(role, rolUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario, role);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
