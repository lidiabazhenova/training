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
    private List<WebElement> productsToCompareCaption;

    @FindBy(css = ".product-summary__price")
    private List<WebElement> productsToComparePrice;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage getSearchPage() {
        inputSearch.sendKeys("HTC");

        driver.switchTo().frame(driver.findElement(By.cssSelector(".modal-iframe")));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".search__bar_searching")));

        return new SearchPage(driver);
    }

    public List<WebElement> getProductsToCompareCaption() {
        return productsToCompareCaption;
    }

    public List<WebElement> getProductsToComparePrice() {
        return productsToComparePrice;
    }
}
