import com.company.swaglabs.components.Header;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.company.swaglabs.components.Header.*;
import static com.company.swaglabs.constants.LogInData.*;
import static com.company.swaglabs.pages.LoginPageClass.*;


public class LoginPage extends BaseTest {
    @Test
    public void login() {
        new LoginPageClass(driver);
        loginn(STANDARD_USER, PASSWORD);
        Header.clickOnMenuBar();
        Assert.assertTrue(menuBarIsVisibility(), "going to home page failed");
    }

    @Test
    public void iconAndLogo() {
        new LoginPageClass(driver);
        Assert.assertTrue(loginPageIconVisibilityOf(), "icon not displayed");
        Assert.assertTrue(logoVisibilityOf(), "logo is not displayed");
        zoomOut();
    }

    @Test
    public void zoomOutPage() {
        new LoginPageClass(driver);
        zoomOut();
    }

    @Test
    public void lockedOutUser() {
        new LoginPageClass(driver);
        loginn(LOCKED_OUT_USER, PASSWORD);
        Assert.assertEquals(getErrorMsg(), "Epic sadface: Sorry, this user has been locked out.", "error message is not displayed");
    }
}
