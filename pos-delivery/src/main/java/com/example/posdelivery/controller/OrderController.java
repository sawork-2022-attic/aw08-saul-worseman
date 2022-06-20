package com.example.posdelivery.controller;

import com.example.posdelivery.PosDeliveryApplication;
import com.example.posdelivery.api.DeliveryApi;
import com.example.posdelivery.dto.OrderDto;
import com.example.posdelivery.mapper.OrderMapper;
import com.example.posdelivery.model.Cart;
import com.example.posdelivery.model.Item;
import com.example.posdelivery.model.Order;
import com.example.posdelivery.repository.OrderRepository;
import com.example.posdelivery.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
@RequestMapping("/api")
public class OrderController implements DeliveryApi {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    public static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Bean
    public Consumer<Cart> checkorder() {
        return cart->{
            Order order = new Order();
            order.setCartId(cart.getCartId());
            order.setTotalPrice(orderService.calculateTotalPrice(cart));
            order.setStatus("not paid");
            log.info("received a new Order which thes cartId is {}", order.getCartId());
            orderService.saveOrder(order);
        };
    }

    @Override
    public ResponseEntity<OrderDto> listOrderByCartId(Long CartId){
        log.info("received");
        return new ResponseEntity<OrderDto>(orderMapper.toOrderDto(orderService.getOrderByCartId(CartId)), HttpStatus.OK);
    }


}
