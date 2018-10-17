package com.lidiabazhenova.tests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for iphonePage
 */
public class IPhone7Page extends AbstractPage {

    @FindBy(xpath = "//div[contains(text(),'Аккумулятор и время работы')]")
    private WebElement fieldButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Тип аккумулятора')]]/td[2]")
    private WebElement typeButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Ёмкость аккумулятора')]]/td[2]")
    private WebElement capacityButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время разговора')]]/td[2]")
    private WebElement talkingTime;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время ожидания')]]/td[2]")
    private WebElement waitTimeButtery;

    /**
     * constructor for iphone7Page
     *
     * @param driver
     */
    public IPhone7Page(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get field butteries.
     *
     * @return current element
     */
    public WebElement getFieldButteries() {
        return fieldButtery;
    }

    /**
     * Method to get buttery type.
     *
     * @return description of buttery type
     */
    public String getTypeButtery() {
        return typeButtery.getText();
    }

    /**
     * Method to get buttery capacity.
     *
     * @return value of buttery capacity
     */
    public String getCapacity() {
        return capacityButtery.getText();
    }

    /**
     * Method to get buttery talking time.
     *
     * @return value of buttery talking time
     */
    public String getTalkingTime() {
        return talkingTime.getText();
    }

    /**
     * Method to get buttery wait time.
     *
     * @return value of buttery wait time.
     */
    public String getWaitTime() {
        return waitTimeButtery.getText();
    }
}
