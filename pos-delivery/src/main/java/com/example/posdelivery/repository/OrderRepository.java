package com.example.posdelivery.repository;

import com.example.posdelivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order getOrderByCartId(Long id);
}
