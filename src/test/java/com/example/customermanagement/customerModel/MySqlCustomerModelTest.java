package com.example.customermanagement.customerModel;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.model.customerModel.CustomerModel;
import com.example.customermanagement.model.customerModel.MySqlCustomerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class MySqlCustomerModelTest {

    CustomerModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlCustomerModel();
    }

    @Test
    void save() {
        model.save(new Customer("A005", "Nguyen", "02334535232", "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg", LocalDateTime.of(2003, 5, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Customer>list = model.findAll();
        for (Customer customer: list
             ) {
            System.out.println(customer.toString());
        }
    }

    @Test
    void findById() {

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}