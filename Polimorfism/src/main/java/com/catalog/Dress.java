package com.catalog;

public class Dress extends Product {

    private int size;
    private String brand;
    private long code;
    private String color;

    public Dress() {
    }

    public Dress(long id, String title, String description, double price, double quantity, int size, String brand, long code, String color, String image) {
        super(id, title, description, price, quantity, image);
        this.size = size;
        this.brand = brand;
        this.code = code;
        this.color = color;
    }

    public String getDetails() {
        return super.getDetails() + "Size: " + size + "\r\n " + "Brand: " + brand + "\r\n " + "Code: " + code + "\r\n " + "Color: " + color + "\r\n ";
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void getDefaultImage() {
        System.out.println("dress default image");
    }

    public static Dress createItem() {
        return new Dress();
    }

    public static Dress createItem(long id, String title, String description, double price, double quantity, int size, String brand, long code, String color, String image) {
        return new Dress(id, title, description, price, quantity, size, brand, code, color, image);
    }
}