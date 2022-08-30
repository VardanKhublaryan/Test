import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.company.swaglabs.utils.CustomWebDriver.getDriver;
import static com.company.swaglabs.utils.CustomWebDriver.setDriver;

@Test
public class BaseTest {
    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        driverThreadLocal.set(driver);
        getThreadLocalDriver().get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getThreadLocalDriver() {
        return driverThreadLocal.get();
    }

    @AfterMethod
    public void treeUp() {
        if (driver != null) {
            getDriver().quit();
            setDriver(null);
            driverThreadLocal.remove();
        }
    }
}