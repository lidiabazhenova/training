package com.lidiabazhenova.testcase4;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.TabletPCPage;
import com.lidiabazhenova.util.WebElementExtender;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabletPCCategoryStepDefs {

    private static final String PRODUCTS_LOADING_INDICATOR_SELECTOR = ".schema-products_processing";
    private static final String START_NAME = "Следующие";

    private WebDriver driver;
    private TabletPCPage tabletPCPage;

    @Before
    public void initWebDriver() throws Exception {
        driver = WebDriverFactory.getInstance();
    }

    @Given("Open https:\\/\\/catalog.onliner.by\\/tabletpc")
    public void openTablePCCategoryPage() throws Exception {
        driver.get("https://catalog.onliner.by/tabletpc");
        tabletPCPage = new TabletPCPage(driver);
    }

    @When("User clicks on \"Все 62 варианта\" in filter \"Производитель\"")
    public void clickOnAllProducersCheckbox() {
        tabletPCPage.clickAllProducersFilter();
    }

    @Then("Popup opens")
    public void producersPopupOpens() {
        Assert.assertTrue(tabletPCPage.getAllProducersPopup().isDisplayed());
    }

    @When("Click on producers: {string} in popup")
    public void clickAllProducers(final String producersString) {
        splitProducersFromString(producersString).forEach((producerName) -> {
            WebElement producerElement = tabletPCPage.getProducerInCheckbox(producerName);
            if (!producerElement.isSelected()) {
                WebElementExtender.click(driver, producerElement);
            }
        });
        WebElementExtender.waitForInvisibilityOfElement(driver, By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
    }

    @Then("Check all producers {string} are clicked in filter \"Производитель\"")
    public void checkAllProducersClickedInFilter(final String producerNames) {
        Assert.assertTrue(compareTwoList(splitProducersFromString(producerNames), getProducersAreClicked(producerNames)));
    }

    @And("Check all producers {string} are clicked in search results")
    public void checkAllProducersClickedInSearchResults(final String producerNames) {
        Assert.assertTrue(compareTwoList(splitProducersFromString(producerNames), getSearchResults()));
    }

    private List<String> splitProducersFromString(final String producerNames) {
        final List<String> producersList = new ArrayList<>(Arrays.asList(producerNames.split(",")));

        return producersList;
    }

    private List<String> getProducersAreClicked(final String producerNames) {
        final List<String> listProducersAreClicked = new ArrayList<>();
        clickFilterAndWait();
        splitProducersFromString(producerNames).forEach((producerName) -> {
            WebElement producerElement = tabletPCPage.getProducerInCheckbox(producerName);
            if (!producerElement.isSelected()) {
                listProducersAreClicked.add(producerName);
            }
        });
        return listProducersAreClicked;
    }

    private List<String> getSearchResults() {
        final List<String> listTabletPC = new ArrayList<>();
        listTabletPC.addAll(tabletPCPage.getTabletPCNameList());

        do {
            clickNextPageAndWait();
            listTabletPC.addAll(tabletPCPage.getTabletPCNameList());
        } while (tabletPCPage.getPagination().getText().startsWith(START_NAME));

        clickNextPageAndWait();
        listTabletPC.addAll(tabletPCPage.getTabletPCNameList());

        return listTabletPC;
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

    private void clickFilterAndWait() {
        WebElementExtender.click(driver, tabletPCPage.getAllProducersFilter());
        WebElementExtender.waitForInvisibilityOfElement(driver, By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
    }

    @After
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}
