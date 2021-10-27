package com.jorge.demomarket.persistence;

import com.jorge.demomarket.domain.Product;
import com.jorge.demomarket.domain.repository.ProductRepository;
import com.jorge.demomarket.persistence.crud.ProductoCrudRepository;
import com.jorge.demomarket.persistence.entity.Producto;
import com.jorge.demomarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Especificamos a springBoot que esta clase se encarga de interactuar con la BD
public class ProductoRepository implements ProductRepository {

    @Autowired // Especificamos que Spring se encargue de crear las instancias del objeto definido
    // Debemos tener en cuenta que el objeto q queremos injectar debe ser un componente de Spring
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));

    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /*public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }*/

    /*public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }*/

    /*public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }*/

    /*public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }*/

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
