package com.company.swaglabs.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.company.swaglabs.utils.CustomWebElement.click;
import static com.company.swaglabs.utils.CustomWebElement.isDisplayed;


public class Header {
    private WebDriver driver;

    @FindBy(className = "app_logo")
    private static WebElement logo;
    @FindBy(id = ("react-burger-menu-btn"))
    private static WebElement menuBar;
    @FindBy(className = "shopping_cart_link")
    private static WebElement shopContainer;
    @FindBy(id = "inventory_sidebar_link")
    private static WebElement allItems;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public static void clickOnMenuBar() {
        menuBar.click();
    }

    public static boolean menuBarIsVisibility() {
        if (isDisplayed(menuBar)) {
            return true;
        }
        return false;
    }

    public void clickOnShopContainer() {
        click(shopContainer);
    }
    public static boolean shopContainerIsDisplayed(){
        return isDisplayed(shopContainer);
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getAllItems() {
        return allItems;
    }

}

