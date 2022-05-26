package com.example.customermanagement.entity;

import com.example.customermanagement.base.BaseEntity;
import com.example.customermanagement.myEnum.ProductStatus;

import java.time.LocalDateTime;

public class Product extends BaseEntity {
    private String id;
    private int categoryId;
    private String name;
    private String description;
    private String detail;
    private String image;
    private double price;
    private ProductStatus status;

    public Product() {
        this.id = "";
        this.name = "";
        this.description = "";
        this.detail = "";
        this.image = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    public Product(String id, int categoryId, String name, String description, String detail, String image, double price) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.image = image;
        this.price = price;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    //    public Product(String id, String name, String description, String detail, String image, Double price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.detail = detail;
//        this.image = image;
//        this.price = price;
//        this.setCreatedAt(LocalDateTime.now());
//        this.setUpdatedAt(LocalDateTime.now());
//        this.status = ProductStatus.ACTIVE;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
