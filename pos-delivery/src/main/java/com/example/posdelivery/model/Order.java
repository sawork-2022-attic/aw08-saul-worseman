package com.example.posdelivery.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Data
public class Order {
    private Long cartId;
    @Id
    @GeneratedValue
    private Long orderId;
    private double totalPrice;
    private String status;


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
