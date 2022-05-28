package com.example.customermanagement.controller.userController;

import com.example.customermanagement.entity.Product;
import com.example.customermanagement.model.productModel.MySqlProductModel;
import com.example.customermanagement.model.productModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/page/cart.jsp").forward(req, resp);
    }
}
