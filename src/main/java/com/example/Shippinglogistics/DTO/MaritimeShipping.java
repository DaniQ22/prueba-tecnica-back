package com.example.Shippinglogistics.DTO;

import java.time.LocalDateTime;

public class MaritimeShipping {

    private String fleetNumber;

    private Integer portDelivery;

    private Integer id;

    private String idCustomer;
    private Integer quantityProduct;
    private String dateDelivery;
    private Double price;
    private LocalDateTime dateRegistry;
    private String guideNumber;
    private Double priceTotal;
    private Double discount;
    private Integer typeProduct;

    private Customer customer;

    private Product product;

    public String getFleetNumber() {
        return fleetNumber;
    }

    public void setFleetNumber(String fleetNumber) {
        this.fleetNumber = fleetNumber;
    }

    public Integer getPortDelivery() {
        return portDelivery;
    }

    public void setPortDelivery(Integer portDelivery) {
        this.portDelivery = portDelivery;
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

    public Integer getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(Integer typeProduct) {
        this.typeProduct = typeProduct;
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

