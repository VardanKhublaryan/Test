package com.company.swaglabs.pages;

import com.company.swaglabs.constants.LogInData;
import com.company.swaglabs.utils.CustomWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.company.swaglabs.constants.Urls.*;
import static com.company.swaglabs.utils.CustomWebElement.*;


public class LoginPageClass extends BasePage {
    static WebDriver driver;
    @FindBy(tagName = "html")
    private static WebElement html;
    @FindBy(id = "user-name")
    private static WebElement loginField;
    @FindBy(id = "password")
    private static WebElement passwordField;
    @FindBy(id = "login-button")
    private static WebElement loginButton;
    @FindBy(className = "bot_column")
    private static WebElement icon;
    @FindBy(className = "login_logo")
    private static WebElement logo;
    @FindBy(className = "error-message-container")
    private static WebElement loginError;

    private CustomWebElement customWebElement;


    public LoginPageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        customWebElement = new CustomWebElement(driver);
    }

    public static void loginn(LogInData userName, LogInData password) {
        fill(loginField, userName.toString());
        fill(passwordField, password.toString());
        click(loginButton);
    }

    public static boolean loginPageIconVisibilityOf() {
        return isDisplayed(icon);
    }

    public static boolean logoVisibilityOf() {
        return isDisplayed(logo);
    }

    public static String getErrorMsg() {
        isDisplayed(loginError);
        return loginError.getText();
    }

    public static void zoomOut() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '1.5'");
    }

    @Override
    protected void load() {
        driver.get(LOGINPAGE_URL.toString());
    }

    public LoginPageClass get() {
        try {
            super.jsIsLoaded();
            return this;

        } catch (Error e) {
            this.load();
        }
        super.jsIsLoaded();
        return this;
    }

}
