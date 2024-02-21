package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Customer;
import com.example.Shippinglogistics.entitys.Cliente;
import com.example.Shippinglogistics.entitys.crud.CustomerCrudRepository;
import com.example.Shippinglogistics.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CustomerRepositoryInt{

    private final CustomerMapper mapper;

    private final CustomerCrudRepository crudRepository;

    @Autowired
    public CustomerRepository(CustomerMapper mapper, CustomerCrudRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }


    @Override
    public void save(Customer customer) {
        Cliente cliente = mapper.toCliente(customer);
        mapper.toCustomer(crudRepository.save(cliente));
    }

    @Override
    public boolean existById(String cutomerId) {
        return crudRepository.existsById(cutomerId);
    }
}
