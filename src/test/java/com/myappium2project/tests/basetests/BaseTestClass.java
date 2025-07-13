package com.myappium2project.tests.basetests;

import com.myappium2project.configdata.environment.EnvironmentConfig;
import com.myappium2project.email.service.SendGridEmailService;

import com.myappium2project.reporting.email.models.TestResult;
import com.myappium2project.utils.common.TestRunContextHolder;
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
import com.myappium2project.server.AppiumServerManager;
import com.myappium2project.server.NetlifyUploader;
import com.myappium2project.utils.CommonUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Base class for all test classes in the project.
 * <p>
 * Handles common test suite setup and teardown tasks, such as:
 * <ul>
 *   <li>Starting/stopping the Appium server</li>
 *   <li>Cleaning up previous reports and screenshots</li>
 *   <li>Sending test result summaries via email</li>
 *   <li>Uploading the test report to Netlify</li>
 * </ul>
 * <p>
 * Subclasses are expected to initialize the {@code driver} field and may use
 * the provided {@code LOG} and {@code wait} fields.
 */
@Listeners(TestListener.class)
public class BaseTestClass {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");

    static {
        Configurator.setLevel("org.testng.internal.Utils", Level.OFF);
    }

    protected Logger LOG;
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private AppiumServerManager appiumServerManager = new AppiumServerManager();
    private String testStartDateTime;

    /**
     * Sets up the test suite before any tests are run.
     * Starts the Appium server if needed and cleans old reports.
     */
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        appiumServerManager.startFromCodeIfRequired(EnvironmentConfig.isCloud());
        CommonUtils.cleanReportsAndScreenshots();
        testStartDateTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * Initializes the logger for the concrete test class.
     */
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        LOG = LogManager.getLogger(this.getClass());
    }

    /**
     * Finalizes the test suite after all tests have run.
     * <p>
     * Stops the Appium server (if it was started from code),
     * uploads the HTML test report, and sends an email summary.
     * <p>
     * Retrieves the suite name from {@link TestRunContextHolder} as it was
     * set earlier by the test listener, and clears the stored value to avoid
     * memory leaks or unintended reuse in future test runs.
     */
    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        try {
            appiumServerManager.stopIfStartedFromCode();

            String testEndDateTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
            String suiteName = TestRunContextHolder.getSuiteName();
            finalizeTestSuite(testStartDateTime, testEndDateTime, suiteName);
        } finally {
            TestRunContextHolder.clear();
            LOG.debug("Test run context has been cleared.");
        }
    }

    private void finalizeTestSuite(String testStartDateTime, String testEndDateTime, String suiteName) {
        CommonUtils.threadSleep(1000);
        NetlifyUploader.uploadReportToNetlify();

        List<TestResult> results = TestListener.getResults();
        SendGridEmailService.sendEmailWithReport(testStartDateTime, testEndDateTime, suiteName, results);
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}