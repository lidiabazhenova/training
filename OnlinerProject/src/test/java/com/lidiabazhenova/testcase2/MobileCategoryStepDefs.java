package com.lidiabazhenova.testcase2;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.MobilePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MobileCategoryStepDefs {

    private MobilePage mobilePage;
    private WebDriver driver;

    @Before
    public void initWebDriver() throws Exception {
        driver = WebDriverFactory.getInstance();
    }

    @Given("Open https:\\/\\/catalog.onliner.by\\/mobile")
    public void openMobileCategoryPage() throws Exception {
        driver.get("https://catalog.onliner.by/mobile");
        mobilePage = new MobilePage(driver);
    }

    @Then("Mobiles count on page is equals to {int}")
    public void checkMobileCountOnPage(final int countMobiles) {
        Assert.assertEquals(countMobiles, CollectionUtils.size(mobilePage.getAllPhones()));
    }

    @Then("Mobile headings count on page is equals to {int}")
    public void checkMobileHeadingsCountOnPage(final int countHeadings) {
        Assert.assertEquals(countHeadings, CollectionUtils.size(mobilePage.getHeadingsAllPhones()));
    }

    @Then("All mobiles have not null headings")
    public void checkMobileHeadingsNotNull() {
        mobilePage.getHeadingsAllPhones().forEach((headingField) -> {
            Assert.assertTrue(StringUtils.isNotBlank(headingField.getText()));
        });
    }

    @Then("Mobile descriptions count on page is equals to {int}")
    public void checkMobileDescriptionsCountOnPage(final int countDescriptions) {
        Assert.assertEquals(countDescriptions, CollectionUtils.size(mobilePage.getDescriptionsAllPhones()));
    }

    @Then("All mobiles have not null description")
    public void checkMobileDescriptionsNotNull() {
        mobilePage.getDescriptionsAllPhones().forEach((descriptionField) -> {
            Assert.assertTrue(StringUtils.isNotBlank(descriptionField.getText()));
        });
    }

    @Then("Mobile prices count on page is equals to {int}")
    public void checkMobilePricesCountOnPage(final int countPrices) {
        Assert.assertEquals(countPrices, CollectionUtils.size(mobilePage.getPricesAllPhones())
                + CollectionUtils.size(mobilePage.getProductStatus()));
    }

    @Then("All mobiles have prices format equals to {string}")
    public void checkMobilePricesFormatMatch(String regex) {
        mobilePage.getPricesAllPhones().forEach((priceField) -> {
            String price = StringUtils.removeEnd(priceField.getText(), " р.");
            Assert.assertTrue(price.matches(regex));
        });
    }

    @After
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
        }
    }
}

