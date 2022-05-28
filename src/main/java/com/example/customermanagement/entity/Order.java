package com.example.customermanagement.entity;

import com.example.customermanagement.base.BaseEntity;
import com.example.customermanagement.myEnum.OrderStatus;
import com.example.customermanagement.myEnum.ProductStatus;

import java.time.LocalDateTime;

public class Order extends BaseEntity {
    private int id;
    private int shoppingCart;
    private double totalPrice;
    private OrderStatus status;

    public Order() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = OrderStatus.NOTDONE;
    }

    public Order(int id, int shoppingCart, double totalPrice, OrderStatus status) {
        this.id = id;
        this.shoppingCart = shoppingCart;
        this.totalPrice = totalPrice;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = OrderStatus.NOTDONE;
    }

    public Order(int id, int shoppingCart, Double totalPrice) {
        this.id = id;
        this.shoppingCart = shoppingCart;
        this.totalPrice = totalPrice;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = OrderStatus.NOTDONE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(int shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
