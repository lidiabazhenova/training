package com.lidiabazhenova.tests.pageObjects;

import com.lidiabazhenova.framework.util.WebElementExtender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * class for tablePCPage
 */
public class TabletPCPage extends AbstractPage {

    private static final String GET_PRODUCER_X_PATH
            = "//div[@class='schema-filter-popover__inner']//span[contains(text(), '%s')]" +
            "/preceding-sibling::span/input";

    @FindBy(xpath = "//div[div[span[contains(text(), 'Производитель')]]]//div[starts-with(text(), 'Все')]")
    private WebElement allProducersFilter;

    @FindBy(xpath = "//div[@class='schema-filter-popover schema-filter-popover_visible']")
    private WebElement allProducersPopup;

    @FindBy(xpath = "//div[@class='schema-product__info']//preceding-sibling::div[@class='schema-product__title']//span")
    private List<WebElement> resultTabletPCNameList;

    @FindBy(xpath = "//*[@id='schema-pagination']/a/span")
    private WebElement pagination;

    /**
     * constructor for tabletPCPage
     *
     * @param driver
     */
    public TabletPCPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to get element "Все 62 варианта"
     *
     * @return web element
     */
    public WebElement getAllProducersFilter() {
        return allProducersFilter;
    }

    /**
     * Method to click on "Все 62 варианта" in filter "Производитель"
     *
     * @return current page
     */
    public TabletPCPage clickAllProducersFilter() {
        WebElementExtender.click(driver, allProducersFilter);
        WebElementExtender.waitForVisibilityOfElement(driver, allProducersPopup);

        return this;
    }

    /**
     * Method to get producers popup
     * @return producers popup element
     */
    public WebElement getAllProducersPopup() {
        return allProducersPopup;
    }

    /**
     * Method to get producer in popup by producerName
     *
     * @param producerName
     * @return producer
     */
    public WebElement getProducerInCheckbox(String producerName) {
        return driver.findElement(By.xpath(String.format(GET_PRODUCER_X_PATH, producerName)));
    }

    /**
     * Method to get results of search
     *
     * @return list of tabletPC extended names
     */
    public List<String> getTabletPCNameList() {
        final List<String> listTabletPCNames = new ArrayList<>();
        resultTabletPCNameList.forEach((tabletPC) -> {
            listTabletPCNames.add(tabletPC.getText());
        });
        return listTabletPCNames;
    }

    /**
     * Method to get element "pagination"
     *
     * @return element "pagination"
     */
    public WebElement getPagination() {
        return pagination;
    }
}
