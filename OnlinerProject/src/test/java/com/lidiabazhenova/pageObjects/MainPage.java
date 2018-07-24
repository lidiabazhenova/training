package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * class for mainPage
 */
public class MainPage extends AbstractPage {

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement inputSearch;

    @FindBy(css = ".product-summary__caption")
    private List<WebElement> itemsToCompareCaption;

    @FindBy(css = ".product-summary__price")
    private List<WebElement> itemsToComparePrice;

    /**
     * constructor for mainPage
     *
     * @param driver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get search page
     *
     * @return searchPage
     */
    public SearchPage getSearchPage() {
        inputSearch.sendKeys("HTC");

        driver.switchTo().frame(driver.findElement(By.cssSelector(".modal-iframe")));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".search__bar_searching")));

        return new SearchPage(driver);
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
