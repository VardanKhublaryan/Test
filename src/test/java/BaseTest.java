import com.company.swaglabs.utils.CustomWebDriver;
import com.company.swaglabs.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.time.Duration;

@Test
public class BaseTest {
    WebDriver driver = CustomWebDriver.getDriver();
    protected static ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<WebDriver>();


    @BeforeMethod
    public void setUp() {
        threadLocalDriver.set(driver);
        WaitHelper.waitForJStoLoad();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @AfterSuite
    public void treeUp() {
        driver.quit();
        threadLocalDriver.remove();
    }
}
