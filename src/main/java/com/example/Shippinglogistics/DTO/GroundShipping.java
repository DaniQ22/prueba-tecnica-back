package com.example.Shippinglogistics.DTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GroundShipping  {

    private String licensePlate;

    private Integer deliveryWarehouse;

    private Integer id;

    private String idCustomer;
    private Integer quantityProduct;
    private String dateDelivery;
    private Double price;
    private LocalDateTime dateRegistry;
    private String guideNumber;
    private Integer typeProduct;
    private Double priceTotal;
    private Double discount;
    private Customer customer;
    private Product product;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getDeliveryWarehouse() {
        return deliveryWarehouse;
    }

    public void setDeliveryWarehouse(Integer deliveryWarehouse) {
        this.deliveryWarehouse = deliveryWarehouse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getDateRegistry() {
        return dateRegistry;
    }

    public void setDateRegistry(LocalDateTime dateRegistry) {
        this.dateRegistry = dateRegistry;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public void setGuideNumber(String guideNumber) {
        this.guideNumber = guideNumber;
    }

    public Integer getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(Integer typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
