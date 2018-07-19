package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class for tablePCPage
 */
public class TabletPCPage extends AbstractPage {

    protected static final String GET_PRODUCER_X_PATH
            = "//div[@class='schema-filter-popover__inner']//span[contains(text(), '%s')]" +
            "/preceding-sibling::span/input";

    protected static final String IS_SELECTED_PRODUCER_X_PATH
            = "//div[div[span[contains(text(), 'Производитель')]]]//span[contains(text(), '%s')]" +
            "/preceding-sibling::span/input";

    @FindBy(xpath = "//div[div[span[contains(text(), 'Производитель')]]]//div[starts-with(text(), 'Все')]")
    private WebElement producerCheckBox;

    private WebElement producer;

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
    public WebElement getAllProducerList() {
        return producerCheckBox;
    }

    /**
     * Method to get xpath for producer
     *
     * @param producerName
     * @return x-path for producer
     */
    public String getProducer(String producerName) {
        return String.format(GET_PRODUCER_X_PATH, producerName);
    }

    public String checkProducer(String producerName) {
        return String.format(IS_SELECTED_PRODUCER_X_PATH, producerName);
    }
}
