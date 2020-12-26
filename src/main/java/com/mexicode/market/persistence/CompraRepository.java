package com.mexicode.market.persistence;

import com.mexicode.market.domain.Purchase;
import com.mexicode.market.domain.repository.PurchaseRepository;
import com.mexicode.market.persistence.crud.CompraCrudRepository;
import com.mexicode.market.persistence.entity.Compra;
import com.mexicode.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  //Comunica con la BD
public class CompraRepository implements PurchaseRepository {

    /**Invoco la interfaza  para poder ocupar
     * los metodos de CRUDRepository*/
    @Autowired //INyectar
    private CompraCrudRepository compraCrudRepository; //coencta BD
    @Autowired //Inyectar
    private PurchaseMapper mapper;


    @Override  /**Todas las compras*/
    public List<Purchase> getAll() {
                 //traduzco una lista de compras a Purchases
        return  mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    /**Todas la compras de un cliente*/
    @Override  /**Me pide purchase pero mi CRUD devuelve Compras*/
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));  /**Con esto traduzco de Compras a Purchase*/
     }

     /**GuardarUna compra*/
        //PAso1   PAsar una un purchase al metodo
        //PAso2   mediante el mapper convertir Purchase a Compra
        //Paso3   Obtegno todos los productos incluidos en una compra

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        /**Me traigo todos los productos de la compraR*/
        compra.getProductos().forEach(producto ->  producto.setCompra(compra));
        /**Retorno un Purchase mediante el metodo*/
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
