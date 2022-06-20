package com.example.posdelivery.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Cart implements Serializable {

//    private static long cartNum = 1;
//
//    public Cart(){
//        this.cartId = cartNum;
//        cartNum++;
//    }


    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "carts_items",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))

    @Setter
    @Getter
    private List<Item> items = new ArrayList<>();



    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<Item> getItems(){
        return items;
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}