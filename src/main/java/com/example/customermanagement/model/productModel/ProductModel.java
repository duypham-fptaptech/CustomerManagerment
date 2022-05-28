package com.example.customermanagement.model.productModel;

import com.example.customermanagement.entity.Product;

import java.util.List;

public interface ProductModel {
    Product save(Product product); // lưu thông tin.

    List<Product> findAll();

    Product findById(int id);

    Product update(int id, Product updateProduct);

    boolean delete(int id);
}
