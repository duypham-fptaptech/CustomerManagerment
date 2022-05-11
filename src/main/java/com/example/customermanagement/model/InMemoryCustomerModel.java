package com.example.customermanagement.model;

import com.example.customermanagement.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel{
    private static List<Customer> customers;

    public InMemoryCustomerModel() {
        customers = new ArrayList<>();
        customers.add(
                new Customer(
                        "A001",
                        "Duy",
                        "0345342234",
                        "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "A002",
                        "Duc",
                        "023252352",
                        "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg",
                        LocalDateTime.of(2003, 11, 2, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "A003",
                        "Hung",
                        "023523423",
                        "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg",
                        LocalDateTime.of(2002, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "A004",
                        "Nguyen",
                        "0235325423",
                        "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg",
                        LocalDateTime.of(2001, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String id) {
        Customer foundCustomer = null;
        for (Customer customer :
                customers) {
            if (customer.getId().equals(id)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(String id, Customer updateCustomer) {
        Customer existingCustomer = findById(id);
        if(existingCustomer == null){
            return null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdatedAt(LocalDateTime.now());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(String id) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId().equals(i)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
