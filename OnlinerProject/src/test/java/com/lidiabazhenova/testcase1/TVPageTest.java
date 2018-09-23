package com.lidiabazhenova.testcase1;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.TVPage;
import com.lidiabazhenova.util.WebElementExtender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TVPageTest extends AbstractSeleniumTest {

    private static final String NAME = "Телевизор";
    private static final String TEST_PARAM_NAME = "Диагональ";
    private static final String TEST_PARAM_FIRST_VALUE = "700";
    private static final String TEST_PARAM_XPATH = "//div[./span[contains(text(),'Диагональ')]]/preceding-sibling::div/" +
            "div[@class='schema-filter-help__trigger']";
    private static final String TEST_PARAM_TEXT = "Размер диагонали экрана в дюймах. Минимальный комфортный размер " +
            "зависит от расстояния между экраном и зрителем, поскольку необходимо, чтобы изображение занимало " +
            "определенный процент поля зрения.";
    private static final String TEST_PARAM_SECOND_VALUE = "400";

    private WebDriver driver;
    private TVPage tvPage;

    @Before
    public void setTvPage() throws Exception {
        driver = getDriver();
        driver.get("https://catalog.onliner.by/tv");
        tvPage = new TVPage(driver);
    }

    @Test
    public void tvPageTest() throws Exception {
        assertPageTitle(NAME);

        tvPage.clickQuestionMark();
        Assert.assertEquals(TEST_PARAM_NAME, tvPage.getQuestionMarkFieldHeader());

        tvPage.clickQuestionMark();
        Assert.assertEquals(TEST_PARAM_FIRST_VALUE, tvPage.getQuestionMarkFieldHeaderStyle());

        WebElementExtender.waitForVisibilityOfElement(driver, By.xpath(TEST_PARAM_XPATH));
        tvPage.clickQuestionMark();

        Assert.assertEquals(TEST_PARAM_TEXT, tvPage.getQuestionMarkFieldText());

        tvPage.clickQuestionMark();
        Assert.assertEquals(TEST_PARAM_SECOND_VALUE, tvPage.getQuestionMarkFieldTextStyle());
    }
}
