package com.mexicode.market.persistence;

import com.mexicode.market.domain.Product;
import com.mexicode.market.domain.repository.ProductRepository;
import com.mexicode.market.persistence.crud.ProductoCrudRepository;
import com.mexicode.market.persistence.entity.Producto;
import com.mexicode.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  //Estereotipo de SpringFramework
             /**Se encarga de interactuar con la tabla productos de la BD*/
public class ProductoRepository  implements ProductRepository {

         /**Invoca a la interfaza para ocupar el CRUDrepository*/
    private  ProductoCrudRepository productoCrudRepository;
         /**Para hacer la conversion Producto a Product usamos el MAPPER*/
    private ProductMapper mapper;

    //Quiero  una lista de todos los productos
    public List<Product> getAll(){  //AL IMPLEMENTAR RETORNA LISTA DE PRODUCT
       //el metodo findAll() devuelve una lista de todos los productos
         List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
          return mapper.toProducts(productos);
                                  }

            /**Metodos de la interfaz*/
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }



    //Quiero una lista de todos los productos en una categoria
    public  List<Producto> getByCategoria(int idCategoria){
          return  productoCrudRepository.findByIdCategoria(idCategoria);
      }

    //Lo mismo de arriba y ordenados por nombre ascendente
    public  List<Producto> getByCategoriaOrderByNombreAsc(int idCategoria){
        return  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    //Articulos bajo Stock y que esten activos
    public Optional<List<Producto>> get(int cantidadStock){
        return  productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
                                                           }
    //Quiero un producto en PArticular
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto); //This is native QueryMethod
                                                            }
    //Quiero guardar un producto
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto); //Native QueryMethods
                                           }

    //Quiero eliminar un producto // Es sin return
    public void  delete(int idProducto){
        productoCrudRepository.deleteById(idProducto); //Native QueryMethods
                                       }

}
