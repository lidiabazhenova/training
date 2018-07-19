package com.lidiabazhenova.testcase2;

import com.lidiabazhenova.AbstractSeleniumTest;
import com.lidiabazhenova.pageObjects.MobilePage;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MobilePageTest extends AbstractSeleniumTest {
    private MobilePage mobilePage;
    private static final String name = "Мобильный телефон";

    @Before
    public void setMobilePage() {
        driver.get("https://catalog.onliner.by/mobile");
        mobilePage = new MobilePage(driver);

    }

    @Test
    public void mobilePageOpenTest() {
        Assert.assertEquals(String.format(TITLE, name), driver.getTitle());
    }

    @Test
    public void mobilePageCountAllElementsTest() {
        Assert.assertEquals(mobilePage.getPhoneCount(), 30);
    }


    @Test
    public void mobilePageAllElementsPresentPhoneHeading() {
        Assert.assertEquals(30, mobilePage.getHeadingsAllElements().size());
    }

    @Test
    public void mobilePageAllElementsNotBlankHeading() {

        mobilePage.getHeadingsAllElements().forEach((headingField) -> {

            Assert.assertTrue(StringUtils.isNotBlank(headingField.getText()));
        });
    }

    @Test
    public void mobilePageAllElementsPresentPhoneDescription() {
        Assert.assertEquals(30, mobilePage.getDescriptionAllElements().size());
    }

    @Test
    public void mobilePageAllElementsNotBlankDescription() {

        mobilePage.getHeadingsAllElements().forEach((descriptionField) -> {

            Assert.assertTrue(StringUtils.isNotBlank(descriptionField.getText()));
        });
    }

    @Test
    public void mobilePageAllElementsPresentPhonePrice() {
        Assert.assertEquals(30, mobilePage.getPriceAllElements().size());
    }

    @Test
    public void mobilePageAllElementsNotBlankPrice() {

        mobilePage.getHeadingsAllElements().forEach((priceField) -> {

            Assert.assertTrue(StringUtils.isNotBlank(priceField.getText()));
        });
    }

    @Test
    public void mobilePageAllElementsFormatPrice() {

        mobilePage.getPriceAllElements().forEach((priceField) -> {
            String price = StringUtils.removeEnd(priceField.getText(), " р.");
            String regex = "^[0-9]+,[0-9]{2}$";

            Assert.assertTrue(price.matches(regex));
        });
    }
}

