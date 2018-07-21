package com.lidiabazhenova;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class AbstractSeleniumTest {

    private final static String GECKO_BASE_PATH = "C:\\projects\\Selenium\\drivers\\geckodriver.exe";
    private final static String FIREBUG_BASE_PATH =
            "C:\\projects\\trainingNew\\training\\OnlinerProject\\src\\test\\resources\\firefox\\firebug.xpi";
    private final static String FIREBPATH_BASE_PATH =
            "C:\\projects\\trainingNew\\training\\OnlinerProject\\src\\test\\resources\\firefox\\firepath.xpi";
    private final static String GECKO_BASE_NAME = "webdriver.gecko.driver";
    protected static final String TITLE = "%s купить в Минске";

    protected static WebDriver driver;
    protected static FirefoxProfile profile;

    @BeforeClass
    public static void initDriver() {
        System.setProperty(GECKO_BASE_NAME, GECKO_BASE_PATH);

        profile = new FirefoxProfile();

        File firebugFile = new File(FIREBUG_BASE_PATH);
        File firepathFile = new File(FIREBPATH_BASE_PATH);
        profile.addExtension(firebugFile);
        profile.addExtension(firepathFile);
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(dc);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

//    @AfterClass
//    public static void quitDriver() {
//        driver.quit();
//    }

}
