package com.lidiabazhenova.testcase1;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.TVPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TvCategoryStepDefs {

    private TVPage tvPage;
    private WebDriver driver;

    @Before
    public void initWebDriver() throws Exception {
        driver = WebDriverFactory.getInstance();
    }

    @Given("Open https:\\/\\/catalog.onliner.by\\/tv")
    public void openTvCategoryPage() throws Exception {
        driver.get("https://catalog.onliner.by/tv");
        tvPage = new TVPage(driver);
    }

    @When("User clicks on question mark near 'Диагональ'")
    public void clickOnDiagonalQuestionMark() {
        tvPage.clickQuestionMark();
    }

    @Then("Diagonal popup opens")
    public void diagonalPopupOpens() {
        //
    }

    @And("Popup header equals to \"([^\"]*)\"")
    public void checkPopupHeader(final String text) {
        Assert.assertEquals(text, tvPage.getQuestionMarkFieldHeader());
    }

    @And("Popup header font weight equals to {int}")
    public void checkPopupHeaderFontWeight(final int fontWeight) {
        Assert.assertEquals(fontWeight, tvPage.getQuestionMarkFieldHeaderFontWeight());
    }

    @And("Popup text equals to \"([^\"]*)\"")
    public void checkPopupText(final String text) {
        Assert.assertEquals(text, tvPage.getQuestionMarkFieldText());
    }

    @And("Popup text font weight equals to {int}")
    public void checkPopupTextFontWeight(final int fontWeight) {
        Assert.assertEquals(fontWeight, tvPage.getQuestionMarkFieldTextFontWeight());
    }

    @After
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}
