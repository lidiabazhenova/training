package com.lidiabazhenova.tests.testcase1;

import com.lidiabazhenova.framework.factory.WebDriverFactory;
import com.lidiabazhenova.tests.pageObjects.TvPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TvCategoryStepDefs {

    private TvPage tvPage;

    @Given("Open https:\\/\\/catalog.onliner.by\\/tv")
    public void openTvCategoryPage() throws Exception {
        WebDriverFactory.getInstance().get("https://catalog.onliner.by/tv");
        tvPage = new TvPage(WebDriverFactory.getInstance());
    }

    @When("User clicks on question mark near \"Диагональ\"")
    public void clickOnDiagonalQuestionMark() {
        tvPage.clickQuestionMark();
    }

    @Then("Diagonal popup opens")
    public void diagonalPopupOpens() {
        tvPage.getDialogPopup().isDisplayed();
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
}
