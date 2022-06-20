package com.micropos.carts.repository;

import com.micropos.carts.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart findCartByCartId(Long CartId);
}
