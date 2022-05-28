package com.example.customermanagement.controller.userController;

import com.example.customermanagement.entity.Product;
import com.example.customermanagement.entity.shoppingCart.ShoppingCart;
import com.example.customermanagement.model.productModel.MySqlProductModel;
import com.example.customermanagement.model.productModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToCart extends HttpServlet {
    private ProductModel productModel;

    public AddToCart() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if(shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        try {
            int productId = Integer.parseInt(req.getParameter("productId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = productModel.findById(productId);
            if(product == null){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req, resp);
                return;
            }
            if(quantity <= 0){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req, resp);
                return;
            }
            shoppingCart.add(product, quantity);
            session.setAttribute("shoppingCart", shoppingCart);
            resp.sendRedirect("/cart");
        }catch (Exception ex){
            ex.printStackTrace();
            req.getRequestDispatcher("/user/error/500.jsp").forward(req, resp);
        }
    }
}
