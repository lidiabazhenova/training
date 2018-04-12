package com.catalog;

import com.catalog.product.Product;

import java.util.List;

public class Category {

    private long id;
    private String title;
    private List<Category> childCategories;
    private List<Product> products;

    public Category() {

    }

    public Category(long id, String title, List<Category> childCategories, List<Product> products) {
        this.id = id;
        this.title = title;
        this.childCategories = childCategories;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
