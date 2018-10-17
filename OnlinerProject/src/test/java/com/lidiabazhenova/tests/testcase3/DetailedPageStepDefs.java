package com.lidiabazhenova.tests.testcase3;

import com.lidiabazhenova.framework.factory.WebDriverFactory;
import com.lidiabazhenova.tests.pageObjects.IPhone7Page;
import com.lidiabazhenova.framework.util.WebElementExtender;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DetailedPageStepDefs {

    private IPhone7Page iPhone7Page;

    @Given("Open https:\\/\\/catalog.onliner.by\\/mobile\\/apple\\/iphone732")
    public void openIphone732CategoryPage() throws Exception {
        WebDriverFactory.getInstance().get("https://catalog.onliner.by/mobile/apple/iphone732");
        iPhone7Page = new IPhone7Page(WebDriverFactory.getInstance());
    }

    @When("User scroll  to \"Аккумулятор и время работы\"")
    public void scrollToBatteryField() throws Exception {
        WebElementExtender.scrollToElement(WebDriverFactory.getInstance(), iPhone7Page.getFieldButteries());
    }

    @Then("Buttery type equals to \"([^\"]*)\"")
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
