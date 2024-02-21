package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.entitys.EnvioTerrestre;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ProductMapper.class})
public interface GroundShippingMapper {

    @Mappings({
            @Mapping(source = "placVehiculo", target = "licensePlate"),
            @Mapping(source = "bodegaEntrega", target = "deliveryWarehouse"),
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
            @Mapping(source = "descuento", target = "discount"),
    })
    GroundShipping toGroundShipping (EnvioTerrestre envioTerrestre);
    List<GroundShipping> toGroundShippings (List<EnvioTerrestre>  envioTerrestres);

    @InheritInverseConfiguration
    EnvioTerrestre toEnvioTerrestre (GroundShipping groundShipping);
}
