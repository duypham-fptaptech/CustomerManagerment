package com.example.customermanagement.productController;

import com.example.customermanagement.entity.Product;
import com.example.customermanagement.productModel.MySqlProductModel;
import com.example.customermanagement.productModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateProductServlet extends HttpServlet {

    private ProductModel productModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("product", new Product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        String price = req.getParameter("price");
        String quantity = req.getParameter("quantity");
        System.out.println(name);
        Product product = new Product(id, name, image, price, quantity);
        HashMap<String, String> errors = new HashMap<>();
        // validate dữ liệu theo kiểu cùi bắp.
        if (id == null || id.length() == 0) {
            errors.put("id", "Please enter id");
        }
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (image == null || image.length() == 0) {
            errors.put("image", "Please enter image");
        }

        if (price == null || price.length() == 0) {
            errors.put("price", "Please enter price");
        }
        if (quantity == null || quantity.length() == 0) {
                errors.put("quantity", "Please enter quantity");
            }
        if (errors.size() > 0) {
            req.setAttribute("product", product);
            req.setAttribute("action", 1);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }
        if (productModel.save(product) != null) {
            resp.sendRedirect("/admin/products/list");
        } else {
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
}
}