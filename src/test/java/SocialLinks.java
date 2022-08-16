
import com.company.swaglabs.pages.LoginPageClass;
import com.company.swaglabs.pages.SocialLinksClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.company.swaglabs.constants.LogInData.PASSWORD;
import static com.company.swaglabs.constants.LogInData.STANDARD_USER;
import static com.company.swaglabs.pages.LoginPageClass.loginn;
import static com.company.swaglabs.utils.CustomWebDriver.getDriver;
@Test
public class SocialLinks extends BaseTest{


    @BeforeMethod
    public void login() {
        new LoginPageClass(getDriver());
        loginn(STANDARD_USER, PASSWORD);
    }


    @Test
    public void twitter() {
        SocialLinksClass socialLinksClass = new SocialLinksClass(getDriver());
        socialLinksClass.clickOnTwitter();
        Assert.assertTrue(socialLinksClass.twitterLogoIsDisplayed());
    }

    @Test
    public void facebook() {
        SocialLinksClass socialLinksClass = new SocialLinksClass(getDriver());
        socialLinksClass.clickOnFacebook();
        Assert.assertTrue(socialLinksClass.facebookIsDisplayed());
    }

    @Test
    public void linkedIn() {
        SocialLinksClass socialLinksClass = new SocialLinksClass(getDriver());
        socialLinksClass.clickOnLinkedIn();
        Assert.assertTrue(socialLinksClass.linkedInIsDisplayed());
    }
}
