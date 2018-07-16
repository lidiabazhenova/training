package com.lidiabazhenova;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    private final static String GECKO_BASE_PATH = "C:\\projects\\Selenium\\drivers\\geckodriver.exe";

    protected WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.gecko.driver", GECKO_BASE_PATH);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}
