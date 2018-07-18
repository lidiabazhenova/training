package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * class for mobilePage
 */
public class IPhone7Page {

    private WebDriver driver;

    /**
     * constructor for mobilePage
     *
     * @param driver
     */
    public IPhone7Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//div[@class=\"schema-product__group\"]")
//    private List<WebElement> allElements;

    @FindBy(xpath = "//div[contains(text(),'Аккумулятор и время работы')]")
    private WebElement descriptionHeadingAccumulator;

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

    public WebElement getDescriptionHeadingAccumulator() {
        return descriptionHeadingAccumulator;
    }

    public WebElement getTypeAccumulator() {
        return typeAccumulator;
    }

    public WebElement getDescriptionTypeAccumulator() {
        return descriptionTypeAccumulator;
    }

    public WebElement getCapacityAccumulator() {
        return capacityAccumulator;
    }

    public WebElement getDescriptionCapacityAccumulator() {
        return descriptionCapacityAccumulator;
    }

    public WebElement getTalkTimeAccumulator() {
        return talkTimeAccumulator;
    }

    public WebElement getDescriptionTalkTimeAccumulator() {
        return descriptionTalkTimeAccumulator;
    }

    public WebElement getWaitTimeAccumulator() {
        return waitTimeAccumulator;
    }

    public WebElement getDescriptionWaitTimeAccumulator() {
        return descriptionWaitTimeAccumulator;
    }
}
