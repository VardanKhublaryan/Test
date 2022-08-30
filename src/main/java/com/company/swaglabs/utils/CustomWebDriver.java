package com.company.swaglabs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.company.swaglabs.utils.Configuration.*;


public class CustomWebDriver {
    private static WebDriver driver = null;
    private static final String browserName = "edge";

    private CustomWebDriver() {
    }

    private static ChromeOptions setOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    private static EdgeOptions edgeOptions() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        return edgeOptions;
    }

    private static FirefoxOptions firefoxOptions(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        return firefoxOptions;
    }

    public static void setDriver(WebDriver driver) {
        CustomWebDriver.driver = driver;
    }

    public static WebDriver getDriver() {
        if (driver == null && browserName.equalsIgnoreCase(chrome)) {
            driver = new ChromeDriver(setOptions());
        }
        else if (driver == null && browserName.equalsIgnoreCase(edge)) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver(edgeOptions());
        }
        else if (driver == null && browserName.equalsIgnoreCase(firefox)){
            driver = new FirefoxDriver(firefoxOptions());
        }
        return driver;
    }

}