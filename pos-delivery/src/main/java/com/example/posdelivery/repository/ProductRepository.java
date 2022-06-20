package com.example.posdelivery.repository;


import com.example.posdelivery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

    public Product findProductByProductId(Long ProductId);


}