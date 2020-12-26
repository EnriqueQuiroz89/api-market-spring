package com.mexicode.market.persistence.mapper;

import com.mexicode.market.domain.Purchase;
import com.mexicode.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "Spring", uses= {PurchaseItemMapper.class})
public interface PurchaseMapper {


        /**Mapeador In Compra Out Purchase*/
    @Mappings({
            @Mapping(source ="idCompra" ,target = "purchaseId"),
            @Mapping(source ="idCliente" ,target = "clientId"),
            @Mapping(source ="fecha" ,target = "date"),
            @Mapping(source ="medioPago" ,target = "paymentMethod"),
            @Mapping(source ="comentario" ,target = "comment"),
            @Mapping(source ="estado" ,target = "state"),
            @Mapping(source ="productos" , target = "purchaseItems")
    })
    Purchase toPurchase(Compra compra);
   /**LA definicion de arriba replica el Papings para la lista debaj*/
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
