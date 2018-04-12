package com.catalog;

import com.catalog.product.Book;
import com.catalog.product.MobilePhone;
import com.catalog.product.Product;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleTest {

    @Test()
    @Ignore
    public void usageExampleCategoryTree() {
        final List<Product> mobilePhonesItems = new ArrayList<Product>();
        mobilePhonesItems.add(MobilePhone.createItem(2, "title description", "mobile description", 300, 6, 4, 4, 100, "image"));
        final Category mobilePhoneCategory = new Category(1, "Mobile phones", new ArrayList<Category>(), mobilePhonesItems);

        final List<Product> bookItems = new ArrayList<Product>();
        bookItems.add(Book.createItem(1, "book title", "book description", 200, 5, 100, "author", "image"));
        final Category bookCategory = new Category(2, "Books", new ArrayList<Category>(), bookItems);

        final List<Category> categories = new ArrayList<Category>();
        categories.add(mobilePhoneCategory);
        categories.add(bookCategory);
        final Category rootCategory = new Category(3, "Catalogue", categories, new ArrayList<Product>());
    }

    @Test
    public void usageExampleList() {
        List<Product> products = new ArrayList<Product>();
        products.add(Book.createItem(1, "book title", "book description", 200, 5, 100, "author", "image"));
        MobilePhone mobilePhone = MobilePhone.createItem();
        mobilePhone.setId(2);
        mobilePhone.setTitle("mobile phone title");
        mobilePhone.setMemory(100);
        mobilePhone.setCoreNumber(2);
        mobilePhone.setWeight(200);
        mobilePhone.setQuantity(3);
        mobilePhone.setDescription("mobile phone description");
        mobilePhone.setPrice(-345);
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

        for (final Product product : products) {
            System.out.println(product.getDefaultImage());
        }

        System.out.println(Book.getDefaultImage());
        System.out.println(MobilePhone.getDefaultImage());
    }
}
