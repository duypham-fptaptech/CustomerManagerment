package com.example.customermanagement.model.accountModel.orderModel;

import com.example.customermanagement.entity.Order;

import java.util.List;

public interface OrderModel {
    Order save(Order order); // lưu thông tin.

    List<Order> findAll();

    Order findById(int id);

    Order update(int id, Order updateOrder);
}