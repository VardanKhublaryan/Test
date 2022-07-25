import com.company.swaglabs.constants.ItemsTexts;
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

@Test
public class HomePage extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginPageClass(driver);
        loginn(PROBLEM_USER, PASSWORD);
        HomePageClass homePageClass = new HomePageClass(getDriver());
        homePageClass.get();
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
    public void menuBar() {
        menuBarIsVisibility();
        clickOnMenuBar();
        allItemsVisibilityOf();
    }

    @Test
    public void itemsDescriptions() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < ItemsTexts.getItemsTexts().length; i++) {
            softAssert.assertEquals(itemsDescriptionsText(i), ItemsTexts.getItemsTexts()[i].getText(), "item " + i + " text is wrong");
        }
        softAssert.assertAll();
    }

    @Test
    public void itemPrices() {
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < itemPricesSize(); i++) {
            softAssert.assertEquals(itemsPricesText(i), ItemsTexts.getItemsPrices()[i].getText(), "item " + i + " price is wrong");
        }
        softAssert.assertAll();
    }

    @Test()
    public void filterZtoA() {
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
        getFooter().FooterRobotvisibilitiOf();
        Assert.assertEquals(getFooter().footerTex(), FOOTER_TEXT.toString());
    }

    @Test
    public void shopContainer() {
        getHeader().clickOnShopContainer();
        clickToContinueShopping();
    }
}
