package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstract class for Page
 */
public class AbstractPage {
    protected WebDriver driver;


    /**
     *Constructor for creating a page
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
