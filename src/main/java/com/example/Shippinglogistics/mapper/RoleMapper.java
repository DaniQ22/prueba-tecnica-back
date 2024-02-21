package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.RoleUser;
import com.example.Shippinglogistics.entitys.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RoleMapper {

    @Mappings({
            @Mapping(source = "nombreUsuario", target = "username"),
            @Mapping(source = "role", target = "roleUser"),
            @Mapping(source = "fechacreacion", target = "grantedDate"),
    })
    RoleUser toRole (Rol rol);
    List<RoleUser> toRoles(List<Rol> rols);

    @InheritInverseConfiguration
    Rol toRol (RoleUser roleUser);
}


