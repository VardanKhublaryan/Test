import com.company.swaglabs.components.Header;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.company.swaglabs.components.Header.menuBarIsVisibility;
import static com.company.swaglabs.constants.LogInData.*;
import static com.company.swaglabs.pages.LoginPageClass.*;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;


public class LoginPage extends BaseTest {

    @Test
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
    }

    @Test
    public void lockedOutUser() {
        new LoginPageClass(getDriver());
        loginn(LOCKED_OUT_USER, PASSWORD);
        Assert.assertEquals(getErrorMsg(), "Epic sadface: Sorry, this user has been locked out.", "error message is not displayed");
        Assert.assertEquals(getErrorColor(), "#e2231a");
    }

    @Test
    public void performanceGlitchUser() {
        new LoginPageClass(getDriver());
        loginn(PERFORMANCE_GLITCH_USER, PASSWORD);
        Header.clickOnMenuBar();
        Assert.assertTrue(menuBarIsVisibility(), "going to home page failed");
    }

    @Test
    public void invalidUser() {
        new LoginPageClass(getDriver());
        loginn(INVALID_LOGIN, INVALID_PASS);
        Assert.assertEquals(getLoginButtonErrorText(), INVALID_USER_ERROR.toString());
        Assert.assertEquals(getErrorColor(), "#e2231a");
    }

    @Test
    public void loginWithoutPassword() {
        new LoginPageClass(getDriver());
        loginWithOutPass(STANDARD_USER);
        Assert.assertEquals(getLoginButtonErrorText(), WITH_OUT_PASS_ERROR.toString());
        Assert.assertEquals(getErrorColor(), "#e2231a");
    }

    @Test
    public void loginWithoutUserName(){
        new LoginPageClass(getDriver());
        loginWithOutUserName(PASSWORD);
        Assert.assertEquals(getLoginButtonErrorText(),WITH_OUT_USER_NAME_ERROR.toString());
        Assert.assertEquals(getErrorColor(),"#e2231a");
    }
}
