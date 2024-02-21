package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.Port;
import com.example.Shippinglogistics.entitys.Puerto;
import jakarta.persistence.Id;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PortMapper {


    @Mappings({
            @Mapping(source = "idPuerto", target = "portId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "ubicacion", target = "location"),
            @Mapping(source = "capacidad", target = "capacity"),

    })
    Port toPort (Puerto puerto);
    List<Port> toPorts (List<Puerto> puertos);

    @InheritInverseConfiguration
    Puerto toPuero (Port port);
}
