package com.mexicode.market.persistence.crud;

import com.mexicode.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository  extends CrudRepository<Compra, Integer> {

    //**QueryMethod
                /**Devuelve una lista de clientes*/
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
