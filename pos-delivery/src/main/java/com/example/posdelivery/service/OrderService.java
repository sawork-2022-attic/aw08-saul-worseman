package com.example.posdelivery.service;

import com.example.posdelivery.model.Cart;
import com.example.posdelivery.model.Order;

public interface OrderService {
    public Order getOrderByCartId(Long cartId);

    public double calculateTotalPrice(Cart cart);

    public void saveOrder(Order order);
}
