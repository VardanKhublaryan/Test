package com.company.swaglabs.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WrapActions {
    private WebDriver driver;
    private static WebDriverWait wait;

    public WrapActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
    }


    public static boolean visibilityOf(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            System.out.println(e + webElement.getText() + "is not displayed");
            return false;
        }
    }

    public static void click(WebElement webElement) {
        visibilityOf(webElement);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void fill(WebElement webElement, String field) {
        visibilityOf(webElement);
        try {
            webElement.clear();
            webElement.sendKeys(field);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
