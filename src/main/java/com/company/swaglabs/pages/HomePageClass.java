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


    public HomePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebElement getImage1() {
        return image1;

    }

    public WebElement getImage2() {
        return image2;
    }

    public WebElement getImage3() {
        return image3;
    }

    public WebElement getImage4() {
        return image4;
    }

    public WebElement getImage5() {
        return image5;
    }

    public WebElement getImage6() {
        return image6;
    }
    public  List<WebElement>  itemsImages(){
        List<WebElement> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        return images;
    }
    public List<WebElement> itemNames(){
        return itemsNames;
    }
    public WebElement getFiltrButton(){
        return filtrButton;
    }
    public WebElement getZa(){
        return Za;
    }
}

