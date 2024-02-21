package com.example.Shippinglogistics.entitys.crud;

import com.example.Shippinglogistics.entitys.Producto;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductCrud extends ListCrudRepository<Producto, Integer> {
}
