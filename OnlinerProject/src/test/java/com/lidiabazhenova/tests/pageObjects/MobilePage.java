package com.lidiabazhenova.tests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * class for mobilePage
 */
public class MobilePage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"schema-product__group\"]")
    private List<WebElement> allPhones;

    @FindBy(xpath = "//span[@data-bind='html: product.extended_name || product.full_name']")
    private List<WebElement> headingsAllPhones;

    @FindBy(xpath = "//span[@data-bind='html: product.description']")
    private List<WebElement> descriptionAllPhones;

    @FindBy(xpath = "//div[@class='schema-product__price-group']/div[1]/div[@class='schema-product__price']//span")
    private List<WebElement> priceAllPhones;

    @FindBy(xpath = "//div[@class='schema-product__price-group']/div[1]/div[@class='schema-product__price']//span")
    private WebElement pricePhone;

    @FindBy(xpath = "//div[@class='schema-product__price-group']/div[1]/div[@class='schema-product__status']")
    private List<WebElement> productStatus;

    /**
     * constructor for mobilePage
     *
     * @param driver
     */
    public MobilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to all phones on this page
     *
     * @return int count of phones
     */
    public List<WebElement> getAllPhones() {
        return allPhones;
    }

    /**
     * Method to get list of  phone headings on this page
     *
     * @return list of phone headings
     */
    public List<WebElement> getHeadingsAllPhones() {
        return headingsAllPhones;
    }

    /**
     * Method to get list of  phone descriptions on this page
     *
     * @return list of phone descriptions
     */
    public List<WebElement> getDescriptionsAllPhones() {
        return descriptionAllPhones;
    }

    /**
     * Method to get list of  phone prices on this page
     *
     * @return list of phone prices
     */
    public List<WebElement> getPricesAllPhones() {
        return priceAllPhones;
    }

    /**
     * Method to get list of  status for phones without price
     *
     * @return list of status
     */
    public List<WebElement> getProductStatus() {
        return productStatus;
    }

}
