package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.MaritimeShipping;
import com.example.Shippinglogistics.entitys.EnvioMaritimo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ProductMapper.class})
public interface MaritimeShippingMapper {

    @Mappings({
            @Mapping(source = "numeroFlota", target = "fleetNumber"),
            @Mapping(source = "puertoEntrega", target = "portDelivery"),
            @Mapping(source = "idEnvio", target = "id"),
            @Mapping(source = "idCliente", target = "idCustomer"),
            @Mapping(source = "cantidadProducto", target = "quantityProduct"),
            @Mapping(source = "fechaEntrega", target = "dateDelivery"),
            @Mapping(source = "precioEnvio", target = "price"),
            @Mapping(source = "fechaRegistro", target = "dateRegistry"),
            @Mapping(source = "numeroGuia", target = "guideNumber"),
            @Mapping(source = "tipoProducto", target = "typeProduct"),
            @Mapping(source = "cliente", target = "customer"),
            @Mapping(source = "producto", target = "product"),
            @Mapping(source = "precioTotal", target = "priceTotal"),
            @Mapping(source = "descuento", target = "discount")
    })
    MaritimeShipping toMaritimeShipping (EnvioMaritimo envioMaritimo);
    List<MaritimeShipping> toMaritimeShippings (List<EnvioMaritimo> envioMaritimos);

    @InheritInverseConfiguration
    EnvioMaritimo toEnvioMaritimo (MaritimeShipping maritimeShipping);
}
