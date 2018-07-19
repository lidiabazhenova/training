package com.lidiabazhenova.testcase4;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TabletPCPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TabletPCPageTest extends AbstractSeleniumTest {

    private static TabletPCPage tabletPCPage;
    private static final String URL = "https://catalog.onliner.by/tabletpc";
    private static final String name = "Планшет";

    @BeforeClass
    public static void setTabletPCPage() throws Exception {
        driver.get(URL);
        tabletPCPage = new TabletPCPage(driver);
    }

    @Test
    public void tabletPCPageOpen() {
        Assert.assertEquals(String.format(TITLE, name), driver.getTitle());
    }
}
