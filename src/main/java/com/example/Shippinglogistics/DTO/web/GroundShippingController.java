package com.example.Shippinglogistics.DTO.web;

import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.Service.GrondShippingServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ground-shipping/")
public class GroundShippingController {

    private final GrondShippingServiceInt serviceInt;


    @Autowired
    public GroundShippingController(GrondShippingServiceInt serviceInt) {
        this.serviceInt = serviceInt;
    }

    @PostMapping("save")
    public ResponseEntity<String> save(@RequestBody GroundShipping groundShipping){
        try {
            return serviceInt.save(groundShipping);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro al procesar la solicitud");
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<GroundShipping>> getALl(){
        try {
            return serviceInt.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("delete/{guideNumber}")
    public ResponseEntity<String> delete(@PathVariable String guideNumber){
        try {
            return serviceInt.delete(guideNumber);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro al procesar la solicitud");
        }
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody GroundShipping groundShipping){
        try {
            return serviceInt.update(groundShipping);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
