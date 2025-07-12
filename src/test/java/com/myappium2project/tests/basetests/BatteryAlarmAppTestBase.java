package com.myappium2project.tests.basetests;

import com.myappium2project.configdata.enums.TestApp;
import com.myappium2project.configdata.providers.options.appium.AppiumOptionsProvider;
import com.myappium2project.drivers.DriverFactory;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

/**
 * Base test class for tests targeting the Battery Alarm application.
 * <p>
 * Responsible for setting up and tearing down the AndroidDriver specific to Battery Alarm.
 */
public class BatteryAlarmAppTestBase extends BaseTestClass {
    private static final String APP_NAME_LOG = "Battery Alarm app";
    private static final String APP_NAME = TestApp.BATTERYALARM.getName();

    /**
     * Initializes the AndroidDriver for the Battery Alarm app before each test method.
     *
     * @throws MalformedURLException if the Appium server URL is invalid
     */
    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        LOG.info(CommonTestLogMessages.START_APP_LOG, APP_NAME_LOG);
        driver = DriverFactory.createDriver(APP_NAME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Terminates the Battery Alarm app and quits the driver after each test method.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        if (driver != null) {
            driver.terminateApp(AppiumOptionsProvider.getAppiumOptions(APP_NAME).getAppPackage());
            driver.quit();
        }
        LOG.info(CommonTestLogMessages.STOPPED_APP_LOG, APP_NAME_LOG);
    }
}