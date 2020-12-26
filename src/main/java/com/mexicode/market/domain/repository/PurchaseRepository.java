package com.mexicode.market.domain.repository;

import com.mexicode.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    /**Todas las listas*/
    List<Purchase> getAll();
    /**Las compras de un cliente*/ /**Habra clientes que no tengan compras*/
    Optional<List<Purchase>> getByClient(String clientId);
    /**Guardar una compra*/
    Purchase save(Purchase purchase);

}
