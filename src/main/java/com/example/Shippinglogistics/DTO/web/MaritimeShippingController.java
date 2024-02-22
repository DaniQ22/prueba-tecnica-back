package com.example.Shippinglogistics.DTO.web;

import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.DTO.MaritimeShipping;
import com.example.Shippinglogistics.Service.MaritimeShippingServInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maritime-shipping/")
public class MaritimeShippingController {
    private final MaritimeShippingServInt service;


   @Autowired
    public MaritimeShippingController( MaritimeShippingServInt service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<String> save(@RequestBody MaritimeShipping maritimeShipping){
       try {
           return service.save(maritimeShipping);
       }catch (Exception e){
           return  ResponseEntity.internalServerError().body("Error al crear la solocitud");
       }
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
       try {
           return service.getAll();
       }catch (Exception e){
           return  ResponseEntity.internalServerError().body("Error al crear la solocitud");

       }
    }

    @DeleteMapping("delete/{numberGuide}")
    public ResponseEntity<String> delete(@PathVariable  String numberGuide){
       try {
           return service.delelete(numberGuide);
       }catch (Exception e){
           return  ResponseEntity.internalServerError().body("Error al crear la solocitud");
       }
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@RequestBody MaritimeShipping maritimeShipping){
        try {
            return service.update(maritimeShipping);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }



}
