package com.example.Shippinglogistics.entitys;

import jakarta.persistence.*;
import jakarta.transaction.TransactionScoped;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "envio_terrestre")
public class EnvioTerrestre {

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
    @Column(name = "placa_vehiculo")
    private String placVehiculo;

    @Column(name = "bodega_entrega")
    private Integer bodegaEntrega;


    @ManyToOne
    @JoinColumn(name = "bodega_entrega", insertable = false, updatable = false)
    private Bodega bodega;

    @Column(name = "price_total")
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

    public String getPlacVehiculo() {
        return placVehiculo;
    }

    public void setPlacVehiculo(String placVehiculo) {
        this.placVehiculo = placVehiculo;
    }

    public Integer getBodegaEntrega() {
        return bodegaEntrega;
    }

    public void setBodegaEntrega(Integer bodegaEntrega) {
        this.bodegaEntrega = bodegaEntrega;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
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
