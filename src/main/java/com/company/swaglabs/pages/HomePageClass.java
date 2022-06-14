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
import java.util.List;
import java.util.Random;

import static com.company.swaglabs.constants.Urls.HOMPAGE_URL;
import static com.company.swaglabs.utils.CustomWebElement.click;
import static com.company.swaglabs.utils.CustomWebElement.isDisplayed;
import static com.company.swaglabs.utils.WaitHelper.waitUntilElementClickable;

public class HomePageClass extends BasePage {
    private WebDriver driver;
    @FindBy(css = "img[class='inventory_item_img']")
    private List<WebElement> imageItems;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemsNames;
    @FindBy(className = "product_sort_container")
    private WebElement filtrButton;
    @FindBy(css = "[value='za']")
    private WebElement zToa;
    @FindBy(css = "[value='az']")
    private WebElement aToz;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemsPrices;
    @FindBy(css = "[value='lohi']")
    private WebElement lowToHigh;
    @FindBy(css = "[value='hilo']")
    private WebElement highToLow;
    @FindBy(className = "btn")
    private List<WebElement> addToCartsAndRemove;
    @FindBy(className = "btn")
    private WebElement addToCartAndRemove;
    @FindBy(className = "inventory_item_desc")
    private List<WebElement> itemsDescriptions;
    @FindBy(css = "[class='btn btn_secondary btn_small btn_inventory']")
    private WebElement remove;
    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private WebElement addToCart;



    public HomePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void allItemsVisibilityOf() {
        isDisplayed(super.getHeader().getAllItems());
    }

    public boolean isImageItemDisplayed(int index) {
        return isDisplayed(imageItems.get(index));
    }

    public int imageItemsCount() {
        return imageItems.size();
    }

    public int itemNamesSize() {
        return itemsNames.size();
    }

    public boolean itemNamesIsDisplayed(int index) {
        return isDisplayed(itemsNames.get(index));
    }

    public String itemNamesText(int index) {
        return itemsNames.get(index).getText();
    }

    public WebElement getFiltrButton() {
        return filtrButton;
    }

    public void clickToZtoA() {
        click(zToa);
    }

    public void clickToAtoZ() {
        click(aToz);
    }

    public int itemPricesSize() {
        return itemsPrices.size();
    }

    public String itemsPricesText(int index) {
        return itemsPrices.get(index).getText();
    }

    public void clickToLowToHigh() {
        click(lowToHigh);
    }

    public void clickToHighToLow() {
        click(highToLow);
    }

    public void clickToAddToCartAndRemove(int index) {
        click(addToCartsAndRemove.get(index));
    }

    public int getAddToCardAndRemoveSize() {
        return addToCartsAndRemove.size();
    }

    public String addToCartText() {
        return addToCart.getText();
    }

    public String itemsDescriptionsText(int index) {
        return itemsDescriptions.get(index).getText();
    }

    public void addToCardAndRemoveClickable() {
        waitUntilElementClickable(addToCartAndRemove);
    }

    public String removeText() {
        return remove.getText();
    }


    public boolean compareImageItems() {
        Random random = new Random();
        int size = imageItems.size();
        int randomIndex1 = random.nextInt(size);
        int randomIndex2 = random.nextInt(size);

        Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageItems.get(randomIndex1));
        Screenshot screenshot2 = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageItems.get(randomIndex2));

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

//    public static void main(String[] args) throws IOException {
//
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://demo.guru99.com/test/guru99home/");
//
//        // Find the element and take a screenshot
//
//        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"site-name\"]/a[1]/img"));
//        Screenshot logoElementScreenshot = new AShot().takeScreenshot(driver, logoElement);
//
//        // read the image to compare
//
//        BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\user\\Pictures\\Guru99logo.png"));
//
//        BufferedImage actualImage = logoElementScreenshot.getImage();
//        ImageIO.write(actualImage, "png", new File("C:\\Users\\user\\Pictures\\Guru99logo_actual.png"));
//
//        // Create ImageDiffer object and call method makeDiff()
//
//        ImageDiffer imgDiff = new ImageDiffer();
//        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
//
//        if (diff.hasDiff()) {
//            System.out.println("Images are different");
//        } else {
//            System.out.println("Images are same");
//        }
//        driver.quit();
//    }
}

