package com.company.swaglabs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CustomWebDriver {
    private static WebDriver driver = null;

    private CustomWebDriver() {
    }

    private static ChromeOptions setOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    public static void setDriver(WebDriver driver) {
        CustomWebDriver.driver = driver;
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            driver = new ChromeDriver(setOptions());
        }

        return driver;
    }
}