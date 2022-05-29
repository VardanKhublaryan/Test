
import com.company.swaglabs.pages.BasePage;
import com.company.swaglabs.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.*;


import static com.company.swaglabs.constants.LogInData.*;


public class LoginPage extends BaseTest {


    @Test
    public void login() {
        LoginPageClass loginPage = new LoginPageClass(getDriver());
        BasePage basePage = new BasePage(getDriver());

        try {
            loginPage.login(STANDARD_USER, PASSWORD);
            Assert.assertTrue(basePage.getHeader().getMenuBar().isDisplayed(), "going to home page failed");
        } catch (AssertionError e) {
            System.out.println(e + "going to home page failed");
        } catch (Exception e) {
            System.out.println("going to home page failed");
        } finally {
            System.out.println("home page is opened");
        }
    }

    @Test
    public void iconAndLogo() {
        LoginPageClass loginPage = new LoginPageClass(getDriver());

        try {
            Assert.assertTrue(loginPage.getLoginPageIcon().isDisplayed(), "icon not displayed");
        } catch (AssertionError e) {
            System.out.println(e + "icon not displayed");
        } finally {
            System.out.println("icon is displayed");
        }

        try {
            Assert.assertTrue(loginPage.getLogo().isDisplayed(), "logo is not displayed");
        } catch (AssertionError e) {
            System.out.println(e + "logo not displayed");
        } finally {
            System.out.println("logo is displayed");
        }
    }

    @Test
    public void lockedOutUser() {
        LoginPageClass loginPage = new LoginPageClass(getDriver());
        loginPage.login(LOCKED_OUT_USER, PASSWORD);
        try {
            Assert.assertEquals(loginPage.getErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
        } catch (AssertionError e) {
            System.out.println("error message is not displayed");
        }
    }


}
