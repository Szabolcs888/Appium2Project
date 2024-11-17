package com.myappium2project.tests.basetests;

import com.myappium2project.driver.AppiumOptionsFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeBrowserBaseTest extends BaseTestParent {

    public ChromeBrowserBaseTest() {
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        LOG.info("------- START: Chrome Browser -------");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), AppiumOptionsFactory.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        if (driver != null) {
            driver.quit();
        }
        LOG.info("------- STOPPED: Chrome Browser -------\n");
    }
}
