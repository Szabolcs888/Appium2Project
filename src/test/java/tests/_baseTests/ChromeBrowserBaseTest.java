package tests._baseTests;

import driver.AppiumOptionsFactory;
import io.appium.java_client.android.AndroidDriver;
import listeners.TestListener;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners(TestListener.class)
public class ChromeBrowserBaseTest extends BaseTestParent {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        log.info("------- START: Chrome Browser -------");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), AppiumOptionsFactory.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        if (driver != null) {
            driver.quit();
        }
        log.info("------- STOPPED: Chrome Browser -------\n");
    }
}
