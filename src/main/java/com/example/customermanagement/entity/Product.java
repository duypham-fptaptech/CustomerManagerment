package com.example.customermanagement.entity;

import java.time.LocalDateTime;

public class Product {
    private String id;
    private String name;
    private String image;
    private String price;
    private String quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Product(String id, String name, String image, String price, String quantity, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Product() {
        this.id = "";
        this.name = "";
        this.image = "";
        this.price = "";
        this.quantity = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status =1;
    }

    public Product(String id, String name, String image, String price, String quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status =1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
