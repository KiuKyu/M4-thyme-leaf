package com.codegym.model;

public class Product {
    private int Id;
    private String name;
    private double price;
    private String description;
    private String image;

    public Product() {
    }

    public Product(int id, String name, double price, String description, String image) {
        Id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Product(String name, double price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
