package com.company.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.company.swaglabs.constants.Urls.*;
import static com.company.swaglabs.utils.CustomWebElement.click;
import static com.company.swaglabs.utils.CustomWebElement.isDisplayed;
import static com.company.swaglabs.utils.WaitHelper.waitUntilElementClickable;

public class HomePageClass extends BasePage {

    private static WebDriver driver;
    @FindBy(css = "img[class='inventory_item_img']")
    private static List<WebElement> imageItems;
    @FindBy(className = "inventory_item_name")
    private static List<WebElement> itemsNames;
    @FindBy(className = "product_sort_container")
    private WebElement filtrButton;
    @FindBy(css = "[value='za']")
    private static WebElement zToa;
    @FindBy(css = "[value='az']")
    private static WebElement aToz;
    @FindBy(className = "inventory_item_price")
    private static List<WebElement> itemsPrices;
    @FindBy(css = "[value='lohi']")
    private static WebElement lowToHigh;
    @FindBy(css = "[value='hilo']")
    private static WebElement highToLow;
    @FindBy(className = "btn")
    private static List<WebElement> addToCartsAndRemove;
    @FindBy(className = "btn")
    private static WebElement addToCartAndRemove;
    @FindBy(className = "inventory_item_desc")
    private static List<WebElement> itemsDescriptions;
    @FindBy(css = "[class='btn btn_secondary btn_small btn_inventory']")
    private WebElement remove;
    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private WebElement addToCart;
    @FindBy(id = "continue-shopping")
    private static WebElement continueShopping;
    @FindBy(css = "[class='r-1cvl2hr r-4qtqp9 r-yyyyoo r-16y2uox r-8kz0gk r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-lrsllp']")
    private WebElement twittwrLogo;


    public HomePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void allItemsVisibilityOf() {
        isDisplayed(getHeader().getAllItems());
    }

    public static boolean isImageItemDisplayed(int index) {
        return isDisplayed(imageItems.get(index));
    }

    public static int imageItemsCount() {
        return imageItems.size();
    }

    public static int itemNamesSize() {
        return itemsNames.size();
    }

    public static boolean itemNamesIsDisplayed(int index) {
        return isDisplayed(itemsNames.get(index));
    }

    public static String itemNamesText(int index) {
        return itemsNames.get(index).getText();
    }

    public WebElement getFiltrButton() {
        return filtrButton;
    }

    public static void clickToZtoA() {
        click(zToa);
    }

    public static void clickToAtoZ() {
        click(aToz);
    }

    public static int itemPricesSize() {
        return itemsPrices.size();
    }

    public static String itemsPricesText(int index) {
        return itemsPrices.get(index).getText();
    }

    public static void clickToLowToHigh() {
        click(lowToHigh);
    }

    public static void clickToHighToLow() {
        click(highToLow);
    }

    public static void clickToAddToCartAndRemove(int index) {
        click(addToCartsAndRemove.get(index));
    }

    public static int getAddToCardAndRemoveSize() {
        return addToCartsAndRemove.size();
    }

    public static String addToCartAndRemoveText(int index) {
        return addToCartsAndRemove.get(index).getText();
    }

    public static String itemsDescriptionsText(int index) {
        return itemsDescriptions.get(index).getText();
    }

    public static void addToCardAndRemoveClickable() {
        waitUntilElementClickable(addToCartAndRemove);
    }

    public static boolean compareImageItems() {
        Random random = new Random();
        int size = imageItems.size();
        int randomIndex1 = random.nextInt(size);
        int randomIndex2 = random.nextInt(size);

        Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).
                takeScreenshot(driver, imageItems.get(randomIndex1));
        Screenshot screenshot2 = new AShot().coordsProvider(new WebDriverCoordsProvider()).
                takeScreenshot(driver, imageItems.get(randomIndex2));

        BufferedImage randomImageItem1 = screenshot1.getImage();
        BufferedImage randomImageItem2 = screenshot2.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        isDisplayed(imageItems.get(randomIndex1));
        isDisplayed(imageItems.get(randomIndex2));
        ImageDiff diff = imgDiff.makeDiff(randomImageItem1, randomImageItem2).withDiffSizeTrigger(20);
        BufferedImage diffImage = diff.getDiffImage();
        try {
            ImageIO.write(diffImage, "PNG", new File("C:\\Users\\user\\Pictures\\diff.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diff.hasDiff();
    }

    public static void clickToContinueShopping() {
        click(continueShopping);
    }

    @Override
    protected void load() {
        driver.get(HOMPAGE_URL.toString());
    }

    @Override
    public HomePageClass get() {
        try {
            super.jsIsLoaded();
            return this;

        } catch (Error e) {
            this.load();
        }
        super.jsIsLoaded();
        return this;
    }

    public void clickOnTwitter() {
        isDisplayed(getFooter().getTwitter());
        click(getFooter().getTwitter());
    }

    public boolean twitterLogoIsDisplayed() {
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }

        }
        return isDisplayed(twittwrLogo);
    }
}

