package tests._baseTests;

import driver.AppiumOptionsFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SauceLabApkBaseTest extends BaseTestParent {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        LOG.info("------- START: Sauce Lab Apk -------");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), AppiumOptionsFactory.getSauceLabApkOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.terminateApp("com.saucelabs.mydemoapp.rn");
        if (driver != null) {
            driver.quit();
        }
        LOG.info("------- STOPPED: Sauce Lab Apk -------\n");
    }
}