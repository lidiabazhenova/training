package com.lidiabazhenova;

import com.lidiabazhenova.factory.WebDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public abstract class AbstractSeleniumTest {

    protected static final String TITLE_FORMAT = "%s купить в Минске";
    protected static final String PRODUCTS_LOADING_INDICATOR_SELECTOR = ".schema-products_processing";

    private WebDriver driver;

    @Before
    public void initWebDriver() throws Exception {
        driver = WebDriverFactory.getInstance();
    }

    @After
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void assertPageTitle(final String pageTitle) throws Exception {
        Assert.assertEquals(String.format(TITLE_FORMAT, pageTitle), driver.getTitle());
    }
}