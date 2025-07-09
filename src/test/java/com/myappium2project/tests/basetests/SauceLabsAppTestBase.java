package com.myappium2project.tests.basetests;

import com.myappium2project.configdata.enums.TestApp;
import com.myappium2project.configdata.providers.options.appium.AppiumOptionsProvider;
import com.myappium2project.drivers.DriverFactory;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

/**
 * Base class for all tests related to the Sauce Labs demo app.
 * <p>
 * Handles driver creation and teardown specifically for the Sauce Labs application.
 * Uses {@link DriverFactory} to initialize the driver and sets up basic timeouts.
 */
public class SauceLabsAppTestBase extends BaseTestClass {
    private static final String APP_NAME_LOG = "SauceLabs app";
    private static final String APP_NAME = TestApp.SAUCELABS.getName();

    /**
     * Initializes the AndroidDriver before each test method for the Sauce Labs app.
     *
     * @throws MalformedURLException if the Appium server URL is malformed
     */
    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        LOG.info(CommonTestLogMessages.START_APP_LOG, APP_NAME_LOG);
        driver = DriverFactory.createDriver(APP_NAME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Terminates the Sauce Labs app and quits the driver after each test method.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.terminateApp(AppiumOptionsProvider.getAppiumOptions(APP_NAME).getAppPackage());
        if (driver != null) {
            driver.quit();
        }
        LOG.info(CommonTestLogMessages.STOPPED_APP_LOG, APP_NAME_LOG);
    }
}