package com.catalog;

public abstract class Product {

    private long id;
    private String title;
    private String description;
    private double price;
    private double quantity;
    private String image;

    protected Product() {

    }

    protected Product(long id, String title, String description, double price, double quantity, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public String getDetails() {
        return " Id: " + id + "\r\n " + "Title: " + title + "Description: " + description + "\r\n " + "Price: " + price + "\r\n "
                + "Quantity: " + quantity + "\r\n " + "Image: " + image + "\r\n ";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static void getDefaultImage() {
        System.out.println("product default image");
    }
}
