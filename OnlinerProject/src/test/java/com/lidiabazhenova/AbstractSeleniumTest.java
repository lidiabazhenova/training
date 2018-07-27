package com.lidiabazhenova;

import com.lidiabazhenova.factory.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractSeleniumTest {

    protected static final String TITLE_FORMAT = "%s купить в Минске";

    protected void assertPageTitle(final String pageTitle) throws Exception {

        WebDriver driver = WebDriverFactory.getInstance();
        Assert.assertEquals(String.format(TITLE_FORMAT, pageTitle), driver.getTitle());
    }
}