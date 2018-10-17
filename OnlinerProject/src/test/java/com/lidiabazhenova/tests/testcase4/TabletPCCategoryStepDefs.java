package com.lidiabazhenova.tests.testcase4;

import com.lidiabazhenova.framework.factory.WebDriverFactory;
import com.lidiabazhenova.tests.pageObjects.TabletPCPage;
import com.lidiabazhenova.framework.util.WebElementExtender;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabletPCCategoryStepDefs {

    private static final String PRODUCTS_LOADING_INDICATOR_SELECTOR = ".schema-products_processing";
    private static final String START_NAME = "Следующие";

    private TabletPCPage tabletPCPage;

    @Given("Open https:\\/\\/catalog.onliner.by\\/tabletpc")
    public void openTablePCCategoryPage() throws Exception {
        WebDriverFactory.getInstance().get("https://catalog.onliner.by/tabletpc");
        tabletPCPage = new TabletPCPage(WebDriverFactory.getInstance());
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
    public void clickAllProducers(final String producersString) throws Exception {
        for (String producerName: splitProducersFromString(producersString)) {
            WebElement producerElement = tabletPCPage.getProducerInCheckbox(producerName);
            if (!producerElement.isSelected()) {
                WebElementExtender.click(WebDriverFactory.getInstance(), producerElement);
            }
        };
        WebElementExtender.waitForInvisibilityOfElement(WebDriverFactory.getInstance(), By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
    }

    @Then("Check all producers {string} are clicked in filter \"Производитель\"")
    public void checkAllProducersClickedInFilter(final String producerNames) throws Exception {
        Assert.assertTrue(compareTwoList(splitProducersFromString(producerNames), getProducersAreClicked(producerNames)));
    }

    @And("Check all producers {string} are clicked in search results")
    public void checkAllProducersClickedInSearchResults(final String producerNames) throws Exception {
        Assert.assertTrue(compareTwoList(splitProducersFromString(producerNames), getSearchResults()));
    }

    private List<String> splitProducersFromString(final String producerNames) {
        final List<String> producersList = new ArrayList<>(Arrays.asList(producerNames.split(",")));

        return producersList;
    }

    private List<String> getProducersAreClicked(final String producerNames) throws Exception {
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

    private List<String> getSearchResults() throws Exception {
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

    private void clickNextPageAndWait() throws Exception {
        WebElementExtender.click(WebDriverFactory.getInstance(), tabletPCPage.getPagination());
        WebElementExtender.waitForInvisibilityOfElement(WebDriverFactory.getInstance(), By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
    }

    private void clickFilterAndWait() throws Exception {
        WebElementExtender.click(WebDriverFactory.getInstance(), tabletPCPage.getAllProducersFilter());
        WebElementExtender.waitForInvisibilityOfElement(WebDriverFactory.getInstance(), By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
    }
}
