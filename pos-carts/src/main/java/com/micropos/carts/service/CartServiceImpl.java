package com.micropos.carts.service;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import com.micropos.carts.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void add(Long CartId, Item item) {
        Cart cart = cartRepository.getById(CartId);
        cart.addItem(item);
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart getCart(Long CartId){
        Cart cart = cartRepository.getById(CartId);
        return cart;
    }


}
