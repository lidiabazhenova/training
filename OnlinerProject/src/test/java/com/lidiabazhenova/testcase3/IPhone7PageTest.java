package com.lidiabazhenova.testcase3;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.IPhone7Page;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IPhone7PageTest extends AbstractSeleniumTest{

    private static final String URL = "https://catalog.onliner.by/mobile/apple/iphone732";
    private static final String SCRIPT = "arguments[0].scrollIntoView(true);";
    private static final String TITLE = "Купить Apple iPhone 7 в Минске";

    private static IPhone7Page iPhone7Page;
    private WebElement fieldButteries;

    @Before
    public void setIPhone7Page() {
        driver.get(URL);
        iPhone7Page = new IPhone7Page(driver);
    }

    @Test
    public void iPhone7PageTest() {
        Assert.assertEquals(TITLE, driver.getTitle());

        scroll();

        Assert.assertEquals("Аккумулятор и время работы", fieldButteries.getText());

        Assert.assertEquals("Тип аккумулятора", iPhone7Page.getTypeButtery().getText());

        Assert.assertEquals("Li-ion", iPhone7Page.getDescriptionType().getText());

        Assert.assertEquals("Ёмкость аккумулятора", iPhone7Page.getCapacity().getText());

        Assert.assertEquals("1 960 мА·ч", iPhone7Page.getValueCapacity().getText());

        Assert.assertEquals("Время разговора", iPhone7Page.getTalkTimeButtery().getText());

        Assert.assertEquals("14 часов", iPhone7Page.getValueTalkTimeButtery().getText());

        Assert.assertEquals("Время ожидания", iPhone7Page.getWaitTime().getText());

        Assert.assertEquals("1 неделя, 3 суток", iPhone7Page.getDescriptionWaitTime().getText());
    }

    private void scroll() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        fieldButteries = iPhone7Page.getFieldButteries();
        je.executeScript(SCRIPT, fieldButteries);
    }
}
