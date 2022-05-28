package com.example.customermanagement.model.accountModel.orderModel;

import com.example.customermanagement.entity.Order;
import com.example.customermanagement.myEnum.OrderStatus;
import com.example.customermanagement.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderModel implements OrderModel{
    @Override
    public Order save(Order order){
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into orders " +
                    "(id, shoppingCart, totalPrice, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2, order.getShoppingCart());
            preparedStatement.setDouble(3, order.getTotalPrice());
            preparedStatement.setString(4, order.getCreatedAt().toString());
            preparedStatement.setString(5, order.getUpdatedAt().toString());
            preparedStatement.setInt(6, order.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from orders where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, OrderStatus.NOTDONE.getValue());
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int shoppingCart = resultSet.getInt("shoppingCart");
                Double totalPrice = resultSet.getDouble("totalPrice");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Order order = new Order(id, shoppingCart, totalPrice);
                order.setCreatedAt(createdAt);
                order.setUpdatedAt(updatedAt);
                order.setStatus(OrderStatus.of(status));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from orders where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, OrderStatus.NOTDONE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int shoppingCart = resultSet.getInt("shoppingCart");
                Double totalPrice = resultSet.getDouble("totalPrice");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                order = new Order(id, shoppingCart, totalPrice);
                order.setCreatedAt(createdAt);
                order.setUpdatedAt(updatedAt);
                order.setStatus(OrderStatus.of(status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order update(int id, Order updateOrder) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update orders " +
                    "set id = ?, shoppingCart = ?, totalPrice =?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateOrder.getId());
            preparedStatement.setInt(2, updateOrder.getShoppingCart());
            preparedStatement.setDouble(3, updateOrder.getTotalPrice());
            preparedStatement.setString(4, updateOrder.getCreatedAt().toString());
            preparedStatement.setString(5, updateOrder.getUpdatedAt().toString());
            preparedStatement.setInt(6, updateOrder.getStatus().getValue());
            preparedStatement.setInt(7, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateOrder;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
