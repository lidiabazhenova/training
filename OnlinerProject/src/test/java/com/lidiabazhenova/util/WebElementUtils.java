package com.lidiabazhenova.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public final class WebElementUtils {

    private static final String SCRIPT_SCROLL = "arguments[0].scrollIntoView(true);";
    private static final String SCRIPT_CLICK = "arguments[0].click()";

    private WebElementUtils() {
    }

    public static void scrollToElement(final WebDriver driver, final WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript(SCRIPT_SCROLL, element);
    }

    public static void scrollToElementAndClick(final WebDriver driver, final WebElement element) {
        try {
            element.click();
        } catch(final WebDriverException ex) {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript(SCRIPT_CLICK, element);
        }
    }
}
