package com.company.swaglabs.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    WebDriver driver;
    private static final int TIME_OUT = 5;

    public void waitUntilElementClickable(WebElement webElement, WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.visibilityOf(webElement));
            new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            System.out.println(e + webElement.getText() + "is not displayed");

        }
    }

    public static boolean waitForJQueryToLoad(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
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
    public static boolean waitForJStoLoad(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
                ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")

                        .toString().equals("complete");

            }

        };
        return wait.until(jsLoad);
    }
}
