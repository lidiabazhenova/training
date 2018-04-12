package com.catalog.product;

public class Book extends Product {

    private final static String DEFAULT_IMAGE = "book default image";

    private int pageNumber;
    private String author;

    private Book() {
    }

    private Book(long id, String title, String description, double price, double quantity, int pageNumber, String author,
                 String image) {
        super(id, title, description, price, quantity, image);
        this.pageNumber = pageNumber;
        this.author = author;
    }

    public String getDetails() {
        return super.getDetails()
                + "Page number: " + pageNumber + "\r\n "
                + "Author: " + author + "\r\n ";
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static String getDefaultImage() {
        return DEFAULT_IMAGE;
    }

    public static Book createItem() {
        return new Book();
    }

    public static Book createItem(long id, String title, String description, double price, double quantity, int pageNumber, String author, String image) {
        return new Book(id, title, description, price, quantity, pageNumber, author, image);
    }
}
