package com.company.swaglabs.pages;

import com.company.swaglabs.action.WrapActions;
import com.company.swaglabs.constants.LogInData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.company.swaglabs.action.WrapActions.*;


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

    private WrapActions wrapActions;


    public LoginPageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wrapActions = new WrapActions(driver);
    }

    public void login(LogInData userName, LogInData password) {
        fill(loginField, userName.toString());
        fill(passwordField, password.toString());
        click(loginButton);
    }

    public boolean loginPageIconVisibilityOf() {
        if (visibilityOf(icon)) {
            return true;
        }
        return false;
    }

    public boolean logoVisibilityOf() {
        if (visibilityOf(logo)) {
            return true;
        }
        return false;
    }

    public String getErrorMsg() {
        visibilityOf(loginError);
        return loginError.getText();
    }

}
