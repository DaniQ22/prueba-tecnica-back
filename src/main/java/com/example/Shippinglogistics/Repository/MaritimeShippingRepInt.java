package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.MaritimeShipping;

import java.util.List;

public interface MaritimeShippingRepInt {

    void save(MaritimeShipping maritimeShipping);

    List<MaritimeShipping> getALL();

    boolean existMaritimeShipping(String numberGuide);

    void  delete(String numberGuide);
}
