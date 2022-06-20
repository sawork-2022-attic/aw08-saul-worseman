package com.micropos.carts.mapper;

import com.micropos.carts.dto.CartDto;
import com.micropos.carts.dto.ItemDto;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface CartsMapper {

    CartDto toCartDto(Cart cart);

    Cart toCart(CartDto cartDto);

    Collection<ItemDto> toItemsDto(Collection<Item> items);

    Collection<Item> toItems(Collection<ItemDto> items);

    ItemDto toItemDto(Item Item);

    Item toItem(ItemDto Item);
}
