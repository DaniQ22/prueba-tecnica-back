package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Customer;

public interface CustomerRepositoryInt {

    void save(Customer customer);

    boolean existById(String cutomerId);

}
