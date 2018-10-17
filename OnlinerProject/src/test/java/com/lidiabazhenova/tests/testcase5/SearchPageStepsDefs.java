package com.lidiabazhenova.tests.testcase5;

import com.lidiabazhenova.framework.factory.WebDriverFactory;
import com.lidiabazhenova.tests.pageObjects.MainPage;
import com.lidiabazhenova.tests.pageObjects.SearchPage;
import com.lidiabazhenova.framework.util.WebElementExtender;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageStepsDefs{
    private static final String PRODUCTS_LOADING_INDICATOR_SELECTOR = ".schema-products_processing";

    private MainPage mainPage;
    private SearchPage searchPage;
    private String firstProductTitle;
    private String secondProductTitle;
    private String firstProductPrice;
    private String secondProductPrice;

    @Given("Open https:\\/\\/catalog.onliner.by")
    public void openCatalogueOnliner() throws Exception {
        WebDriverFactory.getInstance().get("https://catalog.onliner.by");
        mainPage = new MainPage(WebDriverFactory.getInstance());
    }

    @When("User search {string}")
    public void clickOnAllProducersCheckbox(final String searchText) {
        searchPage = mainPage.search(searchText);
    }

    @Then("Search page opens")
    public void producersPopupOpens() {
        searchPage.getSearchForm().isDisplayed();
    }

    @When("User click on any two phones and go to compare results")
    public void clickOnAnyTwoPhones() throws Exception {
        final List<WebElement> checkboxesHTS = searchPage.getCheckboxes();
        WebElementExtender.waitForInvisibilityOfElement(WebDriverFactory.getInstance(), By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
        getPhonesInfo();
        WebElementExtender.click(WebDriverFactory.getInstance(), checkboxesHTS.get(0));
        WebElementExtender.click(WebDriverFactory.getInstance(), checkboxesHTS.get(1));
        WebElementExtender.click(WebDriverFactory.getInstance(), searchPage.getToCompareButton());
    }

    @Then("Check the description of first phone are displayed on compare results")
    public void checkDisplayedFirstPhoneDesctiption() {
        Assert.assertEquals(firstProductTitle, searchPage.getComparePage().getItemsToCompareCaption().get(0).getText());
    }

    @And("Check the description of second phone are displayed on compare results")
    public void checkDisplayedSecondPhoneDesctiption() {
        Assert.assertEquals(secondProductTitle, searchPage.getComparePage().getItemsToCompareCaption().get(1).getText());
    }

    @And("Check the price of first phone are displayed on compare results")
    public void checkDisplayedFirstPhonePrice() {
        Assert.assertTrue(searchPage.getComparePage().getItemsToComparePrice().get(0).getText()
                .startsWith(firstProductPrice));
    }

    @And("Check the price of second phone are displayed on compare results")
    public void checkDisplayedSecondPhonePrice() {
        Assert.assertTrue(searchPage.getComparePage().getItemsToComparePrice().get(1).getText()
                .startsWith(secondProductPrice));
    }

    private void getPhonesInfo(){
        firstProductTitle = searchPage.getTitles().get(0).getText();
        secondProductTitle = searchPage.getTitles().get(1).getText();
        firstProductPrice = StringUtils.removeEnd(searchPage.getPrices().get(0).getText(), " р.");
        secondProductPrice = StringUtils.removeEnd(searchPage.getPrices().get(1).getText(), " р.");
    }
}
