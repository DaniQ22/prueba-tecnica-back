package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.Product;
import com.example.Shippinglogistics.entitys.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "tipoProducto", target = "type")

    })
    Product toProduct(Producto producto);
    List<Product> toProducts (List<Producto> productos);

    @InheritInverseConfiguration
    Producto toProducto (Product product);
}
