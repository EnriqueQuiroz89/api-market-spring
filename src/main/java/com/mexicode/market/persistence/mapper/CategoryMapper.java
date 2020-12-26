package com.mexicode.market.persistence.mapper;


import com.mexicode.market.domain.Category;
import com.mexicode.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") /**Indico a java que es un mapeador*/

public interface CategoryMapper {

    /**Convirtiendo categorias to category*/
    @Mappings({
            @Mapping(source = "idCategoria", target = "CategoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
             })

    /**Conversores*/
    Category toCategory(Categoria categoria);

    /**Conversion externa*/
    @InheritInverseConfiguration /**No evita definif Mappings*/
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);


}