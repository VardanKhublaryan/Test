import com.company.swaglabs.components.Header;
import com.company.swaglabs.constants.ItemsTexts;
import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.company.swaglabs.components.Header.*;
import static com.company.swaglabs.constants.LogInData.*;
import static com.company.swaglabs.pages.HomePageClass.*;
import static com.company.swaglabs.pages.LoginPageClass.*;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;

@Test
public class HomePage extends BaseTest {


    @BeforeMethod
    public void login() {
        new LoginPageClass(getDriver());
        loginn(STANDARD_USER, PASSWORD);
        new HomePageClass(getDriver());
    }

    @Test
    public void itemsImages() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < imageItemsCount(); i++) {
            softAssert.assertTrue(isImageItemDisplayed(i), "image " + (i + 1) + " is not displayed");
        }
        softAssert.assertAll();
    }

    @Test
    public void productImageItems() {
        Assert.assertTrue(compareImageItems());
    }

    @Test
    public void logo(){
        new Header(getDriver());
        Assert.assertTrue(logoIsDisplayed());
    }

    @Test()
    public void menuBar() {
        HomePageClass homePageClass = new HomePageClass(getDriver());
        menuBarIsVisibility();
        clickOnMenuBar();
        homePageClass.allItemsVisibilityOf();
    }

    @Test
    public void logOut(){
        menuBar();
        clickToLogOutButton();
        Assert.assertTrue(logoVisibilityOf());
    }

    @Test
    public void about(){
        new Header(getDriver());
        menuBar();
        clickAboutButton();
        Assert.assertTrue(iconIsDisplayed());
    }

    @Test
    public void itemsDescriptions() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < ItemsTexts.getItemsTexts().length; i++) {
            softAssert.assertEquals(itemsDescriptionsText(i),
                    ItemsTexts.getItemsTexts()[i].getText(), "item " + i + " text is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void itemPrices() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < itemPricesSize(); i++) {
            softAssert.assertEquals(itemsPricesText(i),
                    ItemsTexts.getItemsPrices()[i].getText(), "item " + i + " price is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterZtoA() {
        SoftAssert softAssert = new SoftAssert();
        clickToZtoA();
        for (int i = 1; i < itemNamesSize(); i++) {
            softAssert.assertTrue(itemNamesIsDisplayed(i));
            int b = itemNamesText(i).compareTo(itemNamesText(i - 1));
            softAssert.assertTrue(b <= 0, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterAtoZ() {
        SoftAssert softAssert = new SoftAssert();
        clickToAtoZ();
        for (int i = 1; i < itemNamesSize(); i++) {
            softAssert.assertTrue(itemNamesIsDisplayed(i));
            int b = itemNamesText(i).compareTo(itemNamesText(i - 1));
            softAssert.assertTrue(b >= 0, "false");
        }
        softAssert.assertAll();
    }

    @Test
    public void filterLowToHigh() {
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
        basePage.getFooter().FooterRobotVisibilityOf();
        Assert.assertEquals(basePage.getFooter().footerTex(), FOOTER_TEXT.toString());
    }


    @Test
    public void checkShoppingCartBadge() {
        int i = 1;
        for (int j = 0; j < getAddToCardAndRemoveSize(); j++) {
            clickToAddToCartAndRemove(j);
            Assert.assertTrue(shoppingCartBadgeIsDisplayed());
            Assert.assertEquals(shoppingCartBadgeGetText(), Integer.toString(i));
            i++;
        }
    }
}

