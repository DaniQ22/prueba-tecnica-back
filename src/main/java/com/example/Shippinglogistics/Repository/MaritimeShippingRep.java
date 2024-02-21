package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.MaritimeShipping;
import com.example.Shippinglogistics.entitys.EnvioMaritimo;
import com.example.Shippinglogistics.entitys.crud.EnvioMaritimoCrudRepository;
import com.example.Shippinglogistics.mapper.MaritimeShippingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaritimeShippingRep implements MaritimeShippingRepInt{

    private final MaritimeShippingMapper mapper;

    private final EnvioMaritimoCrudRepository crudRepository;

    @Autowired
    public MaritimeShippingRep(MaritimeShippingMapper mapper, EnvioMaritimoCrudRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(MaritimeShipping maritimeShipping) {
        EnvioMaritimo envioMaritimo = mapper.toEnvioMaritimo(maritimeShipping);
        mapper.toMaritimeShipping(crudRepository.save(envioMaritimo));
    }

    @Override
    public List<MaritimeShipping> getALL() {
        List<EnvioMaritimo> envioMaritimos = crudRepository.findAll();
        return mapper.toMaritimeShippings(envioMaritimos);
    }

    @Override
    public boolean existMaritimeShipping(String numberGuide) {
        return crudRepository.existGroundShipping(numberGuide);
    }

    @Override
    public void delete(String numberGuide) {
        crudRepository.delete(numberGuide);

    }
}
