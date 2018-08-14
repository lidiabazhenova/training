package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * class for comparePage
 */
public class ComparePage extends AbstractPage {

    @FindBy(css = ".product-summary__caption")
    private List<WebElement> itemsToCompareCaption;

    @FindBy(css = ".product-summary__price")
    private List<WebElement> itemsToComparePrice;

    /**
     * constructor for comparePage
     *
     * @param driver
     */
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get captions of products to compare
     *
     * @return list of captions
     */
    public List<WebElement> getItemsToCompareCaption() {
        return itemsToCompareCaption;
    }

    /**
     * Method to get prices of products to compare
     *
     * @return list of prices
     */
    public List<WebElement> getItemsToComparePrice() {
        return itemsToComparePrice;
    }
}
