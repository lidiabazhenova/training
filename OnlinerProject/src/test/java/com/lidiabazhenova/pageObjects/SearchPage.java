package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(css = ".i-checkbox__real")
    private List<WebElement> checkboxes;

    @FindBy(css = ".product__price span")
    private List<WebElement> prices;

    @FindBy(css = ".product__title-link")
    private List<WebElement> titles;

    @FindBy(css = ".compare-button")
    private WebElement toCompareButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getTitles() {
        return titles;
    }

    public WebElement getToCompareButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".compare-button_visible")));
        return toCompareButton;
    }

    public MainPage getComparePage() {
        driver.switchTo().defaultContent();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-iframe-visible")));

        return new MainPage(driver);
    }

    public List<WebElement> getPrices() {
        return prices;
    }
}
