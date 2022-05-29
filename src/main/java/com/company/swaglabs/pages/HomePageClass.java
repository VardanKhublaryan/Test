package com.company.swaglabs.pages;

import com.company.swaglabs.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePageClass {
    private WebDriver driver;
    @FindBy(xpath = "//img[@src='/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']")
    private WebElement image1;
    @FindBy(xpath = "//img[@src='/static/media/bike-light-1200x1500.a0c9caae.jpg']")
    private WebElement image2;
    @FindBy(xpath = "//img[@src='/static/media/bolt-shirt-1200x1500.c0dae290.jpg']")
    private WebElement image3;
    @FindBy(xpath = "//img[@src='/static/media/sauce-pullover-1200x1500.439fc934.jpg']")
    private WebElement image4;
    @FindBy(xpath = "//img[@src='/static/media/red-onesie-1200x1500.1b15e1fa.jpg']")
    private WebElement image5;
    @FindBy(xpath = "//img[@src='/static/media/red-tatt-1200x1500.e32b4ef9.jpg']")
    private WebElement image6;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemsNames;
    @FindBy(className = "product_sort_container")
    private WebElement filtrButton;
    @FindBy(css = "[value='za']")
    private WebElement Za;
    @FindBy(css = "[value='az']")
    private WebElement Az;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemsPrices;
    @FindBy(css = "[value='lohi']")
    private WebElement lowToHigh;
    @FindBy(css = "[value='hilo']")
    private WebElement HighToLow;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;
    @FindBy(className = "inventory_item_desc")
    private List<WebElement> itemsDescriptions;


    public HomePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public List<WebElement> itemsImages() {
        List<WebElement> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        return images;
    }

    public List<WebElement> itemNames() {
        return itemsNames;
    }

    public WebElement getFiltrButton() {
        return filtrButton;
    }

    public WebElement getZa() {
        return Za;
    }

    public WebElement getAz() {
        return Az;
    }

    public List<WebElement> getItemsPrices() {
        return itemsPrices;
    }

    public WebElement getLowToHigh() {
        return lowToHigh;
    }

    public WebElement getHighToLow() {
        return HighToLow;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }
    public List<WebElement> getItemsDescriptions(){
        return itemsDescriptions;
    }
}

