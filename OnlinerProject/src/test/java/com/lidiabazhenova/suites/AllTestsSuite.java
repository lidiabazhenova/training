package com.lidiabazhenova.suites;

import com.lidiabazhenova.testcase1.TvCategoryStepDefs;
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
@Suite.SuiteClasses({TvCategoryStepDefs.class, MobilePageTest.class, IPhone7PageTest.class, TabletPCPageTest.class,
        SearchPageTest.class})
public class AllTestsSuite {

    @BeforeClass
    public static void setUp() throws Exception {
        Log.startLog("AllTestsSuite");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Log.endLog("AllTestsSuite");
    }
}