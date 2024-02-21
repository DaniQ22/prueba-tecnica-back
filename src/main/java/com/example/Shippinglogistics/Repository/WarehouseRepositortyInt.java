package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Warehouse;
import com.example.Shippinglogistics.entitys.Bodega;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface WarehouseRepositortyInt {

    void save (Warehouse warehouse);

    boolean existWarehouse(Integer warehouseId);

    List<Warehouse> getAll();
}
