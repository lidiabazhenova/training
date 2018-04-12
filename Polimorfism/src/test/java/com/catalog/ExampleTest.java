package com.catalog;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleTest {

    @Test
    public void usageExampleList() {
        List<Product> products = new ArrayList<Product>();
        products.add(Book.createItem(1, "book title", "book description", 200, 5, 100, "author", "image"));
        products.add(Dress.createItem(1, "dress title", "dress description", 200, 5, 38, "brand", 123455, "black", "image"));
        MobilePhone mobilePhone = MobilePhone.createItem();
        mobilePhone.setId(2);
        mobilePhone.setTitle("mobile phone title");
        mobilePhone.setMemory(100);
        mobilePhone.setCoreNumber(2);
        mobilePhone.setWeight(200);
        mobilePhone.setQuantity(3);
        mobilePhone.setDescription("mobile phone description");
        mobilePhone.setPrice(345);
        products.add(mobilePhone);

        for (final Product product : products) {
            System.out.println(product.getDetails());
        }
    }

    @Test
    public void usageExampleStatic() {
        List<Product> products = new ArrayList<Product>();
        products.add(Book.createItem());
        products.add(MobilePhone.createItem());
        products.add(Dress.createItem());

        for (final Product product : products) {
            product.getDefaultImage();
        }

        Book.getDefaultImage();
        MobilePhone.getDefaultImage();
        Dress.getDefaultImage();
    }
}
