package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Product;

import java.util.List;

public interface ProductRepositoryInt {

    void save(Product product);
    boolean exiistProduct(Integer productId);

    List<Product> gettALl();

}
