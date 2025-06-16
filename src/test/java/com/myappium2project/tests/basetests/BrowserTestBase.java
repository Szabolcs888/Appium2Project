package com.myappium2project.tests.basetests;

import com.myappium2project.configdata.environment.BrowserConfig;
import com.myappium2project.drivers.DriverFactory;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.utils.StringUtils;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

/**
 * Base test class for browser-based tests (e.g., Chrome, Firefox).
 * <p>
 * Responsible for setting up and tearing down the AndroidDriver configured for browser automation.
 */
public class BrowserTestBase extends BaseTestClass {
    private static final String BROWSER_TYPE = BrowserConfig.getBrowserType().getName();
    private static final String BROWSER_NAME = StringUtils.capitalize(BROWSER_TYPE);
    private static final String APP_NAME_LOG = BROWSER_NAME + " browser";

    /**
     * Initializes the AndroidDriver for the specified browser before each test method.
     *
     * @throws MalformedURLException if the Appium server URL is invalid
     */
    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        LOG.info(CommonTestLogMessages.START_APP_LOG, APP_NAME_LOG);
        driver = DriverFactory.createDriver(BROWSER_TYPE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    /**
     * Quits the browser driver after each test method.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        if (driver != null) {
            driver.quit();
        }
        LOG.info(CommonTestLogMessages.STOPPED_APP_LOG, APP_NAME_LOG);
    }
}