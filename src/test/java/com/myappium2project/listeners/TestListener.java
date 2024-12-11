package com.myappium2project.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myappium2project.tests.basetests.SauceLabApkTestBase;
import com.myappium2project.utils.commonutils.ScreenshotUtils;
import io.appium.java_client.android.AndroidDriver;
import com.myappium2project.logging.appenders.ExtentAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.myappium2project.tests.basetests.BatteryAlarmTestBase;
import com.myappium2project.tests.basetests.ChromeBrowserTestBase;

/**
 * Implements TestNG's {@link org.testng.ITestListener} interface to listen to test events.
 * Handles test lifecycle events such as start, success, failure, and finish, enabling
 * logging and other necessary actions during test execution.
 */
public class TestListener implements ITestListener {
    private static final Logger LOG = LogManager.getLogger(TestListener.class);
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private String suiteName;

    @Override
    public void onStart(ITestContext context) {
        suiteName = context.getSuite().getName();
        LOG.info("{} test(s) run will start", suiteName);
        extentReports = ExtentAppender.setupExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentAppender.setExtentTest(extentTest);
        if (LOG.isInfoEnabled()) {
            LOG.info("Test STARTED: {}", result.getName());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed");
        ExtentAppender.setExtentTest(null);
        if (LOG.isInfoEnabled()) {
            LOG.info("Test PASSED: {}", result.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        AndroidDriver driver = getDriverFromTestClass(testClass);
        String testName = result.getName();

        ScreenshotUtils.captureAndSaveScreenshot(driver, testName);
        String screenshotUrl = ScreenshotUtils.getScreenshotUrl(testName);
        extentTest.addScreenCaptureFromPath(screenshotUrl, "Screenshot");

        extentTest.log(Status.FAIL, "Test Failed");
        ExtentAppender.setExtentTest(null);
        LOG.error("Test FAILED: {}", testName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        if (LOG.isErrorEnabled()) {
            LOG.error("Test FAILED with certain success percentage: {}", result.getName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped");
        ExtentAppender.setExtentTest(null);
        if (LOG.isInfoEnabled()) {
            LOG.info("Test SKIPPED: {}", result.getName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        ExtentAppender.setExtentTest(null);
        LOG.info("{} test(s) run completed" + System.lineSeparator(), suiteName);

        int numberOfTests = context.getAllTestMethods().length;
        int numberOfPassedTests = context.getPassedTests().size();
        int numberOfFailedTests = context.getFailedTests().size();
        int numberOfSkippedTests = context.getSkippedTests().size();
        LOG.info("===============================================");
        LOG.info(suiteName);
        LOG.info("Total tests run: {}, Passes: {}, Failures: {}, Skips: {}",
                numberOfTests, numberOfPassedTests, numberOfFailedTests, numberOfSkippedTests);
        LOG.info("===============================================");
    }

    private AndroidDriver getDriverFromTestClass(Object testClass) {
        AndroidDriver driver;
        if (testClass instanceof SauceLabApkTestBase) {
            driver = ((SauceLabApkTestBase) testClass).getDriver();
            return driver;
        } else if (testClass instanceof ChromeBrowserTestBase) {
            driver = ((ChromeBrowserTestBase) testClass).getDriver();
            return driver;
        } else if (testClass instanceof BatteryAlarmTestBase) {
            driver = ((BatteryAlarmTestBase) testClass).getDriver();
            return driver;
        } else {
            return null;
        }
    }
}