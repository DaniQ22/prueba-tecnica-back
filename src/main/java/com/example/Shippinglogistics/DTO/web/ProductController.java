package com.example.Shippinglogistics.DTO.web;


import com.example.Shippinglogistics.DTO.Product;
import com.example.Shippinglogistics.Service.ProductServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    private final ProductServiceInt serviceInt;


    @Autowired
    public ProductController(ProductServiceInt serviceInt) {
        this.serviceInt = serviceInt;
    }


    @PostMapping("save")
    public ResponseEntity<String> save (@RequestBody Product product){
        try {
            return serviceInt.save(product);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("all")
    public ResponseEntity<?> getAL(){
        try {
            return serviceInt.getAll();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
