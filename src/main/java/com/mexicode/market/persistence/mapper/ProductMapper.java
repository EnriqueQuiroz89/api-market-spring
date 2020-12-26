package com.mexicode.market.persistence.mapper;

import com.mexicode.market.domain.Product;
import com.mexicode.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**Indico que cuando quiera convertir Category*/
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    /**Conversores o mappers*/
    @Mappings({
            @Mapping(source = "idProducto", target ="productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
                             //Ya tiene su propio Mapper
            @Mapping(source = "categoria", target = "category")

    })
    Product toProduct(Producto producto);
    /**No hace falta definir un nuevo mapings
     *  ya que replica lo del objeto de arriba*/
    List<Product> toProducts(List<Producto> productos);

    /**Conversion contraria*/
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProduct(Product product);

}
