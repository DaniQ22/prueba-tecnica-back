package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Port;

import java.util.List;

public interface PortRespositoryInt {

    void save(Port port);

    boolean existPort(Integer portId);

    List<Port> getAll();
}
