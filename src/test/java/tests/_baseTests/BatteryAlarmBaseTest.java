package tests._baseTests;

import driver.AppiumOptionsFactory;
import listeners.TestListener;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners(TestListener.class)
public class BatteryAlarmBaseTest extends BaseTestParent {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        log.info("------- Start: Battery Alarm Apk -------");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), AppiumOptionsFactory.getBatteryAlarmApkOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.terminateApp("simple.batttery.alarm");
        if (driver != null) {
            driver.quit();
        }
        log.info("------- Stopped: Battery Alarm Apk -------\n");
    }
}
