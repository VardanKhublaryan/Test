package com.company.swaglabs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.company.swaglabs.utils.Configuration.*;


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

    private static EdgeOptions edgeOptions() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        return edgeOptions;
    }

    public static void setDriver(WebDriver driver) {
        CustomWebDriver.driver = driver;
    }


    public static WebDriver getDriver(){
        if (driver == null && BROWSER_NAME.equalsIgnoreCase(CHROME)) {
            driver = new ChromeDriver(setOptions());
        } else if (driver == null && BROWSER_NAME.equalsIgnoreCase(EDGE)) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver(edgeOptions());
        } else if (driver == null && BROWSER_NAME.equalsIgnoreCase(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

}