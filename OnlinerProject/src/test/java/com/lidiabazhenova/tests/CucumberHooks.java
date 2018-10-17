package com.lidiabazhenova.tests;

import com.lidiabazhenova.framework.factory.WebDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {

    @Before
    public void initWebDriver() throws Exception {
        WebDriverFactory.getInstance();
    }

    @After
    public void quitWebDriver() throws Exception {
        WebDriverFactory.quit();
    }
}
