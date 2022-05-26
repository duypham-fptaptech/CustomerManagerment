package com.example.customermanagement.controller.productController;

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

public class EditProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public EditProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("category", categoryModel.findAll());
        // lấy tham số rollNumber(id)
        String id = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không.
        Product product = productModel.findById(id);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("product", product);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id = req.getParameter("id");
        Product existingProduct = productModel.findById(id);
        if(existingProduct == null){
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else{
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String detail = req.getParameter("detail");
            String image = req.getParameter("image");
            Double price = Double.valueOf(req.getParameter("price"));
            System.out.println(name);
            Product product = new Product(id, categoryId, name, description, detail, image, price);
            // validate dữ liệu
            if (productModel.update(id, product) != null) {
                resp.sendRedirect("/admin/products/list");
            } else {
                // nếu có trả về trang form
                req.setAttribute("product", product);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            }
        }
    }
}
