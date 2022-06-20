package com.example.posdelivery.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
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