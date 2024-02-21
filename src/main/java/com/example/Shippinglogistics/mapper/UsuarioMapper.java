package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.User;
import com.example.Shippinglogistics.entitys.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "nombreUsuario", target = "username"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "habilidato", target = "disable"),
            @Mapping(source = "bloquedo", target = "locked"),
            @Mapping(source = "roles", target = "userRoles")

    })
    User toUser (Usuario usuario);
    List<User> toUsers (List<Usuario> usuarios);


    @InheritInverseConfiguration
    Usuario toUsuario (User user);

}
