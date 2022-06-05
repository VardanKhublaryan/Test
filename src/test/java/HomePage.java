import com.company.swaglabs.constants.ItemsTexts;
import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.company.swaglabs.action.WrapActions.visibilityOf;
import static com.company.swaglabs.constants.LogInData.*;



public class HomePage extends BaseTest {


    @BeforeMethod
    public void login() {
        LoginPageClass loginPageClass = new LoginPageClass(getDriver());
        loginPageClass.login(STANDARD_USER, PASSWORD);
    }

    @Test
    public void itemsImages() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass homePage = new HomePageClass(getDriver());
        for (int i = 0; i < homePage.itemsImages().size(); i++) {
            softAssert.assertTrue(visibilityOf(homePage.itemsImages().get(i)), "image " + (i + 1) + " is not displayed");
        }
        softAssert.assertAll();
    }

    @Test
    public void menuBar() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        BasePage basePage = new BasePage(driver);
        basePage.getHeader().menuBarIsVisibility();
        basePage.getHeader().clickOnMenuBar();
        homePageClass.allItemsVisibilityOf();
    }

    @Test
    public void itemsDescriptions() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass homePageClass = new HomePageClass(getDriver());
        for (int i = 0; i < ItemsTexts.getItemsTexts().length; i++) {
            softAssert.assertEquals(homePageClass.getItemsDescriptions().get(i).getText(), ItemsTexts.getItemsTexts()[i].getText(), "item " + i + " text is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void itemPrices() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass homePageClass = new HomePageClass(getDriver());
        for (int i = 0; i < homePageClass.getItemsPrices().size(); i++) {
            softAssert.assertEquals(homePageClass.getItemsPrices().get(i).getText(), ItemsTexts.getItemsPrices()[i].getText(), "item " + i + " price is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterZa() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.clickToZa();
        for (int i = 1; i < homePageClass.itemNames().size(); i++) {
            visibilityOf(homePageClass.itemNames().get(i));
            int b = homePageClass.itemNames().get(i).getText().compareTo(homePageClass.itemNames().get(i - 1).getText());
            if (b <= 0) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }

    @Test
    public void filterAz() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.clickToAz();
        for (int i = 1; i < homePageClass.itemNames().size(); i++) {
            visibilityOf(homePageClass.itemNames().get(i));
            int b = homePageClass.itemNames().get(i).getText().compareTo(homePageClass.itemNames().get(i - 1).getText());
            if (b >= 0) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }

    @Test
    public void filterLowToHigh() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.clickToLowToHigh();
        for (int i = 1; i < homePageClass.getItemsPrices().size(); i++) {
            visibilityOf(homePageClass.getItemsPrices().get(i));
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
        homePageClass.clickToHighToLow();
        for (int i = 1; i < homePageClass.getItemsPrices().size(); i++) {
            visibilityOf(homePageClass.getItemsPrices().get(i));
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
        homePageClass.clickToAddToCart();
        homePageClass.RemoveVisibilityOf();
        homePageClass.clickToRemove();
        homePageClass.addToCardVisibility();

    }
}
