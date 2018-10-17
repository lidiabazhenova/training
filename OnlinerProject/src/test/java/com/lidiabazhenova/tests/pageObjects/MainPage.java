package com.lidiabazhenova.tests.pageObjects;

import com.lidiabazhenova.framework.util.WebElementExtender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for mainPage
 */
public class MainPage extends AbstractPage {

    private static final String SEARCH_IFRAME_SELECTOR = ".modal-iframe";
    private static final String SEARCH_INDICATOR_SELECTOR = ".search__bar_searching";

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement inputSearch;

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
    public SearchPage search(final String searchText) {
        inputSearch.sendKeys(searchText);

        driver.switchTo().frame(driver.findElement(By.cssSelector(SEARCH_IFRAME_SELECTOR)));
        WebElementExtender.waitForInvisibilityOfElement(driver, By.cssSelector(SEARCH_INDICATOR_SELECTOR));

        return new SearchPage(driver);
    }

}
