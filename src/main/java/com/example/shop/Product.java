package com.example.shop;

public class Product {
    private int ID;
    private String type;
    private String SKU;
    private String name;
    private boolean isFeatured;

    public Product(int ID, String type, String SKU, String name, boolean isFeatured) {
        this.ID = ID;
        this.type = type;
        this.SKU = SKU;
        this.name = name;
        this.isFeatured = isFeatured;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public boolean getIsFeatured() {
        return isFeatured;
    }
}
