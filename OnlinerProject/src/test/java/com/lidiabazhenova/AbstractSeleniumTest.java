package com.lidiabazhenova;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    private final static String GECKO_BASE_PATH = "C:\\projects\\Selenium\\drivers\\geckodriver.exe";
    protected static final String TITLE = "%s купить в Минске";


    protected static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.gecko.driver", GECKO_BASE_PATH);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
