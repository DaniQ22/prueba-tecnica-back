package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.Port;
import com.example.Shippinglogistics.Repository.PortRespositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortService implements PortServiceInt{

    private final PortRespositoryInt respositoryInt;

    @Autowired
    public PortService(PortRespositoryInt respositoryInt) {
        this.respositoryInt = respositoryInt;
    }


    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<Port> ports = respositoryInt.getAll();
            if(ports.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(ports);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<?> getById(Integer portId){
        try {
            Optional<Port> port = respositoryInt.getPorById(portId);
            if(port.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(port);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }
}
