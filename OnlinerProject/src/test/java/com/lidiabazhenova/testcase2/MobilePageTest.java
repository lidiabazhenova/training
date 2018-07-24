package com.lidiabazhenova.testcase2;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.MobilePage;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MobilePageTest extends AbstractSeleniumTest{

    private static final String NAME = "Мобильный телефон";

    private MobilePage mobilePage;

    @Before
    public void setMobilePage() {
        driver.get("https://catalog.onliner.by/mobile");
        mobilePage = new MobilePage(driver);
    }

    @Test
    public void mobilePageTest() {

        Assert.assertEquals(String.format(TITLE, NAME), driver.getTitle());

        Assert.assertEquals(mobilePage.getPhoneCount(), 30);

        Assert.assertEquals(30, mobilePage.getHeadingsAllElements().size());

        mobilePage.getHeadingsAllElements().forEach((headingField) -> {

            Assert.assertTrue(StringUtils.isNotBlank(headingField.getText()));
        });

        Assert.assertEquals(30, mobilePage.getDescriptionAllElements().size());

        mobilePage.getHeadingsAllElements().forEach((descriptionField) -> {

            Assert.assertTrue(StringUtils.isNotBlank(descriptionField.getText()));
        });

        Assert.assertEquals(30, mobilePage.getPriceAllElements().size());

        mobilePage.getHeadingsAllElements().forEach((priceField) -> {

            Assert.assertTrue(StringUtils.isNotBlank(priceField.getText()));
        });

        mobilePage.getPriceAllElements().forEach((priceField) -> {
            String price = StringUtils.removeEnd(priceField.getText(), " р.");
            String regex = "^[0-9]+,[0-9]{2}$";

            Assert.assertTrue(price.matches(regex));
        });
    }
}

