package com.lidiabazhenova.testcase1;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TVPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TVPageTest extends AbstractSeleniumTest {
    
    private static final String NAME = "Телевизор";

    private TVPage tvPage;

    @Before
    public void setTvPage() {
        driver.get("https://catalog.onliner.by/tv");
        tvPage = new TVPage(driver);
    }

    @Test
    public void tvPageOpenTest() {
        Assert.assertEquals(String.format(TITLE, NAME), driver.getTitle());
    }

    @Test
    public void tvPageQuestionMarkFieldHeaderTest() {
        tvPage.clickQuestionMark();
        Assert.assertEquals("Диагональ", tvPage.getQuestionMarkFieldHeader());
    }

    @Test
    public void tvPageQuestionMarkFieldHeaderStyleTest() {
        tvPage.clickQuestionMark();

        Assert.assertEquals("700", tvPage.getQuestionMarkFieldHeaderStyle());
    }

    @Test
    public void tvPageQuestionMarkFieldTextTest() {
        tvPage.clickQuestionMark();

        Assert.assertEquals("Размер диагонали экрана в дюймах. Минимальный комфортный размер зависит " +
                "от расстояния между экраном и зрителем, поскольку необходимо, чтобы изображение занимало " +
                "определенный процент поля зрения.", tvPage.getQuestionMarkFieldText());
    }

    @Test
    public void tvPageQuestionMarkFieldTextStyleTest() {
        tvPage.clickQuestionMark();

        Assert.assertEquals("400", tvPage.getQuestionMarkFieldTextStyle());
    }

}
