package com.micropos.carts.model;

import javax.persistence.*;

import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "items")
public class Item implements Serializable {
    static long itemNum = 1;

    @Id
    @Getter
    @Setter
    private Long itemId;

    @Getter
    @Setter
    private Long productId;

    @Getter
    @Setter
    private int quantity;


    public Item(Long product, int quantity) {
        this.itemId = itemNum;
        itemNum++;
        this.productId = product;
        this.quantity = quantity;
    }

    public Item() {

    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}