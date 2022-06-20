package com.micropos.products.repository;


import com.micropos.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

    public Product findProductByProductId(Long ProductId);

    public List<Product> findAll();

}