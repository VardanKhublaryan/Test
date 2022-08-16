import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.HomePageClass;
import com.company.swaglabs.pages.YourCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.company.swaglabs.components.Header.shopContainerIsDisplayed;
import static com.company.swaglabs.constants.ChecOutOverview.*;
import static com.company.swaglabs.constants.ChecOutOverview.SHIPPINGINFO;
import static com.company.swaglabs.pages.HomePageClass.addToCardIsDisplayed;
import static com.company.swaglabs.pages.HomePageClass.checkoutButtonIsDisplayed;
import static com.company.swaglabs.pages.YourCartPage.*;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;

public class YourCart extends BaseTest {
    @BeforeMethod
    public void goToYourCartPage() {
        new LoginPage().login();
        BasePage basePage = new BasePage();
        new HomePageClass(getDriver());
        basePage.getHeader().clickOnShopContainer();
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
        Assert.assertTrue(continueButtonIsDisplayed());
    }

    @Test
    public void checkOutOverview() {
        new YourCartPage(getDriver());
        checkOutInformation();
        Assert.assertEquals(paymentInfoGetText(), PAYMENTINFO.toString());
        Assert.assertEquals(seuceCartGetText(), SAUCECARD.toString());
        Assert.assertEquals(freePonyExpressGetText(), FREEPONYEXPRESS.toString());
        Assert.assertEquals(shippingInfoText(), SHIPPINGINFO.toString());
    }

    @Test
    public void checkOutInfo() {
        new YourCartPage(getDriver());
        checkOutInformation();
        Assert.assertTrue(paymentInfoIsDisplayed());
        clickToFinishButton();
        Assert.assertTrue(backToHomeIsDisplayed());
        clickTobackToHome();
        Assert.assertTrue((shopContainerIsDisplayed()));
    }


}
