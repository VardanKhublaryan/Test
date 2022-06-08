package com.company.swaglabs.pages;

import com.company.swaglabs.utils.CustomWebElement;
import com.company.swaglabs.constants.LogInData;
import com.company.swaglabs.utils.LoadableComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.company.swaglabs.utils.CustomWebElement.*;


public class LoginPageClass extends LoadableComponent<LoginPageClass> {
    WebDriver driver;
    @FindBy(tagName = "html")
    private WebElement html;
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

    private CustomWebElement customWebElement;


    public LoginPageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        customWebElement = new CustomWebElement(driver);
    }

    public void login(LogInData userName, LogInData password) {
        fill(loginField, userName.toString());
        fill(passwordField, password.toString());
        click(loginButton);
    }

    public boolean loginPageIconVisibilityOf() {
        if (isDisplayed(icon)) {
            return true;
        }
        return false;
    }

    public boolean logoVisibilityOf() {
        if (isDisplayed(logo)) {
            return true;
        }
        return false;
    }

    public String getErrorMsg() {
        isDisplayed(loginError);
        return loginError.getText();
    }

    public void zoomOut() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '1.5'");

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
