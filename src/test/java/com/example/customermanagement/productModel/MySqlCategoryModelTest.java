package com.example.customermanagement.productModel;

import com.example.customermanagement.entity.Category;
import com.example.customermanagement.model.productModel.CategoryModel;
import com.example.customermanagement.model.productModel.MySqlCategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {

    private CategoryModel model;
    @BeforeEach
    void setUp() {
        model = new MySqlCategoryModel();
    }

    @Test
    void save() {
        Category category = new Category();
        category.setName("ao");
        model.save(category);
        Category category2 = new Category();
        category2.setName("quan");
        model.save(category2);
        assertEquals(2, model.findAll().size());
    }
}