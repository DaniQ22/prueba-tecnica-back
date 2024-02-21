package com.example.Shippinglogistics.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "nombre_usuario", nullable = false, length = 30)
    private String nombreUsuario;

    @Column(nullable = false, length = 300)
    private String contrasena;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean habilidato;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean bloquedo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rol> roles;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getHabilidato() {
        return habilidato;
    }

    public void setHabilidato(Boolean habilidato) {
        this.habilidato = habilidato;
    }

    public Boolean getBloquedo() {
        return bloquedo;
    }

    public void setBloquedo(Boolean bloquedo) {
        this.bloquedo = bloquedo;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
