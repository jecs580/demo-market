package com.jorge.demomarket.persistence;

import com.jorge.demomarket.persistence.crud.ProductoCrudRepository;
import com.jorge.demomarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
