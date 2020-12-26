package com.mexicode.market.web.controller;

import com.mexicode.market.domain.Product;
import com.mexicode.market.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getAll(){
        return productService.getAll();
                                }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return  productService.delete(productId);
    }




}
