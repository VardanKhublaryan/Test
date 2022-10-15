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
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        DRIVER_THREAD_LOCAL.set(driver);
        getThreadLocalDriver().get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getThreadLocalDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    @AfterMethod
    public void treeUp() {
        if (driver != null) {
            getDriver().quit();
            setDriver(null);
            DRIVER_THREAD_LOCAL.remove();
        }
    }
}