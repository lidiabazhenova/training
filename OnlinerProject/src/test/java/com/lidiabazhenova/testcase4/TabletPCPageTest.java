package com.lidiabazhenova.testcase4;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.TabletPCPage;
import com.lidiabazhenova.util.WebElementExtender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabletPCPageTest extends AbstractSeleniumTest {

    private static final String PRODUCTS_LOADING_INDICATOR_SELECTOR = ".schema-products_processing";

    private static final String URL = "https://catalog.onliner.by/tabletpc";
    private static final String NAME = "Планшет";
    private static final String START_NAME = "Следующие";
    private static final ArrayList<String> producers = new ArrayList<>(Arrays.asList(
            "Xiaomi", "Ritmix", "Philips", "Prestigio", "Sony", "TELEFUNKEN", "Tesla", "TeXet", "Toshiba", "Евросеть"));

    private WebDriver driver;
    private TabletPCPage tabletPCPage;

    @Before
    public void setTabletPCPage() throws Exception {
        driver = WebDriverFactory.getInstance();
        driver.get(URL);
        tabletPCPage = new TabletPCPage(driver);
    }

    @Test
    public void tabletPCPageTest() throws Exception {
        assertPageTitle(NAME);

        WebElementExtender.click(driver, tabletPCPage.getAllProducerListCheckbox());

        producers.forEach((producerName) -> {
            WebElement producerElement = tabletPCPage.getProducerCheckbox(producerName);
            if (!producerElement.isSelected()) {
                WebElementExtender.click(driver, producerElement);
            }
        });

        WebElementExtender.waitForInvisibilityOfElement(driver, By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));

        final List<String> listTablePC = new ArrayList<>();
        listTablePC.addAll(addProducersToList());
        do {
            clickNextPageAndWait();
            listTablePC.addAll(addProducersToList());
        } while (tabletPCPage.getPagination().getText().startsWith(START_NAME));
        clickNextPageAndWait();
        listTablePC.addAll(addProducersToList());

        Assert.assertTrue(compareTwoList(producers, listTablePC));
    }

    private List<String> addProducersToList() {
        final List<String> listTablePC = new ArrayList<>();
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
        WebElementExtender.click(driver, tabletPCPage.getPagination());
        WebElementExtender.waitForInvisibilityOfElement(driver, By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
    }
}
