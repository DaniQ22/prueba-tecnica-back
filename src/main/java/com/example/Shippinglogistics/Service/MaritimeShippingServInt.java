package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.MaritimeShipping;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MaritimeShippingServInt {

    ResponseEntity<String> save(MaritimeShipping maritimeShipping);

    ResponseEntity<?> getAll();

    ResponseEntity<String> delelete(String numberGuide);

    ResponseEntity<String> update(MaritimeShipping maritimeShipping);


}
