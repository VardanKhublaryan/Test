import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.YourCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static com.company.swaglabs.components.Header.clickOnShopContainer;
import static com.company.swaglabs.components.Header.shopContainerIsDisplayed;
import static com.company.swaglabs.constants.CheckOutOverview.*;
import static com.company.swaglabs.pages.HomePageClass.*;
import static com.company.swaglabs.pages.YourCartPage.*;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;

public class YourCart extends BaseTest {


    @BeforeMethod
    public void goToYourCartPage() {
        new LoginPage().login();
        new BasePage();
        new HomePageClass(getDriver());
        clickOnShopContainer();
        Assert.assertTrue(checkoutButtonIsDisplayed());
    }

    @Test
    public void continueShopping() {
        new HomePageClass(getDriver());
        new YourCartPage(getDriver());
        clickToContinueShopping();
        Assert.assertTrue(addToCardIsDisplayed());
    }

    @Test
    public void checkOut() {
        new YourCartPage(getDriver());
        clickToCheckOutButton();
        Assert.assertTrue(checkOutTitleIsDisplayed());
        clickToCanselButton();
        Assert.assertTrue(continueShoppingIsDisplayed());
    }

    @Test
    public void checkOutOverview() {
        new YourCartPage(getDriver());
        checkOutInformation();
        Assert.assertEquals(paymentInfoGetText(), PAYMENT_INFO.toString());
        Assert.assertEquals(sauceCartGetText(), SAUCE_CARD.toString());
        Assert.assertEquals(freePonyExpressGetText(), FREE_PONY_EXPRESS.toString());
        Assert.assertEquals(shippingInfoText(), SHIPPING_INFO.toString());
    }

    @Test
    public void errorMessage(){
        new YourCartPage(getDriver());
        clickToCheckOutButton();
        clickContinueButton();
        Assert.assertEquals(getErrorMessage(),ERROR_MESSAGE.toString());
    }

    @Test
    public void fieldsErrorMessages(){
        new YourCartPage(getDriver());
        clickToCheckOutButton();
        fillFirstName();
        clickContinueButton();
        Assert.assertEquals(getErrorMessage(),LASTNAME_ERROR_MESSAGE.toString());
        fillLastName();
        clickContinueButton();
        Assert.assertEquals(getErrorMessage(),POSTAL_CODE_ERROR_MESSAGE.toString());
    }

    @Test
    public void checkOutInfo() {
        new YourCartPage(getDriver());
        checkOutInformation();
        Assert.assertTrue(paymentInfoIsDisplayed());

        clickToFinishButton();
        Assert.assertTrue(backToHomeIsDisplayed());

        clickToBackToHome();
        Assert.assertTrue((shopContainerIsDisplayed()));
    }

    @Test
    public void itemTotal() {
        new YourCartPage(getDriver());
        new HomePageClass(getDriver());

        Random random = new Random();
        clickToContinueShopping();
        int item = random.nextInt(getAddToCardAndRemoveSize());
        String itemPrice = itemsPricesText(item);

        clickToAddToCartAndRemove(item);
        clickOnShopContainer();
        checkOutInformation();
        Assert.assertEquals(itemTotalGetValue(), itemPrice);
    }

    @Test
    public void taxAndTotal() {
        new YourCartPage(getDriver());
        itemTotal();
        Assert.assertTrue(checkTax());
        Assert.assertTrue(checkTotal());
    }
}
