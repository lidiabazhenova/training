package com.lidiabazhenova.testcase1;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.TVPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TVPageTest extends AbstractSeleniumTest {
    private TVPage tvPage;

    @Before
    public void setUp() {
        driver.get("https://catalog.onliner.by/tv");
        tvPage = new TVPage(driver);
    }

    @Test
    public void tvPageOpenTest() {
        String heading = tvPage.getHeadingText();

        Assert.assertEquals("Телевизоры", heading);
    }

    @Test
    public void tvPageQuestionMarkFieldHeaderTest() {
        tvPage.clickQuestionMark();
        String text = tvPage.getQuestionMarkFieldHeader();
        Assert.assertEquals("Диагональ", text);
    }

    @Test
    public void tvPageQuestionMarkFieldHeaderStyleTest() {
        tvPage.clickQuestionMark();
        String text = tvPage.getQuestionMarkFieldHeaderStyle();
        Assert.assertEquals("700", text);
    }

    @Test
    public void tvPageQuestionMarkFieldTextTest() {
        tvPage.clickQuestionMark();
        String text = tvPage.getQuestionMarkFieldText();
        Assert.assertEquals("Размер диагонали экрана в дюймах. Минимальный комфортный размер зависит " +
                "от расстояния между экраном и зрителем, поскольку необходимо, чтобы изображение занимало " +
                "определенный процент поля зрения.", text);
    }

    @Test
    public void tvPageQuestionMarkFieldTextStyleTest() {
        tvPage.clickQuestionMark();
        String text = tvPage.getQuestionMarkFieldTextStyle();
        Assert.assertEquals("400", text);
    }

}
