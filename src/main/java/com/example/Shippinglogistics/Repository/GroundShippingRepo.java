package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.entitys.EnvioTerrestre;
import com.example.Shippinglogistics.entitys.crud.EnviTerrestreCrudRepository;
import com.example.Shippinglogistics.mapper.GroundShippingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroundShippingRepo implements GroundShippingRepoInt{

    private final EnviTerrestreCrudRepository crudRepository;

    private final GroundShippingMapper mapper;

    @Autowired
    public GroundShippingRepo(EnviTerrestreCrudRepository crudRepository, GroundShippingMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    @Override
    public void save(GroundShipping groundShipping) {
        EnvioTerrestre envioTerrestre  = mapper.toEnvioTerrestre(groundShipping);
        mapper.toGroundShipping(crudRepository.save(envioTerrestre));
    }

    @Override
    public List<GroundShipping> getALL() {
        List<EnvioTerrestre> enviosTerrestres = crudRepository.findAll();
        return mapper.toGroundShippings(enviosTerrestres);
    }

    @Override
    public boolean existGroundShipping(String guideNumber) {
        return crudRepository.existGroundShipping(guideNumber);
    }

    @Override
    public void delete(String guideNumber) {
         crudRepository.delete(guideNumber);
    }

    @Override
    public List<GroundShipping> getBuCustomer() {
        return null;
    }


}
