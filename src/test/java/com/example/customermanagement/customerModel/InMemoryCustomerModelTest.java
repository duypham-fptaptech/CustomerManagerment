package com.example.customermanagement.customerModel;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.model.customerModel.InMemoryCustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InMemoryCustomerModelTest {

    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryCustomerModel();
    }
    @Test
    void save() {
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().toString());
    }

    @Test
    void findById() {
        Customer customer = model.findById("A001");
        System.out.println(customer.toString());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}