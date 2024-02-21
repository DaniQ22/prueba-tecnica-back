package com.example.Shippinglogistics.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "puerto")
public class Puerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puerto")
    private Integer idPuerto;

    @Column(name = "nombre_puerto")
    private String nombre;

    private String ubicacion;

    private Integer capacidad;

    public Integer getIdPuerto() {
        return idPuerto;
    }

    public void setIdPuerto(Integer idPuerto) {
        this.idPuerto = idPuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
