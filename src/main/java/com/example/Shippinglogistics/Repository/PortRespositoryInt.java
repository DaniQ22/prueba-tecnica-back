package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Port;
import com.fasterxml.jackson.annotation.OptBoolean;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PortRespositoryInt {

    void save(Port port);

    boolean existPort(Integer portId);

    List<Port> getAll();

    Optional<Port> getPorById(Integer portId);

}
