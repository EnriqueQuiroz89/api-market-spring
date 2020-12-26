package com.mexicode.market.web.controller;

import com.mexicode.market.domain.Product;
import com.mexicode.market.domain.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")  // Terminos de dominio

public class ProductController {
    @Autowired  /**POdemos por que la interfaz tiene una anotacion de Spring*/
    private ProductService productService;

    /**Devolvera un alisat de productoss*/
    @GetMapping("/all")
    @ApiOperation("Obtiene todos los productos del mercado")
    public ResponseEntity<List<Product>>  getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
                                }


                                /**Cambio Optional por resposnse Entity*/
    @GetMapping("/{id}")
    @ApiOperation("Obtiene el producto que sea indicado mediante un ID")
    @ApiResponses( {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Producto no encontrado")
                  } )
    public  ResponseEntity<Product> getProduct(@ApiParam(value = "El id del producto"
                                                            ,required = true
                                                            ,example = "7")
                                               @PathVariable("id") int productId){
        return productService.getProduct(productId)
                  .map(product -> new ResponseEntity<>(product, HttpStatus.OK)) /**SI EXITO*/
                  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));          /**SI FALLO*/
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Obtiene todos los productos que tenga en comun el id_categoria que se indique")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId).
                map(products -> new ResponseEntity<>(products, HttpStatus.OK)) //EXITO
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));           //FALLO
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
         if(productService.delete(productId)){
             return new ResponseEntity(HttpStatus.OK);
             } else {
             return new ResponseEntity(HttpStatus.NOT_FOUND);
                     }
       }




}
