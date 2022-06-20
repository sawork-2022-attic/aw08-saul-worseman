package com.example.posdelivery.service;

import com.example.posdelivery.model.Cart;
import com.example.posdelivery.model.Item;
import com.example.posdelivery.model.Order;
import com.example.posdelivery.repository.OrderRepository;
import com.example.posdelivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order getOrderByCartId(Long cartId){
        return orderRepository.getOrderByCartId(cartId);
    }

    @Override
    public double calculateTotalPrice(Cart cart){
        double price  = 0;
        List<Item> list = cart.getItems();
        for(var item: list){
            price += productRepository.findProductByProductId(item.getProductId()).getPrice() * item.getQuantity();
        }
        return price;
    }

    @Override
    public  void saveOrder(Order order){
        orderRepository.save(order);
    }
}
