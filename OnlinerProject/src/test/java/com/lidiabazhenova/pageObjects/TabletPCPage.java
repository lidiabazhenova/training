package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * class for tablePCPage
 */
public class TabletPCPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = TITLE_X_PATH)
    private WebElement title;

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
    public String getTitle() {
        return title.getText();
    }

    public WebElement getProducerCheckBox() {
        return producerCheckBox;
    }
}
