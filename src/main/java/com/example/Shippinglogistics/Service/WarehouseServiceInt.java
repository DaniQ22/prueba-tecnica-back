package com.example.Shippinglogistics.Service;

import org.springframework.http.ResponseEntity;

public interface WarehouseServiceInt {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getByID(Integer warehouseId);


}
