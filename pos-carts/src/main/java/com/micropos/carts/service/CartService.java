package com.micropos.carts.service;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;

import java.util.List;

public interface CartService {
    public void add(Long CartId, Item item);

    public Cart getCart(Long CartId);

    public Cart createCart();

}
