package com.example.Shippinglogistics.DTO.web;

import com.example.Shippinglogistics.Service.PortServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/port/")
public class PortController {

    private final PortServiceInt portServiceInt;


    @Autowired
    public PortController(PortServiceInt portServiceInt) {
        this.portServiceInt = portServiceInt;
    }

    @GetMapping("all")
    public ResponseEntity<?> getll(){
        try {
            return portServiceInt.getAll();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("getByid/{portId}")
    public ResponseEntity<?> getById(@PathVariable Integer portId){
        try {
            return portServiceInt.getById(portId);
        }catch (Exception e){}
        return ResponseEntity.internalServerError().build();
    }
}
