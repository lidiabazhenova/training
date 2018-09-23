package com.lidiabazhenova.pageObjects;

import com.lidiabazhenova.util.WebElementExtender;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for tvPage
 */
public class TVPage extends AbstractPage {

    @FindBy(xpath = "//div[./span[contains(text()," +
            "'Диагональ')]]/preceding-sibling::div/div[@class=\"schema-filter-help__trigger\"]")
    private WebElement questionMark;

    @FindBy(xpath = "//div[./span[contains(text(),'Диагональ')]]/preceding-sibling::div/" +
            "div[@class='schema-filter-help__trigger']")
    private WebElement dialogPopup;

    @FindBy(xpath = "//div[contains(text(),'Диагональ')]")
    private WebElement questionMarkFieldHeader;

    @FindBy(xpath = "//div[contains(text(),'Размер диагонали экрана в дюймах. Минимальный комф')]")
    private WebElement questionMarkFieldText;

    /**
     * constructor for tvPage
     *
     * @param driver
     */
    public TVPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to click questionMark opposite the text "Диагональ"
     *
     * @return current page
     */
    public TVPage clickQuestionMark() {
        WebElementExtender.click(driver, questionMark);
        WebElementExtender.waitForVisibilityOfElement(driver, dialogPopup);

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
     * Method to get font-weight to text: "Диагональ".
     *
     * @return int font-weight
     */
    public int getQuestionMarkFieldHeaderFontWeight() {
        return NumberUtils.toInt(questionMarkFieldHeader.getCssValue("font-weight"));
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
     * Method to get font-weight to text: "Диагональ".
     *
     * @return int font-weight
     */
    public int getQuestionMarkFieldTextFontWeight() {
        return NumberUtils.toInt(questionMarkFieldText.getCssValue("font-weight"));
    }

}
