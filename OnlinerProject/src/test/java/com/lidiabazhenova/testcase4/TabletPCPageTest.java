package com.lidiabazhenova.testcase4;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TabletPCPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TabletPCPageTest extends AbstractSeleniumTest {

    private static final String URL = "https://catalog.onliner.by/tabletpc";
    private static final String NAME = "Планшет";

    private static final ArrayList<String> producers = new ArrayList<>(Arrays.asList(
            "Xiaomi", "Ritmix", "Philips", "Prestigio", "Sony", "TELEFUNKEN", "Tesla", "TeXet", "Toshiba", "Евросеть"));

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

    @Test
    public void thirdSelectAllProducersTest() {
        final List<String> listTablePC = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        tabletPCPage.getResultTablePC().forEach((tabletPC) -> {
            String name = tabletPC.getText();
            listTablePC.add(name);
        });

        do {
            driver.findElement(By.xpath("//*[@id='schema-pagination']/a/span")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".schema-products_processing")));

            tabletPCPage.getResultTablePC().forEach((tabletPC) -> {
                String name = tabletPC.getText();
                listTablePC.add(name);
            });
        }
        while (driver.findElement(By.xpath("//*[@id='schema-pagination']/a/span")).getText().startsWith("Следующие"));

        driver.findElement(By.xpath("//*[@id='schema-pagination']/a/span")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".schema-products_processing")));

        tabletPCPage.getResultTablePC().forEach((tabletPC) -> {
            String name = tabletPC.getText();
            listTablePC.add(name);
        });

        Assert.assertTrue(compareTwoList(producers, listTablePC));
        System.out.println(listTablePC.size());
    }


    public boolean compareTwoList(List<String> listProducers, List<String> listTablePC) {

        for (String title : listTablePC) {
            boolean found = false;
            for (String producerName : listProducers) {
                if (title.startsWith(producerName)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
