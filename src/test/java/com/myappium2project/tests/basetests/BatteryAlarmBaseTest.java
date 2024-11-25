package com.myappium2project.tests.basetests;

import com.myappium2project.driver.AppiumOptionsFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BatteryAlarmBaseTest extends BaseTestParent {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        LOG.info("------- Start: Battery Alarm Apk -------");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), AppiumOptionsFactory.getBatteryAlarmApkOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.terminateApp("simple.batttery.alarm");
        if (driver != null) {
            driver.quit();
        }
        LOG.info("------- Stopped: Battery Alarm Apk -------\n");
    }
}