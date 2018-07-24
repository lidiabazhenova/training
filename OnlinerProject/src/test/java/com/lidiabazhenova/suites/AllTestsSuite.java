package com.lidiabazhenova.suites;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.testcase1.TVPageTest;
import com.lidiabazhenova.testcase2.MobilePageTest;
import com.lidiabazhenova.testcase3.IPhone7PageTest;
import com.lidiabazhenova.testcase4.TabletPCPageTest;
import com.lidiabazhenova.testcase5.SearchPageTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({TVPageTest.class, MobilePageTest.class, IPhone7PageTest.class, TabletPCPageTest.class,
        SearchPageTest.class})
public class AllTestsSuite {

    @BeforeClass
    public static void doYourOneTimeSetup() throws Exception {
        WebDriverFactory.getInstance();
    }

    @AfterClass
    public static void doYourOneTimeTeardown() throws Exception {
        WebDriverFactory.getInstance().quit();
    }

}