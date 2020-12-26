package com.mexicode.market.persistence;

import com.mexicode.market.domain.Product;
import com.mexicode.market.domain.repository.ProductRepository;
import com.mexicode.market.persistence.crud.ProductoCrudRepository;
import com.mexicode.market.persistence.entity.Producto;
import com.mexicode.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  //Estereotipo de SpringFramework
             /**Se encarga de interactuar con la tabla productos de la BD*/
public class ProductoRepository  implements ProductRepository {

    @Autowired /**Que se encargue Spring de crearlo*/
         /**Invoca a la interfaza para ocupar el CRUDrepository*/
    private  ProductoCrudRepository productoCrudRepository;
    @Autowired  /**Solo asegurate  que sea un componente de Spring*/
         /**Para hacer la conversion Producto a Product usamos el MAPPER*/
    private ProductMapper mapper;

    //Quiero  una list1a de todos los productos
    @Override
    public List<Product> getAll(){  //AL IMPLEMENTAR RETORNA LISTA DE PRODUCT
       //el metodo findAll() devuelve una lista de todos los productos
         List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
          return mapper.toProducts(productos);
                                  }

            /**Metodos de la interfaz*/
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
      List<Producto> productos= productoCrudRepository.findByIdCategoria(categoryId);
      return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
      /**No tengo un mapeador que convierta una lista de opcionales
       * Por ende  a los productos hacer un map*/
      Optional<List<Producto>> productos= productoCrudRepository
                                          .findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId)
                                     .map(producto -> mapper.toProduct(producto)); //This is native QueryMethod

    }

    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProduct(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    //Quiero eliminar un producto // Es sin return
    public void  delete(int productId){
        productoCrudRepository.deleteById(productId); //Native QueryMethods
                                       }

}
