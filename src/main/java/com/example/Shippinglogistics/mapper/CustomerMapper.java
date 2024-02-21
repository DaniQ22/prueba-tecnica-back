package com.example.Shippinglogistics.mapper;

import com.example.Shippinglogistics.DTO.Customer;
import com.example.Shippinglogistics.entitys.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//Mapp Struct me permite generar automáticamente implementaciones de
// mapeadores Java basadas en interfaces definidas por el usuario.

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({

            @Mapping(source = "idCliente", target = "customerId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "direccion", target = "addres")
    })

    Customer toCustomer (Cliente cliente);
    List<Customer> toCustomers (List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente (Customer customer);

}
