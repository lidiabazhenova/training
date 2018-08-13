package com.lidiabazhenova.suites;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.testcase1.TVPageTest;
import com.lidiabazhenova.testcase2.MobilePageTest;
import com.lidiabazhenova.testcase3.IPhone7PageTest;
import com.lidiabazhenova.testcase4.TabletPCPageTest;
import com.lidiabazhenova.testcase5.SearchPageTest;
import com.lidiabazhenova.util.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({TVPageTest.class, MobilePageTest.class, IPhone7PageTest.class, TabletPCPageTest.class,
        SearchPageTest.class})
public class AllTestsSuite {


    @BeforeClass
    public static void setUp() throws Exception {
        Log.startLog("AllTestsSuite");
        WebDriverFactory.getInstance();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (WebDriverFactory.getInstance() != null) {
            WebDriverFactory.getInstance().quit();
        }
        Log.endLog("AllTestsSuite");
    }
}