import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.company.swaglabs.utils.CustomWebDriver.getDriver;
import static com.company.swaglabs.utils.CustomWebDriver.setDriver;

@Test
public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterMethod
    public void treeUp() {
        if (driver != null) {
            getDriver().quit();
            setDriver(null);
        }
    }
}