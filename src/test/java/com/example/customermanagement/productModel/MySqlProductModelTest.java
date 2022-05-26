package com.example.customermanagement.productModel;

import com.example.customermanagement.entity.Product;
import com.example.customermanagement.model.productModel.MySqlProductModel;
import com.example.customermanagement.model.productModel.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySqlProductModelTest {

    private ProductModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product();
        product.setId("A007");
        product.setCategoryId(1);
        product.setDescription("name");
        product.setDetail("name");
        product.setName("name");
        product.setPrice(10000);
        product.setImage("name");
        model.save(product);
    }
}