package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.Warehouse;
import com.example.Shippinglogistics.entitys.Bodega;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.math.BigDecimal;
import java.sql.Wrapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BodegaMapper {

    @Mappings({
            @Mapping(source = "idBodega", target = "warehouseId"),
            @Mapping(source = "nombreBodega", target = "name"),
            @Mapping(source = "ubicacion", target = "location"),
            @Mapping(source = "capacidad", target = "capacity")
    })
    Warehouse toWarehouse (Bodega bodega);

    List<Warehouse> toWarehouses (List<Bodega> bodegas);

    @InheritInverseConfiguration
    Bodega toBodega (Warehouse warehouse);
}
