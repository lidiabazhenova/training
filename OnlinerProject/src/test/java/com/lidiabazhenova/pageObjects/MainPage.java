package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * class for mainPage
 */
public class MainPage extends AbstractPage{
    private WebDriver driver;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement inputSearch;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputSearch() {
        return inputSearch;
    }
}
