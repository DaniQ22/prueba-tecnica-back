package com.example.Shippinglogistics.entitys;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "envio_maritimo")
public class EnvioMaritimo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Integer idEnvio;

    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;
    @Column(name = "fecha_entrega")
    private String fechaEntrega;
    @Column(name = "precio_envio")
    private Double precioEnvio;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    @Column(name = "numero_guia")
    private String numeroGuia;
    @Column(name = "tipo_producto")
    private Integer tipoProducto;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tipo_producto", insertable = false, updatable = false)
    private Producto producto;

    @Column(name = "numero_flota")
    private String numeroFlota;

    @Column(name = "puerto_entrega")
    private Integer puertoEntrega;

    @Column(name = "precio_total")
    private Double precioTotal;

    @Column(name = "descuento")
    private Double descuento;


    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(Double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Integer getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Integer tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNumeroFlota() {
        return numeroFlota;
    }

    public void setNumeroFlota(String numeroFlota) {
        this.numeroFlota = numeroFlota;
    }

    public Integer getPuertoEntrega() {
        return puertoEntrega;
    }

    public void setPuertoEntrega(Integer puertoEntrega) {
        this.puertoEntrega = puertoEntrega;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
}
