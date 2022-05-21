package com.example.customermanagement.customerController;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.customerModel.CustomerModel;
import com.example.customermanagement.customerModel.MySqlCustomerModel;
import com.example.customermanagement.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public CreateCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("dob");
        System.out.println(name);
        Customer customer = new Customer(id, name, phone, image);
        HashMap<String, String> errors = new HashMap<>();
        if (stringBirthday != null && stringBirthday.length() > 0) {
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            customer.setDob(birthday);
        }
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
        if (phone == null || phone.length() == 0) {
            errors.put("phone", "Please enter phone");
        }
        if (errors.size() > 0) {
            req.setAttribute("customer", customer);
            req.setAttribute("action", 1);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            return;
        }
        if (customerModel.save(customer) != null) {
            resp.sendRedirect("/admin/customers/list");
        } else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
