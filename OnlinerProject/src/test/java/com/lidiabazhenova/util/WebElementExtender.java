package com.lidiabazhenova.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebElementExtender {

    private static final String SCRIPT_SCROLL = "arguments[0].scrollIntoView(true);";
    private static final String SCRIPT_CLICK = "arguments[0].click()";

    private WebElementExtender() {
    }

    public static void scrollToElement(final WebDriver driver, final WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript(SCRIPT_SCROLL, element);
    }

    public static void click(final WebDriver driver, final WebElement element) {
        try {
            element.click();
        } catch(final WebDriverException ex) {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript(SCRIPT_CLICK, element);
        }
    }

    public static void waitForInvisibilityOfElement(final WebDriver driver, final By elementSelector) {
        final WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementSelector));
    }

    public static void waitForInvisibilityOfElement(final WebDriver driver, final WebElement element) {
        final WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOfElement(final WebDriver driver, final By elementSelector) {
        final  WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
    }

    public static void waitForVisibilityOfElement(final WebDriver driver, final WebElement element) {
        final  WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
