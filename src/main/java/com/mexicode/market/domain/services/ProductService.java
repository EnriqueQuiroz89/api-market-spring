package com.mexicode.market.domain.services;

import com.mexicode.market.domain.Product;
import com.mexicode.market.domain.repository.ProductRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**LA clase sirve como negociador entre el controlador y el repositorio */

@Service   /**Indica que es un servicio de nuestra logica de negocio*/
public class ProductService {


    @Autowired  /**Spring se encarga*/
    private ProductRepository productRepository;

    /**CHECA QUE AQUI YA ES PUBLIC*/

    /**Quiero todos los products*/
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    /**Quiero solo un producto*/
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    /**Todos de una categoria*/
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    /**Guarda un Product*/
    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        /**Mediante este metodo eliminamos
         * y ademas podemos devolver un Boolean*/
        return getProduct(productId).map(product -> {
                productRepository.delete(productId);
            return true;
        }).orElse(false );
                                         }



}
