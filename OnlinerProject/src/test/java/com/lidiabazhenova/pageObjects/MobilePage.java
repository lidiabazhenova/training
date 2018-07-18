package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;
import java.util.List;

/**
 * class for mobilePage
 */
public class MobilePage {
    private WebDriver driver;

    /**
     * constructor for mobilePage
     *
     * @param driver
     */
    public MobilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    private WebElement heading;

    @FindBy(xpath = "//div[@class=\"schema-product__group\"]")
    private List<WebElement> allElements;

    @FindBy(xpath = "//span[@data-bind='html: product.extended_name || product.full_name']")
    private List<WebElement> headingsAllElements;

    @FindBy(xpath = "//span[@data-bind='html: product.description']")
    private List<WebElement> descriptionAllElements;

    @FindBy(xpath = "//div[@class='schema-product__price-group']/div[1]/div[@class='schema-product__price']//span")
    private List<WebElement> priceAllElements;

    @FindBy(xpath = "//div[@class='schema-product__price-group']/div[1]/div[@class='schema-product__price']//span")
    private WebElement priceElement;

    /**
     * Method to get header of page
     *
     * @return String text of heading
     */
    public String getHeadingText() {
        return heading.getText();
    }

    /**
     * Method to get count of phones on this page
     *
     * @return int count of phones
     */
    public int getPhoneCount() {
        return allElements.size();
    }

    /**
     * Method to get list of  phone headings on this page
     *
     * @return list of phone headings
     */
    public List<WebElement> getHeadingsAllElements() {
        return headingsAllElements;
    }

    /**
     * Method to get list of  phone descriptions on this page
     *
     * @return list of phone descriptions
     */
    public List<WebElement> getDescriptionAllElements() {
        return descriptionAllElements;
    }

    /**
     * Method to get list of  phone prices on this page
     *
     * @return list of phone prices
     */
    public List<WebElement> getPriceAllElements() {
        return priceAllElements;
    }

}