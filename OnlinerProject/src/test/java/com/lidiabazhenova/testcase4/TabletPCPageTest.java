package com.lidiabazhenova.testcase4;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TabletPCPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TabletPCPageTest extends AbstractSeleniumTest {

    private static final String URL = "https://catalog.onliner.by/tabletpc";
    private static final String NAME = "Планшет";

    private static final ArrayList<String> producers = new ArrayList<>(Arrays.asList(
            "Ritmix", "Philips", "Prestigio", "Xiaomi", "Sony", "TELEFUNKEN", "Tesla", "TeXet", "Toshiba", "Евросеть"));

    private static TabletPCPage tabletPCPage;

    @BeforeClass
    public static void setTabletPCPage() throws Exception {
        driver.get(URL);
        tabletPCPage = new TabletPCPage(driver);
    }

    @Test
    public void firstProducersTest() {
        Assert.assertEquals(String.format(TITLE, NAME), driver.getTitle());
    }

    @Test
    public void secondSelectAllProducersTest() {
        tabletPCPage.getAllProducerList().click();

        producers.forEach((producerName) -> {
            if (!driver.findElement(By.xpath(tabletPCPage.getProducer(producerName))).isSelected()) {

                driver.findElement(By.xpath(tabletPCPage.getProducer(producerName))).click();
                Assert.assertTrue(driver.findElement(By.xpath(tabletPCPage.checkProducer(producerName))).isSelected());
            }
        });
    }
}
