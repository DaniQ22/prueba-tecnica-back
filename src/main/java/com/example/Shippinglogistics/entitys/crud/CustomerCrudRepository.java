package com.example.Shippinglogistics.entitys.crud;

import com.example.Shippinglogistics.DTO.Customer;
import com.example.Shippinglogistics.entitys.Cliente;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerCrudRepository extends ListCrudRepository<Cliente, String> {


}
