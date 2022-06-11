import com.company.swaglabs.constants.ItemsTexts;
import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.company.swaglabs.constants.LogInData.*;


public class HomePage extends BaseTest {

    @BeforeMethod
    public void login() {
        LoginPageClass loginPageClass = new LoginPageClass(driver);
        loginPageClass.login(STANDARD_USER, PASSWORD);
        HomePageClass homePageClass = new HomePageClass(driver);
        homePageClass.get();

    }

    @Test(groups = "a")
    public void itemsImages() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass homePage = new HomePageClass(driver);
        for (int i = 0; i < homePage.imageItemsCount(); i++) {
            softAssert.assertTrue(homePage.isImageItemDisplayed(i), "image " + (i + 1) + " is not displayed");
        }
        softAssert.assertAll();
    }

    @Test
    public void productImageItems() {
        HomePageClass homePageClass = new HomePageClass(driver);
        Assert.assertTrue(homePageClass.compareImageItems());
    }

    @Test
    public void menuBar() {
        HomePageClass homePageClass = new HomePageClass(driver);
        BasePage basePage = new BasePage();
        basePage.getHeader().menuBarIsVisibility();
        basePage.getHeader().clickOnMenuBar();
        homePageClass.allItemsVisibilityOf();
    }

    @Test
    public void itemsDescriptions() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass homePageClass = new HomePageClass(driver);
        for (int i = 0; i < ItemsTexts.getItemsTexts().length; i++) {
            softAssert.assertEquals(homePageClass.itemsDescriptionsText(i), ItemsTexts.getItemsTexts()[i].getText(), "item " + i + " text is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void itemPrices() {
        SoftAssert softAssert = new SoftAssert();
        HomePageClass homePageClass = new HomePageClass(driver);
        for (int i = 0; i < homePageClass.itemPricesSize(); i++) {
            softAssert.assertEquals(homePageClass.itemsPricesText(i), ItemsTexts.getItemsPrices()[i].getText(), "item " + i + " price is wrong");
        }
        softAssert.assertAll();
    }

    @Test()
    public void filterZtoA() {
        HomePageClass homePageClass = new HomePageClass(driver);
        SoftAssert softAssert = new SoftAssert();
        homePageClass.clickToZtoA();
        for (int i = 1; i < homePageClass.itemNamesSize(); i++) {
            homePageClass.itemNamesIsDisplayed(i);
            int b = homePageClass.itemNamesText(i).compareTo(homePageClass.itemNamesText(i - 1));
            softAssert.assertTrue(b <= 0, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterAtoZ() {
        HomePageClass homePageClass = new HomePageClass(driver);
        SoftAssert softAssert = new SoftAssert();
        homePageClass.clickToAtoZ();
        for (int i = 1; i < homePageClass.itemNamesSize(); i++) {
            homePageClass.itemNamesIsDisplayed(i);
            int b = homePageClass.itemNamesText(i).compareTo(homePageClass.itemNamesText(i - 1));
            softAssert.assertTrue(b >= 0, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterLowToHigh() {
        HomePageClass homePageClass = new HomePageClass(driver);
        SoftAssert softAssert = new SoftAssert();
        homePageClass.clickToLowToHigh();
        for (int i = 1; i < homePageClass.itemPricesSize(); i++) {
            double b = Double.parseDouble(homePageClass.itemsPricesText(i).substring(1));
            double a = Double.parseDouble(homePageClass.itemsPricesText((i - 1)).substring(1));
            softAssert.assertTrue(a <= b, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterHighToLow() {
        HomePageClass homePageClass = new HomePageClass(driver);
        SoftAssert softAssert = new SoftAssert();
        homePageClass.clickToHighToLow();
        for (int i = 1; i < homePageClass.itemPricesSize(); i++) {
            double b = Double.parseDouble(homePageClass.itemsPricesText(i).substring(1));
            double a = Double.parseDouble(homePageClass.itemsPricesText(i - 1).substring(1));
            softAssert.assertTrue(a >= b, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void addToCart() {
        HomePageClass homePageClass = new HomePageClass(driver);
        homePageClass.clickToAddToCart();
        homePageClass.RemoveVisibilityOf();
        homePageClass.clickToRemove();
        homePageClass.addToCardVisibility();
    }

    @Test
    public void footer() {
        BasePage basePage = new BasePage();
        basePage.getFooter().FooterRobotvisibilitiOf();
        Assert.assertEquals(basePage.getFooter().footerTex(), FOOTER_TEXT.toString());
    }
}
