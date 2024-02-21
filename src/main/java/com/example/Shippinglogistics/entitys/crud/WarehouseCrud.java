package com.example.Shippinglogistics.entitys.crud;

import com.example.Shippinglogistics.entitys.Bodega;
import org.springframework.data.repository.ListCrudRepository;

public interface WarehouseCrud extends ListCrudRepository<Bodega, Integer> {
}
