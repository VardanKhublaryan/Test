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
        new YourCartPage(getDriver());
        new BasePage();
        new HomePageClass(getDriver());
        clickOnShopContainer();
        Assert.assertTrue(checkoutButtonIsDisplayed());
    }

    @Test
    public void continueShopping() {
        clickToContinueShopping();
        Assert.assertTrue(addToCardIsDisplayed());
    }

    @Test
    public void checkOut() {
        clickToCheckOutButton();
        Assert.assertTrue(checkOutTitleIsDisplayed());
        clickToCanselButton();
        Assert.assertTrue(continueShoppingIsDisplayed());
    }

    @Test
    public void checkOutOverview() {
        checkOutInformation();
        Assert.assertEquals(paymentInfoGetText(), PAYMENT_INFO.toString());
        Assert.assertEquals(sauceCartGetText(), SAUCE_CARD.toString());
        Assert.assertEquals(freePonyExpressGetText(), FREE_PONY_EXPRESS.toString());
        Assert.assertEquals(shippingInfoText(), SHIPPING_INFO.toString());
    }

    @Test
    public void errorMessage() {
        clickToCheckOutButton();
        clickContinueButton();
        Assert.assertEquals(getErrorMessage(), ERROR_MESSAGE.toString());
    }

    @Test
    public void fieldsErrorMessages() {
        clickToCheckOutButton();
        fillFirstName();
        clickContinueButton();
        Assert.assertEquals(getErrorMessage(), LASTNAME_ERROR_MESSAGE.toString());
        fillLastName();
        clickContinueButton();
        Assert.assertEquals(getErrorMessage(), POSTAL_CODE_ERROR_MESSAGE.toString());
    }

    @Test
    public void checkOutInfo() {
        checkOutInformation();
        Assert.assertTrue(paymentInfoIsDisplayed());

        clickToFinishButton();
        Assert.assertTrue(backToHomeIsDisplayed());

        clickToBackToHome();
        Assert.assertTrue((shopContainerIsDisplayed()));
    }

    @Test
    public void itemTotal() {
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
        itemTotal();
        Assert.assertTrue(checkTax());
        Assert.assertTrue(checkTotal());
    }
}
