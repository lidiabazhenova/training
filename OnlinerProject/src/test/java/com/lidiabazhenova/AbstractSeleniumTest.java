package com.lidiabazhenova;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    private final static String GECKO_BASE_PATH = "C:\\projects\\drivers\\geckodriver.exe";

    private final static String GECKO_BASE_NAME = "webdriver.gecko.driver";
    protected static final String TITLE = "%s купить в Минске";

    protected static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty(GECKO_BASE_NAME, GECKO_BASE_PATH);

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
