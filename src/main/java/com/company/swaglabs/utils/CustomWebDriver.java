package com.company.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWebDriver {
    private static WebDriver driver;


    private CustomWebDriver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
