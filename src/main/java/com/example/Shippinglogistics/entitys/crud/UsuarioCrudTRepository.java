package com.example.Shippinglogistics.entitys.crud;

import com.example.Shippinglogistics.entitys.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioCrudTRepository extends ListCrudRepository<Usuario, String> {
    @Query(value = "select contrasena from usuario where correo = :email", nativeQuery = true)
    String recoverPassword (@Param("email") String email);



    //Aqui estoy buscando un correo si existe devolvera true
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM usuario WHERE correo = :email", nativeQuery = true)
    int isExistEmail(@Param("email") String email);
}
