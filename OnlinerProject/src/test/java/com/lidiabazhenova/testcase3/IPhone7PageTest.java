package com.lidiabazhenova.testcase3;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.IPhone7Page;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IPhone7PageTest extends AbstractSeleniumTest {

    private static final String URL = "https://catalog.onliner.by/mobile/apple/iphone732";
    private static final String SCRIPT = "arguments[0].scrollIntoView(true);";
    private static final String TITLE = "Купить Apple iPhone 7 в Минске";

    private static IPhone7Page iPhone7Page;

    @BeforeClass
    public static void setIPhone7Page() {
        driver.get(URL);
        iPhone7Page = new IPhone7Page(driver);
    }

    @Test
    public void pageOpenTest() {
        Assert.assertEquals(TITLE, driver.getTitle());
    }

    @Test
    public void iPhone7ButteryScrollTest() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = iPhone7Page.getFieldButterys();
        je.executeScript(SCRIPT, element);

        Assert.assertEquals("Аккумулятор и время работы", element.getText());

    }

    @Test
    public void butteryTypeTest() {
        Assert.assertEquals("Тип аккумулятора", iPhone7Page.getTypeButtery().getText());
    }

    @Test
    public void butteryTypeDescriptionTest() {
        Assert.assertEquals("Li-ion", iPhone7Page.getDescriptionType().getText());
    }

    @Test
    public void butteryCapacityTest() {
        Assert.assertEquals("Ёмкость аккумулятора", iPhone7Page.getCapacity().getText());
    }

    @Test
    public void butteryCapacityDescription() {
        Assert.assertEquals("1 960 мА·ч", iPhone7Page.getValueCapacity().getText());
    }

    @Test
    public void butteryTalkTimeTest() {
        Assert.assertEquals("Время разговора", iPhone7Page.getTalkTimeButtery().getText());
    }

    @Test
    public void butteryTalkTimeDescriptionTest() {
        Assert.assertEquals("14 часов", iPhone7Page.getValueTalkTimeButtery().getText());
    }

    @Test
    public void butteryWaitTimeTest() {
        Assert.assertEquals("Время ожидания", iPhone7Page.getWaitTime().getText());
    }

    @Test
    public void butteryWaitTimeDescriptionTest() {
        Assert.assertEquals("1 неделя, 3 суток", iPhone7Page.getDescriptionWaitTime().getText());
    }
}
