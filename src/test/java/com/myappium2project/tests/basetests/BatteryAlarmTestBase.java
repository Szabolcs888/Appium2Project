package com.myappium2project.tests.basetests;

import com.myappium2project.appium.options.AppiumOptionsFactory;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BatteryAlarmTestBase extends BaseTestClass {
    private static final String APP_NAME_LOG = "Battery Alarm Apk";

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() throws MalformedURLException {
        LOG.info(CommonTestLogMessages.START_APP_LOG, APP_NAME_LOG);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), AppiumOptionsFactory.getBatteryAlarmApkOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.terminateApp("simple.batttery.alarm");
        driver.quit();
        LOG.info(CommonTestLogMessages.STOPPED_APP_LOG, APP_NAME_LOG);
    }
}