package com.example.customermanagement.model;

import com.example.customermanagement.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer); // lưu thông tin.

    List<Customer> findAll();

    Customer findById(String id);

    Customer update(String id, Customer updateCustomer);

    boolean delete(String id);
}
