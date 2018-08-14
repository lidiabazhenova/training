package com.lidiabazhenova.testcase5;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.factory.WebDriverFactory;
import com.lidiabazhenova.pageObjects.ComparePage;
import com.lidiabazhenova.pageObjects.MainPage;
import com.lidiabazhenova.pageObjects.SearchPage;
import com.lidiabazhenova.util.WebElementExtender;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageTest extends AbstractSeleniumTest{

    private static final String TITLE = "Каталог Onliner.by";

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setSearchPage() throws Exception {
        driver = WebDriverFactory.getInstance();
        driver.get("https://catalog.onliner.by");
        mainPage = new MainPage(driver);
    }

    @Test
    public void searchPageTest() {
        Assert.assertEquals(TITLE, driver.getTitle());

        final SearchPage searchPage = mainPage.search("HTC");
        final List<WebElement> checkboxesHTS = searchPage.getCheckboxes();

        final String firstProductTitle = searchPage.getTitles().get(0).getText();
        final String secondProductTitle = searchPage.getTitles().get(1).getText();
        final String firstProductPrice = StringUtils.removeEnd(searchPage.getPrices().get(0).getText(), " р.");
        final String secondProductPrice = StringUtils.removeEnd(searchPage.getPrices().get(1).getText(), " р.");

        WebElementExtender.click(driver, checkboxesHTS.get(0));
        WebElementExtender.click(driver, checkboxesHTS.get(1));
        WebElementExtender.click(driver, searchPage.getToCompareButton());

        Assert.assertEquals(firstProductTitle, searchPage.getComparePage().getItemsToCompareCaption().get(0).getText());
        Assert.assertEquals(secondProductTitle, searchPage.getComparePage().getItemsToCompareCaption().get(1).getText());

        Assert.assertTrue(searchPage.getComparePage().getItemsToComparePrice().get(0).getText()
                .startsWith(firstProductPrice));
        Assert.assertTrue(searchPage.getComparePage().getItemsToComparePrice().get(1).getText()
                .startsWith(secondProductPrice));
    }
}