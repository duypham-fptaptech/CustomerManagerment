package com.example.customermanagement.controller.productController;

import com.example.customermanagement.entity.Category;
import com.example.customermanagement.entity.Product;
import com.example.customermanagement.model.productModel.CategoryModel;
import com.example.customermanagement.model.productModel.MySqlCategoryModel;
import com.example.customermanagement.model.productModel.MySqlProductModel;
import com.example.customermanagement.model.productModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CreateProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("category", categoryModel.findAll());
        req.setAttribute("product", new Product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        int id = Integer.parseInt(req.getParameter("id"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        String image = req.getParameter("image");
        Double price = Double.valueOf(req.getParameter("price"));
        System.out.println(name);
        Product product = new Product(id, categoryId, name, description, detail, image, price);
        HashMap<String, String> errors = new HashMap<>();
        // validate dữ liệu theo kiểu cùi bắp.
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
        if (detail == null || detail.length() == 0) {
            errors.put("detail", "Please enter detail");
        }
        if (image == null || image.length() == 0) {
            errors.put("image", "Please enter image");
        }

        if (price == null || price.doubleValue() == 0) {
            errors.put("price", "Please enter price");
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