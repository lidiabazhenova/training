package com.lidiabazhenova.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * class for creating Webdriver
 */
public final class WebDriverFactory {

    private static final String SELENIUM_BROWSER_PARAM = "selenium.browser";
    private static final String SELENIUM_BROWSER_CHROME = "chrome";
    private static final String SELENIUM_BROWSER_FIREFOX = "firefox";

    private static boolean isInitialized;
    private static WebDriver driver;

    /**
     * Method to get Webdriver for different browsers
     * @return driver
     * @throws Exception
     */
    public static WebDriver getInstance() throws Exception {
        if (isInitialized) {
            return driver;
        }

        final String seleniumBrowser = System.getProperty(SELENIUM_BROWSER_PARAM);

        if (SELENIUM_BROWSER_CHROME.equals(seleniumBrowser)) {
            driver = createChromeDriver();
        } else if (SELENIUM_BROWSER_FIREFOX.equals(seleniumBrowser)) {
            driver = createFirefoxDriver();
        } else {
            driver = createFirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        isInitialized = true;

        return driver;
    }

    /**
     * @return
     * Method to create Webdriver for Chrome
     */
    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }


    /**
     * Method to create Webdriver for Firefox
     * @return
     */
    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
