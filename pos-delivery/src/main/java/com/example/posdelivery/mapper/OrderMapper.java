package com.example.posdelivery.mapper;

import com.example.posdelivery.dto.OrderDto;
import com.example.posdelivery.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
//    CartDto toCartDto(Cart cart);
//
//    Cart toCart(CartDto cartDto);
    OrderDto toOrderDto(Order order);
    Order toOrder(OrderDto orderDto);
}
