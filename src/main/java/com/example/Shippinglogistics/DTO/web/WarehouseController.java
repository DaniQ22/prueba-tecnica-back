package com.example.Shippinglogistics.DTO.web;

import com.example.Shippinglogistics.Service.WarehouseServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse/")
public class WarehouseController {

    private final WarehouseServiceInt serviceInt;


   @Autowired
    public WarehouseController(WarehouseServiceInt serviceInt) {
        this.serviceInt = serviceInt;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
       return serviceInt.getAll();
    }


    @GetMapping("getById/{warehouseId}")
    public ResponseEntity<?> getByIf(@PathVariable Integer warehouseId){
       try {
           return serviceInt.getByID(warehouseId);
       }catch (Exception e){
           return ResponseEntity.internalServerError().build();
       }
    }
}
