package com.lidiabazhenova.testcase3;

import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.IPhone7Page;
import com.lidiabazhenova.util.WebElementExtender;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class IPhone7DetailedPageStepDefs {

    private WebDriver driver;
    private IPhone7Page iPhone7Page;

    @Before
    public void initWebDriver() throws Exception {
        driver = WebDriverFactory.getInstance();
    }

    @Given("Open https:\\/\\/catalog.onliner.by\\/mobile\\/apple\\/iphone732")
    public void openIphone732CategoryPage() throws Exception {
        driver.get("https://catalog.onliner.by/mobile/apple/iphone732");
        iPhone7Page = new IPhone7Page(driver);
    }

    @When("User scroll  to \"Аккумулятор и время работы\"")
    public void scrollToBatteryField() {
        WebElementExtender.scrollToElement(driver, iPhone7Page.getFieldButteries());
    }

    @Then("Battery field is displayed")
    public void batteryFieldIsDisplayed() {
        //
    }

    @And("Buttery type equals to \"([^\"]*)\"")
    public void checkTypeButtery(final String text) {
        Assert.assertEquals(text, iPhone7Page.getTypeButtery());
    }

    @And("Capacity equals to \"([^\"]*)\"")
    public void checkCapacity(final String text) {
        Assert.assertEquals(text, iPhone7Page.getCapacity());
    }

    @And("Talking time equals to \"([^\"]*)\"")
    public void checkTalkingTime(final String text) {
        Assert.assertEquals(text, iPhone7Page.getTalkingTime());
    }

    @And("Wait time equals to \"([^\"]*)\"")
    public void checkWaitTime(final String text) {
        Assert.assertEquals(text, iPhone7Page.getWaitTime());
    }
}
