package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for iphonePage
 */
public class IPhone7Page extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Аккумулятор и время работы')]")
    private WebElement headingAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Тип аккумулятора')]]/td[1]")
    private WebElement typeAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Тип аккумулятора')]]/td[2]")
    private WebElement descriptionTypeAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Ёмкость аккумулятора')]]/td[1]")
    private WebElement capacityAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Ёмкость аккумулятора')]]/td[2]")
    private WebElement descriptionCapacityAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время разговора')]]/td[1]")
    private WebElement talkTimeAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время разговора')]]/td[2]")
    private WebElement descriptionTalkTimeAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время ожидания')]]/td[1]")
    private WebElement waitTimeAccumulator;

    @FindBy(xpath = "//tr[td//text()[contains(., 'Время ожидания')]]/td[2]")
    private WebElement descriptionWaitTimeAccumulator;

    /**
     * constructor for iphone7Page
     *
     * @param driver
     */
    public IPhone7Page(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get field accumulators.
     *
     * @return current element
     */
    public WebElement getFieldAccumulators() {
        return headingAccumulator;
    }

    /**
     * Method to get field "type of accumulator".
     *
     * @return current element
     */
    public WebElement getTypeAccumulator() {
        return typeAccumulator;
    }

    /**
     * Method to get description of accumulator type.
     *
     * @return current element
     */
    public WebElement getDescriptionType() {
        return descriptionTypeAccumulator;
    }

    /**
     * Method to get field "accumulator capacity".
     *
     * @return current element
     */
    public WebElement getCapacity() {
        return capacityAccumulator;
    }

    /**
     * Method to get value of accumulator capacity.
     *
     * @return current element
     */
    public WebElement getValueCapacity() {
        return descriptionCapacityAccumulator;
    }

    /**
     * Method to get field "accumulator talk time".
     *
     * @return current element
     */
    public WebElement getTalkTimeAccumulator() {
        return talkTimeAccumulator;
    }

    /**
     * Method to get value of accumulator talk time.
     *
     * @return current element
     */
    public WebElement getValueTalkTimeAccumulator() {
        return descriptionTalkTimeAccumulator;
    }

    /**
     * Method to get field "accumulator wait time".
     *
     * @return current element
     */
    public WebElement getWaitTime() {
        return waitTimeAccumulator;
    }

    /**
     * Method to get value of accumulator wait time.
     *
     * @return current element
     */
    public WebElement getDescriptionWaitTime() {
        return descriptionWaitTimeAccumulator;
    }
}
