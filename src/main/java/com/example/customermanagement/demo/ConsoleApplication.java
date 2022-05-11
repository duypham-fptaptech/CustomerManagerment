package com.example.customermanagement.demo;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.model.CustomerModel;
import com.example.customermanagement.model.InMemoryCustomerModel;
import com.example.customermanagement.model.MySqlCustomerModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
private static CustomerModel customerModel;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    customerModel = new InMemoryCustomerModel();
                    break;
                case 2:
                    customerModel = new MySqlCustomerModel();
                    break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Customer Manager--------------");
            System.out.println("1. Create new customer");
            System.out.println("2. Show all customer");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Cya!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter rollNumber to update: ");
        String id = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(id);
        if (existingCustomer == null) {
            System.err.println("404, Student not found!");
        } else {
            if (customerModel.delete(id)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter rollNumber to update: ");
        String rollNumber = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(rollNumber);
        if (existingCustomer == null) {
            System.err.println("404, Student not found!");
        } else {
            System.out.println("Please enter full name");
            String name = scanner.nextLine();
            existingCustomer.setName(name);
            if (customerModel.update(rollNumber, existingCustomer) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllCustomer() {
        List<Customer> list = customerModel.findAll();
        for (Customer customer :
                list) {
            System.out.println(customer.toString());
        }
    }

    private static void createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter roll number");
        String id = scanner.nextLine();
        System.out.println("Please enter full name");
        String name = scanner.nextLine();
        Customer customer = new Customer(id, name, "0235435", "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg", LocalDateTime.of(2000, 10, 10, 10, 10));
        if (customerModel.save(customer) != null) {
            System.out.println("Create student success!");
        } else {
            System.err.println("Save student fails, please try again later!");
        }
    }
}
