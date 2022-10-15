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
    @FindBy(id = "about_sidebar_link")
    private static WebElement about;
    @FindBy(className = "nav-image-link")
    private static WebElement iconInAboutPage;
    @FindBy(id = "logout_sidebar_link")
    private static WebElement logOut;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public static void clickOnMenuBar() {
        click(menuBar);
    }

    public static boolean menuBarIsVisibility() {
        return isDisplayed(menuBar);
    }

    public static void clickOnShopContainer() {
        click(shopContainer);
    }
    public static boolean shopContainerIsDisplayed(){
        return isDisplayed(shopContainer);
    }

    public static boolean logoIsDisplayed() {
        return isDisplayed(logo);
    }

    public static void clickAllItemsButton(){
        click(allItems);
    }

    public static WebElement getAllItems() {
        return allItems;
    }

    public static void clickAboutButton(){
        click(about);
    }

    public static boolean iconIsDisplayed(){
        return isDisplayed(iconInAboutPage);
    }

    public  void clickOnLogOutButton(){
        click(logOut);
    }

}

