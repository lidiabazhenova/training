package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * class for tablePCPage
 */
public class TabletPCPage extends AbstractPage {

    private static final String GET_PRODUCER_X_PATH
            = "//div[@class='schema-filter-popover__inner']//span[contains(text(), '%s')]" +
            "/preceding-sibling::span/input";

    @FindBy(xpath = "//div[div[span[contains(text(), 'Производитель')]]]//div[starts-with(text(), 'Все')]")
    private WebElement allProducerListCheckBox;

    @FindBy(xpath = "//div[@class='schema-product__info']//preceding-sibling::div[@class='schema-product__title']//span")
    private List<WebElement> resultTablePC;

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
     * Method to get all producers list
     *
     * @return current element
     */
    public WebElement getAllProducerListCheckbox() {
        return allProducerListCheckBox;
    }

    /**
     * Method to get web element for producer in popover
     *
     * @param producerName
     * @return web element
     */
    public WebElement getProducerCheckbox(String producerName) {
        return driver.findElement(By.xpath(String.format(GET_PRODUCER_X_PATH, producerName)));
    }

    /**
     * Method to get results for search
     *
     * @return list results of search
     */
    public List<WebElement> getResultTablePC() {
        return resultTablePC;
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
