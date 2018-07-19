package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for tablePCPage
 */
public class TabletPCPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class=\"schema-filter__fieldset\"]//div//span[contains(text(), 'Производитель')]")
    private WebElement producerCheckBox;

    /**
     * constructor for tabletPCPage
     *
     * @param driver
     */
    public TabletPCPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get header of page
     *
     * @return String text of title
     */

    public WebElement getProducerCheckBox() {
        return producerCheckBox;
    }
}
