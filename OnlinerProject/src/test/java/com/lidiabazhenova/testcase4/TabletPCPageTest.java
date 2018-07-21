package com.lidiabazhenova.testcase4;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TabletPCPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabletPCPageTest extends AbstractSeleniumTest {

    private static final String URL = "https://catalog.onliner.by/tabletpc";
    private static final String NAME = "Планшет";
    private static final String START_NAME = "Следующие";
    By productsLoadingIndicator = By.cssSelector(".schema-products_processing");

    private static final ArrayList<String> producers = new ArrayList<>(Arrays.asList(
            "Xiaomi", "Ritmix", "Philips", "Prestigio", "Sony", "TELEFUNKEN", "Tesla", "TeXet", "Toshiba", "Евросеть"));

    private static List<String> listTablePC;
    private static WebDriverWait wait;

    private static TabletPCPage tabletPCPage;

    @BeforeClass
    public static void setTabletPCPage() throws Exception {
        driver.get(URL);
        tabletPCPage = new TabletPCPage(driver);
        listTablePC = new ArrayList<>();
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void tabletPCPageTest() {

        Assert.assertEquals(String.format(TITLE, NAME), driver.getTitle());
        tabletPCPage.getAllProducerList().click();

        producers.forEach((producerName) -> {
            if (!driver.findElement(By.xpath(tabletPCPage.getProducer(producerName))).isSelected()) {
                driver.findElement(By.xpath(tabletPCPage.getProducer(producerName))).click();

                Assert.assertTrue(driver.findElement(By.xpath(tabletPCPage.checkProducer(producerName))).isSelected());
            }
        });

        addProducersToList();

        do {
            clickNextPageAndWait();
            addProducersToList();
        }
        while (tabletPCPage.getPagination().getText().startsWith(START_NAME));

        clickNextPageAndWait();
        addProducersToList();

        Assert.assertTrue(compareTwoList(producers, listTablePC));
        System.out.println(listTablePC.size());
    }

    private List<String> addProducersToList() {
        tabletPCPage.getResultTablePC().forEach((tabletPC) -> {
            listTablePC.add(tabletPC.getText());
        });

        return listTablePC;
    }


    private boolean compareTwoList(List<String> listProducers, List<String> listTablePC) {

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

    private void clickNextPageAndWait() {
        tabletPCPage.getPagination().click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(productsLoadingIndicator));
    }
}
