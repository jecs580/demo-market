package com.jorge.demomarket.persistence.crud;

import com.jorge.demomarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // Consulta de manera nativa
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true )
    List<Producto> getByCategoria(int idCategoria);

    // Consulta usando Query Methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
