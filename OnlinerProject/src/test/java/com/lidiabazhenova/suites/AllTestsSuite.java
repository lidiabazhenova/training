package com.lidiabazhenova.suites;

import com.lidiabazhenova.testcase1.TvCategoryStepDefs;
import com.lidiabazhenova.testcase3.DetailedPageStepDefs;
import com.lidiabazhenova.testcase4.TabletPCCategoryStepDefs;
import com.lidiabazhenova.testcase5.SearchPageStepsDefs;
import com.lidiabazhenova.util.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({TvCategoryStepDefs.class, DetailedPageStepDefs.class, TabletPCCategoryStepDefs.class,
        SearchPageStepsDefs.class})
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