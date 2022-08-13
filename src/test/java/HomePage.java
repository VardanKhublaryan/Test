import com.company.swaglabs.constants.ItemsTexts;
import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.company.swaglabs.components.Header.clickOnMenuBar;
import static com.company.swaglabs.components.Header.menuBarIsVisibility;
import static com.company.swaglabs.constants.LogInData.*;
import static com.company.swaglabs.pages.HomePageClass.*;
import static com.company.swaglabs.pages.LoginPageClass.loginn;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;

@Test
public class HomePage extends BaseTest {


    HomePageClass homePageClass = new HomePageClass(getDriver());


    @BeforeMethod
    public void login() {
        new LoginPageClass(getDriver());
        loginn(STANDARD_USER, PASSWORD);
    }

    @Test
    public void itemsImages() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < imageItemsCount(); i++) {
            softAssert.assertTrue(isImageItemDisplayed(i), "image " + (i + 1) + " is not displayed");
        }
        softAssert.assertAll();
    }

    @Test
    public void productImageItems() {
        new HomePageClass(getDriver());
        Assert.assertTrue(compareImageItems());
    }

    @Test()
    public void menuBar() {
        new HomePageClass(getDriver());
        menuBarIsVisibility();
        clickOnMenuBar();
        homePageClass.allItemsVisibilityOf();
    }

    @Test
    public void itemsDescriptions() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < ItemsTexts.getItemsTexts().length; i++) {
            softAssert.assertEquals(itemsDescriptionsText(i),
                    ItemsTexts.getItemsTexts()[i].getText(), "item " + i + " text is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void itemPrices() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < itemPricesSize(); i++) {
            softAssert.assertEquals(itemsPricesText(i),
                    ItemsTexts.getItemsPrices()[i].getText(), "item " + i + " price is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterZtoA() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        clickToZtoA();
        for (int i = 1; i < itemNamesSize(); i++) {
            itemNamesIsDisplayed(i);
            int b = itemNamesText(i).compareTo(itemNamesText(i - 1));
            softAssert.assertTrue(b <= 0, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterAtoZ() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        clickToAtoZ();
        for (int i = 1; i < itemNamesSize(); i++) {
            itemNamesIsDisplayed(i);
            int b = itemNamesText(i).compareTo(itemNamesText(i - 1));
            softAssert.assertTrue(b >= 0, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterLowToHigh() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        clickToLowToHigh();
        for (int i = 1; i < itemPricesSize(); i++) {
            double b = Double.parseDouble(itemsPricesText(i).substring(1));
            double a = Double.parseDouble(itemsPricesText((i - 1)).substring(1));
            softAssert.assertTrue(a <= b, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterHighToLow() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        clickToHighToLow();
        for (int i = 1; i < itemPricesSize(); i++) {
            double b = Double.parseDouble(itemsPricesText(i).substring(1));
            double a = Double.parseDouble(itemsPricesText(i - 1).substring(1));
            softAssert.assertTrue(a >= b, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void addToCartAndRemove() {
        new HomePageClass(getDriver());
        SoftAssert softAssert = new SoftAssert();
        int size = getAddToCardAndRemoveSize();
        for (int i = 0; i < size; i++) {
            addToCardAndRemoveClickable();
            clickToAddToCartAndRemove(i);
            softAssert.assertEquals(addToCartAndRemoveText(i), "REMOVE");

            addToCardAndRemoveClickable();
            clickToAddToCartAndRemove(i);
            softAssert.assertEquals(addToCartAndRemoveText(i), "ADD TO CART");
        }
        softAssert.assertAll();
    }

    @Test
    public void footer() {
        BasePage basePage = new BasePage();
        new HomePageClass(getDriver());
        basePage.getFooter().FooterRobotVisibilityOf();
        Assert.assertEquals(basePage.getFooter().footerTex(), FOOTER_TEXT.toString());
    }

    @Test
    public void shopContainer() {
        BasePage basePage = new BasePage();
        new HomePageClass(getDriver());
        basePage.getHeader().clickOnShopContainer();
        clickToContinueShopping();
    }

    @Test
    public void twitter() {
        new HomePageClass(getDriver()).
                clickOnTwitter();
        Assert.assertTrue(homePageClass.twitterLogoIsDisplayed());
    }

    @Test
    public void facebook() {
        new HomePageClass(getDriver()).
                clickOnFacebook();
        Assert.assertTrue(homePageClass.facebookIsDisplayed());
    }

    @Test
    public void linkedIn() {
        new HomePageClass(getDriver()).
                clickOnLinkedIn();
        Assert.assertTrue(homePageClass.linnkedInIsDisplayed());
    }

}

