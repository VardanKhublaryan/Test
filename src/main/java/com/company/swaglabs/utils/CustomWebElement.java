package com.company.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.company.swaglabs.utils.WaitHelper.*;

public class CustomWebElement {
    private static final WebDriver DRIVER = CustomWebDriver.getDriver();
    private static final WebDriverWait WAIT = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

    public CustomWebElement() {
    }


    public static boolean isDisplayed(WebElement webElement) {
        try {
            WAIT.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            System.out.println(e + webElement.getText() + "is not displayed");
            return false;
        }
    }

    public static void click(WebElement webElement) {
        isDisplayed(webElement);
        try {
            waitUntilElementClickable(webElement);
            webElement.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void fill(WebElement webElement, String field) {
        isDisplayed(webElement);
        try {
            webElement.clear();
            webElement.sendKeys(field);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
