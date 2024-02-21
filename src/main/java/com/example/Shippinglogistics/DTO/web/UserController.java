package com.example.Shippinglogistics.DTO.web;

import com.example.Shippinglogistics.DTO.User;
import com.example.Shippinglogistics.Service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    private final UserServiceInt serviceInt;


    @Autowired
    public UserController(UserServiceInt serviceImp) {
        this.serviceInt = serviceImp;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try {
            return serviceInt.getAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un problema en la peticion" + e.getMessage());
        }
    }


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User user){
        try{
            return serviceInt.save(user);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error al procesar la solicitud");
        }

    }


}
