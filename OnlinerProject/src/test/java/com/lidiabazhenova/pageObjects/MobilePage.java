package com.lidiabazhenova.pageObjects;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * class for mobilePage
 */
public class MobilePage extends AbstractPage {

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
     * constructor for mobilePage
     *
     * @param driver
     */
    public MobilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get count of phones on this page
     *
     * @return int count of phones
     */
    public int getPhoneCount() {
        return CollectionUtils.size(allElements);
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
