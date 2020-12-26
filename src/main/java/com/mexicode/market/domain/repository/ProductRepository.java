package com.mexicode.market.domain.repository;


import com.mexicode.market.domain.Product;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();
    Optional<Product> getProduct(int productId);
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);

    Product save(Product product);
    void delete(int productId);


}
