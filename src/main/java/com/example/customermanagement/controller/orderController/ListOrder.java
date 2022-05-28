package com.example.customermanagement.controller.orderController;

import com.example.customermanagement.entity.Product;
import com.example.customermanagement.model.accountModel.orderModel.OrderModel;
import com.example.customermanagement.model.productModel.MySqlProductModel;
import com.example.customermanagement.model.productModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListOrder extends HttpServlet {
    private OrderModel orderModel;
}
