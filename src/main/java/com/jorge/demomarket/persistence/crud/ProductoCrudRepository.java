package com.jorge.demomarket.persistence.crud;

import com.jorge.demomarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
