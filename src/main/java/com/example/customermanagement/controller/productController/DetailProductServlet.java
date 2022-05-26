package com.example.customermanagement.controller.productController;

import com.example.customermanagement.entity.Product;
import com.example.customermanagement.model.productModel.MySqlProductModel;
import com.example.customermanagement.model.productModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailProductServlet extends HttpServlet {

    private ProductModel productModel;

    public DetailProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        String id = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không.
        Product product = productModel.findById(id);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            ArrayList<Product> recentView = (ArrayList<Product>) session.getAttribute("recentView");
            if (recentView == null){
                recentView = new ArrayList<Product>();
            }
            boolean exist = false;
            for (int i = 0; i < recentView.size(); i++) {
                if (recentView.get(i).getId().equals(product.getId())){
                    exist = true;
                }
            }
            if (!exist){
                recentView.add(product);
                session.setAttribute("recentView", recentView);
            }
            // nếu có trả về trang detail
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }

    }
}
