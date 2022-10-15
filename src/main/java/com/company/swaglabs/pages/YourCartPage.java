package com.company.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.company.swaglabs.utils.CustomWebElement.*;

public class YourCartPage extends BasePage {
    private WebDriver driver;

    @FindBy(id = "continue-shopping")
    private static WebElement continueShopping;
    @FindBy(id = "checkout")
    private static WebElement checkOutButton;
    @FindBy(id = "continue")
    private static WebElement continueButton;
    @FindBy(id = "first-name")
    private static WebElement firstName;
    @FindBy(id = "last-name")
    private static WebElement lastName;
    @FindBy(id = "postal-code")
    private static WebElement postalCode;
    @FindBy(className = "summary_total_label")
    private static WebElement totalLabel;
    @FindBy(id = "finish")
    private static WebElement finish;
    @FindBy(id = "back-to-products")
    private static WebElement backToHome;
    @FindBy(className = "summary_info_label")
    private static List<WebElement> summaryInfo;
    @FindBy(className = "summary_value_label")
    private static List<WebElement> summaryValue;
    @FindBy(className = "summary_subtotal_label")
    private static WebElement itemTotal;
    @FindBy(className = "summary_tax_label")
    private static WebElement tax;
    @FindBy(className = "title")
    private static WebElement checkOutTitle;
    @FindBy(id = "cancel")
    private static WebElement cancelButton;
    @FindBy(css = "[data-test='error']")
    private static WebElement errorMessage;


    public YourCartPage(WebDriver driver) {
        super();
        isLoaded();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean continueShoppingIsDisplayed() {
        return isDisplayed(continueShopping);
    }

    public static void clickToContinueShopping() {
        click(continueShopping);
    }

    public static void clickToCanselButton() {
        click(cancelButton);
    }

    public static boolean checkOutTitleIsDisplayed() {
        return isDisplayed(checkOutTitle);
    }

    public static void clickToCheckOutButton() {
        click(checkOutButton);
    }

    public static void clickContinueButton() {
        click(continueButton);
    }

    public static String getErrorMessage() {
        return errorMessage.getText();
    }

    public static void checkOutInformation() {
        click(checkOutButton);
        fill(firstName, "Vardan");
        fill(lastName, "Khublaryan");
        fill(postalCode, "G0L 1J0");
        click(continueButton);
    }

    public static void fillFirstName() {
        fill(firstName, "Vardan");
    }

    public static void fillLastName() {
        fill(lastName, "Khublaryan");
    }

    public static boolean paymentInfoIsDisplayed() {
        return isDisplayed(totalLabel);
    }

    public static void clickToFinishButton() {
        click(finish);
    }

    public static boolean backToHomeIsDisplayed() {
        return isDisplayed(backToHome);
    }

    public static void clickToBackToHome() {
        click(backToHome);
    }

    public static String paymentInfoGetText() {
        isDisplayed(summaryInfo.get(0));
        return summaryInfo.get(0).getText();
    }

    public static String shippingInfoText() {
        isDisplayed(summaryInfo.get(1));
        return summaryInfo.get(1).getText();
    }

    public static String sauceCartGetText() {
        isDisplayed(summaryValue.get(0));
        return summaryValue.get(0).getText();
    }

    public static String freePonyExpressGetText() {
        isDisplayed(summaryValue.get(1));
        return summaryValue.get(1).getText();
    }

    public static String itemTotalGetValue() {
        return itemTotal.getText().substring(12);
    }

    public static Float itemTotalGetNumber() {
        String itemText = itemTotal.getText().substring(13);
        return Float.parseFloat(itemText);
    }

    public static Float getTaxValue() {
        String taxText = tax.getText().substring(6);
        return Float.parseFloat(taxText);
    }

    public static boolean checkTax() {
        return itemTotalGetNumber() / getTaxValue() >= 12.4 && itemTotalGetNumber() / getTaxValue() <= 12.5;
    }

    public static Float getTotalNumber() {
        String total = totalLabel.getText().substring(8);
        return Float.parseFloat(total);
    }

    public static boolean checkTotal() {
        return getTotalNumber() == getTaxValue() + itemTotalGetNumber();
    }
}

