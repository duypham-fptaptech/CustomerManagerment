package com.example.customermanagement.model.productModel;

import com.example.customermanagement.entity.Category;
import com.example.customermanagement.entity.Product;

import java.util.List;

public interface CategoryModel {
    Category save(Category category); // lưu thông tin.

    List<Category> findAll();

    Category findById(int id);

    Category update(int id, Category updateCategory);

    boolean delete(int id);
}
