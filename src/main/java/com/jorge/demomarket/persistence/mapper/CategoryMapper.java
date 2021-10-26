package com.jorge.demomarket.persistence.mapper;

import com.jorge.demomarket.domain.Category;
import com.jorge.demomarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);
    @InheritInverseConfiguration // Especificamos que tiene que hacer el mapeo inverso.
    // Usando la misma lista de Mappings
    @Mapping(target = "products", ignore = true)
    Categoria toCategoria(Category category);
}
