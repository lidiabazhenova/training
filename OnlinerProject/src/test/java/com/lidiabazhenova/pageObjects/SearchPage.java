package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * class for searchPage
 */
public class SearchPage extends AbstractPage {

    @FindBy(css = ".product__compare")
    private List<WebElement> checkboxes;

    @FindBy(css = ".product__price span")
    private List<WebElement> prices;

    @FindBy(css = ".product__title-link")
    private List<WebElement> titles;

    @FindBy(css = ".compare-button")
    private WebElement toCompareButton;

    /**
     * constructor for searchPage
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get fields of checkboxes
     *
     * @return list of checkboxes
     */
    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    /**
     * Method to get fields of phones titles
     *
     * @return list of titles
     */
    public List<WebElement> getTitles() {
        return titles;
    }

    /**
     * Method to get fields of phones prices
     *
     * @return list of prices
     */
    public List<WebElement> getPrices() {
        return prices;
    }

    /**
     * Method to get compare button
     *
     * @return compare button
     */
    public WebElement getToCompareButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".compare-button_visible")));
        return toCompareButton;
    }

    /**
     * Method to get compare page
     *
     * @return mainPage
     */
    public MainPage getComparePage() {
        driver.switchTo().defaultContent();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-iframe-visible")));

        return new MainPage(driver);
    }
}
