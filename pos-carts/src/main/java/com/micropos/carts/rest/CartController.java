package com.micropos.carts.rest;

import com.micropos.carts.api.CartApi;
import com.micropos.carts.dto.CartDto;
import com.micropos.carts.mapper.CartsMapper;
import com.micropos.carts.model.Cart;
import com.micropos.carts.model.Item;
import com.micropos.carts.service.CartService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CartController implements CartApi {
    private final CartsMapper cartsMapper;
    private final CartService cartService;
    @Autowired
    private StreamBridge streamBridge;

    @Value("${output.channel}")
    private String bindName;

    public CartController(CartsMapper cartsMapper, CartService cartService) {
        this.cartsMapper = cartsMapper;
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<CartDto> createCart() {
        Cart cart = cartService.createCart();
//        List<Item> q = cartService.getCart().getItems();
//        List<ItemDto> list = new ArrayList<>(cartsMapper.toItemsDto(cartService.getCart().getItems()));
//        var t = new ResponseEntity<List<ItemDto>>(list, HttpStatus.OK);
//        streamBridge.send(bindName, new Order());
        return new ResponseEntity<CartDto>(cartsMapper.toCartDto(cart), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CartDto> addProduct(
            @Parameter(name = "cartId", description = "Cart Id", required = true, schema = @Schema(description = "")) @PathVariable("cartId") Long cartId,
            @Parameter(name = "productId", description = "Product ID", required = true, schema = @Schema(description = "")) @PathVariable("productId") Long productId
    ) {
        cartService.add(cartId, new Item(productId, 1));
        return new ResponseEntity<CartDto>(cartsMapper.toCartDto(cartService.getCart(cartId)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> checkout(@Parameter(name = "cartId", description = "The id of the cart to retrieve", required = true, schema = @Schema(description = "")) @PathVariable("cartId") Long cartId){
        streamBridge.send(bindName, cartsMapper.toCartDto(cartService.getCart(cartId)));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
