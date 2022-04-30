package com.example.shop;

import java.util.List;

public class Shop {
    private List<Product> featured;
    private List<Product> other;

    public Shop(List<Product> featured, List<Product> other) {
        this.featured = featured;
        this.other = other;
    }

    public List<Product> getFeatured() {
        return featured;
    }

    public List<Product> getOther() {
        return other;
    }
}
