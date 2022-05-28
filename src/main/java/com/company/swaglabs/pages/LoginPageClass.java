package com.company.swaglabs.pages;

import com.company.swaglabs.constants.LogInData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageClass {
    WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(className = "bot_column")
    private WebElement icon;
    @FindBy(className = "login_logo")
    private WebElement logo;
    @FindBy(className = "error-message-container")
    private WebElement loginError;


    public LoginPageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(LogInData userName, LogInData password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys(userName.toString());
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password.toString());
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public WebElement getLoginPageIcon() {
        return icon;
    }

    public WebElement getLogo() {
        return logo;

    }

    public String getErrorMsg() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(loginError));
        return loginError.getText();
    }

}
