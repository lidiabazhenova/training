package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(id = "search-page")
    private WebElement searchForm;

    /**
     * constructor for searchPage
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get searchForm
     * @return searchForm
     */
    public WebElement getSearchForm() {
        return searchForm;
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
        return toCompareButton;
    }

    /**
     * Method to get compare page
     *
     * @return mainPage
     */
    public ComparePage getComparePage() {
        driver.switchTo().defaultContent();

        return new ComparePage(driver);
    }
}
