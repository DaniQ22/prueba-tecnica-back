package com.example.Shippinglogistics.entitys;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@IdClass(RolUser.class)
@Table(name = "role")
public class Rol {

    @Id
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Id
    private String role;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechacreacion;

    @ManyToOne
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDateTime fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
