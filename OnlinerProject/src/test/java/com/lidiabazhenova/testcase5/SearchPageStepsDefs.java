package com.lidiabazhenova.testcase5;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.MainPage;
import com.lidiabazhenova.pageObjects.SearchPage;
import com.lidiabazhenova.util.WebElementExtender;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageStepsDefs{
    private static final String PRODUCTS_LOADING_INDICATOR_SELECTOR = ".schema-products_processing";

    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private String firstProductTitle;
    private String secondProductTitle;
    private String firstProductPrice;
    private String secondProductPrice;

    @Before
    public void initWebDriver() throws Exception {
        driver = WebDriverFactory.getInstance();
    }

    @Given("Open https:\\/\\/catalog.onliner.by")
    public void openCatalogueOnliner() throws Exception {
        driver.get("https://catalog.onliner.by");
        mainPage = new MainPage(driver);
    }

    @When("User search {string}")
    public void clickOnAllProducersCheckbox(final String searchText) {
        searchPage = mainPage.search(searchText);
    }

    @Then("Search page opens")
    public void producersPopupOpens() {
        //
    }

    @When("User click on any two phones and go to compare results")
    public void clickOnAnyTwoPhones() {
        final List<WebElement> checkboxesHTS = searchPage.getCheckboxes();
        WebElementExtender.waitForInvisibilityOfElement(driver, By.cssSelector(PRODUCTS_LOADING_INDICATOR_SELECTOR));
        getPhonesInfo();
        WebElementExtender.click(driver, checkboxesHTS.get(0));
        WebElementExtender.click(driver, checkboxesHTS.get(1));
        WebElementExtender.click(driver, searchPage.getToCompareButton());
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

    @After
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}
