package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.GroundShipping;
import org.springframework.http.ResponseEntity;

import java.awt.image.RescaleOp;
import java.util.List;

public interface GrondShippingServiceInt {

    ResponseEntity<String> save(GroundShipping groundShipping);

    ResponseEntity<List<GroundShipping>> getAll();

    ResponseEntity<String> delete(String guideNumber);

    ResponseEntity<String> update(GroundShipping groundShipping);





}
