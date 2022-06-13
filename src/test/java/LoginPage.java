import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.company.swaglabs.constants.LogInData.*;

public class LoginPage extends BaseTest {

    @Test
    public void login() {
        LoginPageClass loginPage = new LoginPageClass(driver);
        BasePage basePage = new BasePage();
        loginPage.login(STANDARD_USER, PASSWORD);
        basePage.getHeader().clickOnMenuBar();
        Assert.assertTrue(basePage.getHeader().menuBarIsVisibility(), "going to home page failed");
    }

    @Test
    public void iconAndLogo() {
        LoginPageClass loginPage = new LoginPageClass(driver);
        Assert.assertTrue(loginPage.loginPageIconVisibilityOf(), "icon not displayed");
        Assert.assertTrue(loginPage.logoVisibilityOf(), "logo is not displayed");
        loginPage.zoomOut();
    }

    @Test
    public void zoomOut(){
        LoginPageClass loginPage = new LoginPageClass(driver);
        loginPage.zoomOut();
    }

    @Test
    public void lockedOutUser() {
        LoginPageClass loginPage = new LoginPageClass(driver);
        loginPage.login(LOCKED_OUT_USER, PASSWORD);
        Assert.assertEquals(loginPage.getErrorMsg(), "Epic sadface: Sorry, this user has been locked out.", "error message is not displayed");
    }
}
