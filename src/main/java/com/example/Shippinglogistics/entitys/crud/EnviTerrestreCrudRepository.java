package com.example.Shippinglogistics.entitys.crud;

import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.entitys.EnvioTerrestre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnviTerrestreCrudRepository extends ListCrudRepository<EnvioTerrestre, Integer> {

   @Query(value = "SELECT CASE  WHEN  (SELECT COUNT(*) FROM envio_terrestre WHERE numero_guia = :numeroGuia) > 0 " +
           "THEN  true  ELSE false  END", nativeQuery = true)
    boolean existGroundShipping(@Param("numeroGuia") String numeroGuia);

    @Modifying
    @Transactional
    @Query(value = "DELETE from envio_terrestre where numero_guia = :numeroGuia", nativeQuery = true)
    void delete (@Param("numeroGuia") String numeroGuia);

 @Query(value = "select * from envio_maritimo where id_cliente = :idCliente")
 List<GroundShipping> getShippingBsByClient(@Param("idCliente") String idCliente);
}
