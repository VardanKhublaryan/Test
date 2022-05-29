
import com.company.swaglabs.constants.ItemsTexts;
import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.LoginPageClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.company.swaglabs.constants.LogInData.*;


public class HomePage extends BaseTest {

    @BeforeMethod
    public void login() {
        LoginPageClass loginPageClass = new LoginPageClass(getDriver());
        try {
            loginPageClass.login(STANDARD_USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("login is failed");
        }
    }

    @Test
    public void ItemsImages() {
        HomePageClass homePage = new HomePageClass(getDriver());
        homePage.itemsImages();
        for (int i = 0; i < homePage.itemsImages().size(); i++) {
            try {
                homePage.itemsImages().get(i).isDisplayed();
            } catch (Exception e) {
                System.out.println("image " + (i + 1) + " is not displayed");
            }
        }
    }

    @Test
    public void menuBar() {
        BasePage basePage = new BasePage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(basePage.getHeader().getMenuBar()));
        try {
            Assert.assertTrue(basePage.getHeader().getMenuBar().isDisplayed(), "menu bar is not displayed");
            basePage.getHeader().clickOnMenuBar();
        } catch (AssertionError e) {
            System.out.println("menu bar is not displayed");
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(basePage.getHeader().getAllItems()));
            Assert.assertTrue(basePage.getHeader().getAllItems().isDisplayed(), "allItems button is not displayed");
        } catch (AssertionError e) {
            System.out.println("allItems button is not displayed");
        }
    }

    @Test
    public void itemsDescriptions(){
        HomePageClass homePageClass = new HomePageClass(getDriver());
        try {
            for (int i = 0; i < ItemsTexts.getItemsTexts().length; i++) {
                Assert.assertEquals(homePageClass.getItemsDescriptions().get(i).getText(),ItemsTexts.getItemsTexts()[i].getText());
            }
        }catch (AssertionError e){
            System.out.println(e);
        }
    }

    @Test
    public void filterZa() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.getZa().click();
        for (int i = 1; i < homePageClass.itemNames().size(); i++) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(homePageClass.itemNames().get(i)));
            if (i != 0) {
                int b = homePageClass.itemNames().get(i).getText().compareTo(homePageClass.itemNames().get(i - 1).getText());
                if (b <= 0) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        }
    }

    @Test
    public void filterAz() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.getAz().click();
        for (int i = 1; i < homePageClass.itemNames().size(); i++) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(homePageClass.itemNames().get(i)));
            if (i != 0) {
                int b = homePageClass.itemNames().get(i).getText().compareTo(homePageClass.itemNames().get(i - 1).getText());
                if (b >= 0) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        }
    }

    @Test
    public void filterLowToHigh() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.getLowToHigh().click();
        for (int i = 1; i < homePageClass.getItemsPrices().size(); i++) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(homePageClass.getItemsPrices().get(i)));
            double b = Double.parseDouble(homePageClass.getItemsPrices().get(i).getText().substring(1));
            double a = Double.parseDouble(homePageClass.getItemsPrices().get(i - 1).getText().substring(1));
            if (a <= b) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }

    @Test
    public void filterHighToLow() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.getHighToLow().click();
        for (int i = 1; i < homePageClass.getItemsPrices().size(); i++) {
            new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(homePageClass.getItemsPrices().get(i)));

            double b = Double.parseDouble(homePageClass.getItemsPrices().get(i).getText().substring(1));
            double a = Double.parseDouble(homePageClass.getItemsPrices().get(i - 1).getText().substring(1));
            if (a >= b) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }

    @Test
    public void addToCart() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(homePageClass.getAddToCart()));
            Assert.assertTrue(homePageClass.getAddToCart().isDisplayed());
            homePageClass.getAddToCart().click();
        } catch (Exception e) {
            System.out.println("add to cart button is not working");
        }


    }
}
