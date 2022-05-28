package com.example.customermanagement.controller.account;

import com.example.customermanagement.entity.Account;
import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.model.accountModel.AccountModel;
import com.example.customermanagement.model.accountModel.MySqlAccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAccount extends HttpServlet {
    private AccountModel accountModel;

    public DeleteAccount() {
        this.accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        int id = Integer.parseInt(req.getParameter("id"));
        // kiểm tra trong database xem có tồn tại không.
        Account account = accountModel.findById(id);
        // nếu không trả về trang 404
        if (account == null) {
            req.setAttribute("message", "Account not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = accountModel.delete(id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/accounts/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/errors/500.jsp").forward(req, resp);
            }
        }
    }
}
