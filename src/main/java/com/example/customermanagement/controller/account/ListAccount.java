package com.example.customermanagement.controller.account;

import com.example.customermanagement.entity.Account;
import com.example.customermanagement.entity.Product;
import com.example.customermanagement.model.accountModel.AccountModel;
import com.example.customermanagement.model.accountModel.MySqlAccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAccount extends HttpServlet {
    private AccountModel accountModel;

    public ListAccount() {
        this.accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> list = accountModel.findAll();
        req.setAttribute("listAccount", list);
        req.getRequestDispatcher("/admin/accounts/list.jsp").forward(req, resp);
    }
}
