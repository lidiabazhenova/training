package com.lidiabazhenova.factory;

import com.lidiabazhenova.AbstractSeleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public final class WebDriverFactory {

    private final static String GECKO_BASE_PATH = "C:\\projects\\drivers\\geckodriver.exe";
    private final static String GECKO_BASE_NAME = "webdriver.gecko.driver";
    private final static String CHROME_BASE_PATH = "C:\\projects\\drivers\\chromedriver.exe";
    private final static String CHROME_BASE_NAME = "webdriver.chrome.driver";

    private static boolean isInitialized;
    private static WebDriver driver;

    public static WebDriver getInstance() throws Exception {
        if (isInitialized) {
            return driver;
        }

        Properties properties = new Properties();
        properties.load(AbstractSeleniumTest.class.getClassLoader().getResourceAsStream("data.properties"));
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.out.println(browserName);
            System.setProperty(CHROME_BASE_NAME, CHROME_BASE_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("firefox")) {
            System.out.println(browserName);
            System.setProperty(GECKO_BASE_NAME, GECKO_BASE_PATH);
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        isInitialized = true;

        return driver;
    }
}
