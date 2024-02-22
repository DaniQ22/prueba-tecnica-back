package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Port;
import com.example.Shippinglogistics.entitys.Puerto;
import com.example.Shippinglogistics.entitys.crud.PortCrud;
import com.example.Shippinglogistics.mapper.PortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PortRepository implements PortRespositoryInt{
    private final PortCrud crud;

    private final PortMapper mapper;


    @Autowired
    public PortRepository(PortCrud crud, PortMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }


    @Override
    public void save(Port port) {

    }

    @Override
    public boolean existPort(Integer portId) {
        return crud.existsById(portId);
    }

    @Override
    public List<Port> getAll() {
        List< Puerto> puertos = crud.findAll();
        return mapper.toPorts(puertos);
    }

    @Override
    public Optional<Port> getPorById(Integer portId) {
        Optional<Puerto> puerto = crud.findById(portId);
        return puerto.map(mapper::toPort);
    }
}
