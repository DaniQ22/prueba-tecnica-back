package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.Warehouse;
import com.example.Shippinglogistics.Repository.WarehouseRepositortyInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService implements WarehouseServiceInt{

    private  final WarehouseRepositortyInt repositortyInt;


    @Autowired
    public WarehouseService(WarehouseRepositortyInt repositortyInt) {
        this.repositortyInt = repositortyInt;
    }

    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<Warehouse> warehouses  =  repositortyInt.getAll();
            if(warehouses.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return  ResponseEntity.status(HttpStatus.OK).body(warehouses);

        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
