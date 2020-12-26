package com.mexicode.market.persistence.crud;

import com.mexicode.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**En esta interfaz extiedo de un SpringData Repositories*/

public interface ProductoCrudRepository
                   extends CrudRepository<Producto, Integer> {

    /**Primer QueruMethod*/
    //Quiero toda la lista de productos
    // que pertenescan a una categoria
                         /**Respeto Camelcase*/
    List<Producto> findByIdCategoria(int idCategoria);

    /**Segundo QueruMethod*/
    // Misma lista de arriba pero ordenados por Nombre Acsendent
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    /**Tercer QueruMethod*/
    //Lista productos con bajo Stock  //private Integer cantidadStock;
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);




}
