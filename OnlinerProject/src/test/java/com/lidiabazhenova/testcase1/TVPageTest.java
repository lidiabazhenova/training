package com.lidiabazhenova.testcase1;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TVPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TVPageTest extends AbstractSeleniumTest {

    private static final String NAME = "Телевизор";

    private TVPage tvPage;

    @Before
    public void setTvPage() {
        driver.get("https://catalog.onliner.by/tv");
        tvPage = new TVPage(driver);
    }

    @Test
    public void tvPageTest() {

        Assert.assertEquals(String.format(TITLE, NAME), driver.getTitle());

        tvPage.clickQuestionMark();

        Assert.assertEquals("Диагональ", tvPage.getQuestionMarkFieldHeader());

        tvPage.clickQuestionMark();

        Assert.assertEquals("700", tvPage.getQuestionMarkFieldHeaderStyle());

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[./span[contains(text()," +
                "'Диагональ')]]/preceding-sibling::div/div[@class=\"schema-filter-help__trigger\"]")));
        tvPage.clickQuestionMark();

        Assert.assertEquals("Размер диагонали экрана в дюймах. Минимальный комфортный размер зависит " +
                "от расстояния между экраном и зрителем, поскольку необходимо, чтобы изображение занимало " +
                "определенный процент поля зрения.", tvPage.getQuestionMarkFieldText());

        tvPage.clickQuestionMark();

        Assert.assertEquals("400", tvPage.getQuestionMarkFieldTextStyle());
    }
}
