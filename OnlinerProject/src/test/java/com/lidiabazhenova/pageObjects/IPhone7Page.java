package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for iphonePage
 */
public class IPhone7Page extends AbstractPage {

    @FindBy(xpath = "//div[contains(text(),'Аккумулятор и время работы')]")
    private WebElement headingButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Тип аккумулятора')]]/td[1]")
    private WebElement typeButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Тип аккумулятора')]]/td[2]")
    private WebElement descriptionTypeButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Ёмкость аккумулятора')]]/td[1]")
    private WebElement capacityButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Ёмкость аккумулятора')]]/td[2]")
    private WebElement descriptionCapacityButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время разговора')]]/td[1]")
    private WebElement talkTimeButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время разговора')]]/td[2]")
    private WebElement descriptionTalkTimeButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время ожидания')]]/td[1]")
    private WebElement waitTimeButtery;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время ожидания')]]/td[2]")
    private WebElement descriptionWaitTimeButtery;

    /**
     * constructor for iphone7Page
     *
     * @param driver
     */
    public IPhone7Page(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get field butterys.
     *
     * @return current element
     */
    public WebElement getFieldButteries() {
        return headingButtery;
    }

    /**
     * Method to get field "type of buttery".
     *
     * @return current element
     */
    public WebElement getTypeButtery() {
        return typeButtery;
    }

    /**
     * Method to get description of buttery type.
     *
     * @return current element
     */
    public WebElement getDescriptionType() {
        return descriptionTypeButtery;
    }

    /**
     * Method to get field "buttery capacity".
     *
     * @return current element
     */
    public WebElement getCapacity() {
        return capacityButtery;
    }

    /**
     * Method to get value of buttery capacity.
     *
     * @return current element
     */
    public WebElement getValueCapacity() {
        return descriptionCapacityButtery;
    }

    /**
     * Method to get field "buttery talk time".
     *
     * @return current element
     */
    public WebElement getTalkTimeButtery() {
        return talkTimeButtery;
    }

    /**
     * Method to get value of buttery talk time.
     *
     * @return current element
     */
    public WebElement getValueTalkTimeButtery() {
        return descriptionTalkTimeButtery;
    }

    /**
     * Method to get field "buttery wait time".
     *
     * @return current element
     */
    public WebElement getWaitTime() {
        return waitTimeButtery;
    }

    /**
     * Method to get value of buttery wait time.
     *
     * @return current element
     */
    public WebElement getDescriptionWaitTime() {
        return descriptionWaitTimeButtery;
    }
}
