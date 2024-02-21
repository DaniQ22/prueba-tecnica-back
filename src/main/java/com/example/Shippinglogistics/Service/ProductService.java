package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.Product;
import com.example.Shippinglogistics.Repository.ProductRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;

@Service
public class ProductService implements ProductServiceInt {

    private final ProductRepositoryInt repositoryInt;


    @Autowired
    public ProductService(ProductRepositoryInt repositoryInt) {

        this.repositoryInt = repositoryInt;
    }


    @Override
    public ResponseEntity<String> save(Product product) {
        try {
            repositoryInt.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto alamcenado");
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<Product> products = repositoryInt.gettALl();
            if(products.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen productos");
            }
            return ResponseEntity.ok().body(products);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
