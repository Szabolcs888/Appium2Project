package com.myappium2project.tests.basetests;

import com.myappium2project.email.SendGridEmailHelper;
import io.appium.java_client.android.AndroidDriver;
import com.myappium2project.listeners.TestListener;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.myappium2project.server.AppiumServerFromCode;
import com.myappium2project.server.NetlifyUploader;
import com.myappium2project.utils.CommonUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Listeners(TestListener.class)
public class BaseTestParent {
    static {
        Configurator.setLevel("org.testng.internal.Utils", Level.OFF);
    }

    protected Logger LOG;
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private AppiumServerFromCode appiumServerFromCode = new AppiumServerFromCode();
    private static String testStartDateTime;

    public AndroidDriver getDriver() {
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        Configurator.initialize(null, "config/log4j2.properties");
        appiumServerFromCode.startAppiumServer();
        CommonUtils.cleanReportsAndScreenshots();
        testStartDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss"));
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        LOG = LogManager.getLogger(this.getClass());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        String testEndDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss"));
        appiumServerFromCode.stopAppiumServer();
        executePostSuiteActions(testStartDateTime, testEndDateTime);
    }

    private static void executePostSuiteActions(String testStartDateTime, String testEndDateTime) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            CommonUtils.threadSleep(1000);
            CommonUtils.copyFile(
                    "target/surefire-reports/emailable-report.html",
                    "reports/emailable-report.html");
            NetlifyUploader.uploadReportToNetlify();
            SendGridEmailHelper sendGridEmailHelper = new SendGridEmailHelper();
            sendGridEmailHelper.sendEmailWithReport(testStartDateTime, testEndDateTime);
        }));
    }
}
