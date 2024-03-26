package com.example.orm.repository;

import com.example.orm.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByNameContains(String n);
    public  List<Product> findByPriceGreaterThan(double price);
    public List<Product> updateProductById(Long id);
    public List<Product> removeProductById(Long id);
          @Query("select p from Product p where p.name like :x ")
    List<Product> search(@Param("x") String n);

    @Query("select p from Product p where p.price>:x ")
    List<Product> searchByPrice(@Param("x") double price);

}
