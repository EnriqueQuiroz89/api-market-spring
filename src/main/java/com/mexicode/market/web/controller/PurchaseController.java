package com.mexicode.market.web.controller;

import com.mexicode.market.domain.Purchase;
import com.mexicode.market.domain.services.ProductService;
import com.mexicode.market.domain.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")

public class PurchaseController {
    //Inyecto el servicio y lo cableo
    @Autowired
    private PurchaseService purchaseService;

    ///TRES METOdos
    @GetMapping("/all")  ///Retornara un Re
    public ResponseEntity<List<Purchase>> getAll(){
        return  new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
                          }
                         //Compras por client
    @GetMapping("/purchase/{id}")
    public ResponseEntity<List<Purchase>>        //Lo que voy a devolver
           getByClient(@PathVariable("id") String clientId){

        return purchaseService.getByClient(clientId)         /**Obtngo una lista de compras*/
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))  /**Si exito la lista la devulevo mediante ResponseEntity*/
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));            /**Si fallo devuelvo Not found*/

    }
    /**Al guardar que devulevo si exito --> una purchase*/
                                       //Paso como parametro el objeto que quiero guardar
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.OK);
    }

}
