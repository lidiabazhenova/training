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
    private final static String ADD_ON_BASE_PATH =
            "C:\\projects\\trainingNew\\training\\OnlinerProject\\src\\test\\resources\\firefox\\firebug-1.9.2.xpi";
    private final static String GECKO_BASE_NAME = "webdriver.gecko.driver";
    protected static final String TITLE = "%s купить в Минске";

    protected static WebDriver driver;
    protected static FirefoxProfile profile;

    @BeforeClass
    public static void initDriver() {
        System.setProperty(GECKO_BASE_NAME, GECKO_BASE_PATH);

        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(false);
        profile.setAssumeUntrustedCertificateIssuer(true);
        File addonpath = new File(ADD_ON_BASE_PATH);
        profile.addExtension(addonpath);
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(dc);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
