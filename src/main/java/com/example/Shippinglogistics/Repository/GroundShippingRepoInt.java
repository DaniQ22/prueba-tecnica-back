package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.GroundShipping;

import java.util.List;
import java.util.Optional;

public interface GroundShippingRepoInt {

    void save(GroundShipping groundShipping);

    List<GroundShipping> getALL();

    boolean existGroundShipping(String guideNumber);

    void delete(String guideNumber);

    List<GroundShipping> getBuCustomer();




}
