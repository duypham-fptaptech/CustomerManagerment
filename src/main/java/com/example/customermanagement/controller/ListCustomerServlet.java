package com.example.customermanagement.controller;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.model.CustomerModel;
import com.example.customermanagement.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerModel customerModel;

    public ListCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = customerModel.findAll();
        req.setAttribute("listCustomer", list);
        req.getRequestDispatcher("/admin/customers/list.jsp").forward(req, resp);
    }
}