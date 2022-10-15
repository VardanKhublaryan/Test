package com.company.swaglabs.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.company.swaglabs.constants.LogInData.*;

public class WaitHelper {
    private static final WebDriver DRIVER = CustomWebDriver.getDriver();


    public static void waitUntilElementClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(TIME_OUT.toInteger()));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            System.out.println(e + webElement.getText() + "is not displayed");
        }
    }

    public static void waitUntilElementSelected(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(TIME_OUT.toInteger()));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeSelected(webElement));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean waitForJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(TIME_OUT.toInteger()));
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad);
    }

    public static boolean waitForJStoLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT.toInteger()));
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        return wait.until(jsLoad);
    }
}
