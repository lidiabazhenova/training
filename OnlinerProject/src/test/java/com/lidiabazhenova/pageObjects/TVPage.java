package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * class for tvPage
 */
public class TVPage {
    private WebDriver driver;

    /**
     * constructor for tvPage
     *
     * @param driver
     */
    public TVPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    private WebElement heading;

    @FindBy(xpath = "//div[./span[contains(text()," +
            "'Диагональ')]]/preceding-sibling::div/div[@class=\"schema-filter-help__trigger\"]")
    private WebElement questionMark;

    @FindBy(xpath = "//div[contains(text(),'Диагональ')]")
    private WebElement questionMarkFieldHeader;

    @FindBy(xpath = "//div[contains(text(),'Размер диагонали экрана в дюймах. Минимальный комф')]")
    private WebElement questionMarkFieldText;

    /**
     * Method to check header of page
     *
     * @return String text of heading
     */
    public String getHeadingText() {
        return heading.getText();
    }

    /**
     * Method to click questionMark opposite the text "Диагональ"
     *
     * @return current page
     */
    public TVPage clickQuestionMark() {
        questionMark.click();

        return this;
    }

    /**
     * Method to get text: "Диагональ".
     *
     * @return String text
     */
    public String getQuestionMarkFieldHeader() {
        return questionMarkFieldHeader.getText();
    }

    /**
     * Method to get text-style to text: "Диагональ".
     *
     * @return String text
     */
    public String getQuestionMarkFieldHeaderStyle() {
        return questionMarkFieldHeader.getCssValue("font-weight");
    }

    /**
     * Method to get text: "Размер диагонали экрана в дюймах. Минимальный комфортный размер зависит от расстояния
     * между экраном и зрителем, поскольку необходимо, чтобы изображение занимало определенный процент поля зрения."
     *
     * @return String text
     */
    public String getQuestionMarkFieldText() {
        return questionMarkFieldText.getText();
    }

    /**
     * Method to get text-style to text: "Диагональ".
     *
     * @return String text
     */
    public String getQuestionMarkFieldTextStyle() {
        return questionMarkFieldText.getCssValue("font-weight");
    }

}