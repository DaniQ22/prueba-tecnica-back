package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.Product;
import org.springframework.http.ResponseEntity;

public interface ProductServiceInt {

    ResponseEntity<String> save(Product product);

    ResponseEntity<?> getAll();

}
