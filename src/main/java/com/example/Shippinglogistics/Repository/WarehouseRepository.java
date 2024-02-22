package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Warehouse;
import com.example.Shippinglogistics.entitys.Bodega;
import com.example.Shippinglogistics.entitys.crud.WarehouseCrud;
import com.example.Shippinglogistics.mapper.BodegaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WarehouseRepository implements WarehouseRepositortyInt{

    private final WarehouseCrud crud;

    private final BodegaMapper mapper;


    @Autowired
    public WarehouseRepository(WarehouseCrud crud, BodegaMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public void save(Warehouse warehouse) {
        Bodega bodega = mapper.toBodega(warehouse);
        mapper.toWarehouse(crud.save(bodega));

    }

    @Override
    public boolean existWarehouse(Integer warehouseId) {
        return crud.existsById(warehouseId);
    }

    @Override
    public List<Warehouse> getAll() {
        List<Bodega> bodegas = crud.findAll();
        return mapper.toWarehouses(bodegas);
    }

    @Override
    public Optional<Warehouse> getById(Integer warehouseId) {
        Optional<Bodega> bodega = crud.findById(warehouseId);
        return bodega.map(mapper::toWarehouse);
    }


}
