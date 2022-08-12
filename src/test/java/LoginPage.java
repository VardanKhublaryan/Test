import com.company.swaglabs.components.Header;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.company.swaglabs.components.Header.menuBarIsVisibility;
import static com.company.swaglabs.constants.LogInData.*;
import static com.company.swaglabs.pages.LoginPageClass.*;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;


public class LoginPage extends BaseTest {

    @Test()
    public void login() {
        new LoginPageClass(getDriver());
        loginn(STANDARD_USER, PASSWORD);
        Header.clickOnMenuBar();
        Assert.assertTrue(menuBarIsVisibility(), "going to home page failed");
    }

    @Test
    public void iconAndLogo() {
        new LoginPageClass(getDriver());
        Assert.assertTrue(loginPageIconVisibilityOf(), "icon not displayed");
        Assert.assertTrue(logoVisibilityOf(), "logo is not displayed");
        zoomOut();
    }


    @Test
    public void lockedOutUser() {
        new LoginPageClass(getDriver());
        loginn(LOCKED_OUT_USER, PASSWORD);
        Assert.assertEquals(getErrorMsg(), "Epic sadface: Sorry, this user has been locked out.", "error message is not displayed");
    }
}
