package com.lidiabazhenova.testcase3;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.IPhone7Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IPhone7PageTest extends AbstractSeleniumTest {

    private static final String URL = "https://catalog.onliner.by/mobile/apple/iphone732";
    public static final String SCRIPT = "arguments[0].scrollIntoView(true);";

    private static IPhone7Page iPhone7Page;

    @BeforeClass
    public static void setIPhone7Page() {
        driver.get(URL);
        iPhone7Page = new IPhone7Page(driver);
    }

    @Test
    public void iPhone7PageOpen() {
        String currentUrlURL = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlURL, URL);
    }

    @Test
    public void iPhone7AccumulatorScroll() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = iPhone7Page.getDescriptionHeadingAccumulator();
        je.executeScript(SCRIPT,element);

        Assert.assertEquals("Аккумулятор и время работы", element.getText());

    }

    @Test
    public void iPhone7AccumulatorType() {
        Assert.assertEquals("Тип аккумулятора", iPhone7Page.getTypeAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorTypeDescription() {
        Assert.assertEquals("Li-ion", iPhone7Page.getDescriptionTypeAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorCapacity() {
        Assert.assertEquals("Ёмкость аккумулятора", iPhone7Page.getCapacityAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorCapacityDescription() {
        Assert.assertEquals("1 960 мА·ч", iPhone7Page.getDescriptionCapacityAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorTalkTime() {
        Assert.assertEquals("Время разговора", iPhone7Page.getTalkTimeAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorTalkTimeDescription() {
        Assert.assertEquals("14 часов", iPhone7Page.getDescriptionTalkTimeAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorWaitTime() {
        Assert.assertEquals("Время ожидания", iPhone7Page.getWaitTimeAccumulator().getText());
    }

    @Test
    public void iPhone7AccumulatorWaitTimeDescription() {
        Assert.assertEquals("1 неделя, 3 суток", iPhone7Page.getDescriptionWaitTimeAccumulator().getText());
    }
}
