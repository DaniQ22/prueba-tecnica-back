package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.Product;
import com.example.Shippinglogistics.entitys.Producto;
import com.example.Shippinglogistics.entitys.crud.ProductCrud;
import com.example.Shippinglogistics.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInt{

    private final ProductMapper mapper;
    private final ProductCrud crud;

    @Autowired
    public ProductRepository(ProductMapper mapper, ProductCrud crud) {
        this.mapper = mapper;
        this.crud = crud;
    }

    @Override
    public void save(Product product) {
        Producto producto = mapper.toProducto(product);
        mapper.toProduct(crud.save(producto));

    }

    @Override
    public boolean exiistProduct(Integer productId) {
        return crud.existsById(productId);
    }

    @Override
    public List<Product> gettALl() {
        List<Producto> productos = crud.findAll();
        return mapper.toProducts(productos);
    }
}
