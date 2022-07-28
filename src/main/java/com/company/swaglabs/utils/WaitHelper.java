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
    private static WebDriver driver = CustomWebDriver.getDriver();

    public static void waitUntilElementClickable(WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT.toInteger())).
                    until(ExpectedConditions.visibilityOf(webElement));
            new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT.toInteger())).
                    until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            System.out.println(e + webElement.getText() + "is not displayed");

        }
    }

    public static boolean waitForJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT.toInteger()));
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

    public static boolean waitForJStoLoad() {
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
