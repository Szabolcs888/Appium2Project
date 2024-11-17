package com.myappium2project.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.utils.ScreenshotUtils;
import io.appium.java_client.android.AndroidDriver;
import com.myappium2project.logging.ExtentAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;

public class TestListener implements ITestListener {
    private static final Logger LOG = LogManager.getLogger(TestListener.class);
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private String suiteName;

    @Override
    public void onStart(ITestContext context) {
        suiteName = context.getSuite().getName();
        LOG.info("{} test(s) run will start", suiteName);
        extentReports = ExtentAppender.setupExtentReports();
        ExtentAppender.setExtentReports(extentReports);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentAppender.setExtentTest(extentTest);
        LOG.info("Test STARTED: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed");
        ExtentAppender.reset();
        LOG.info("Test PASSED: {}", result.getName());
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
        ExtentAppender.reset();
        LOG.error("Test FAILED: {}", testName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOG.error("Test FAILED with certain success percentage: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped");
        ExtentAppender.reset();
        LOG.info("Test SKIPPED: {}", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        ExtentAppender.reset();
        LOG.info("{} test(s) run completed\n", suiteName);
    }

    private AndroidDriver getDriverFromTestClass(Object testClass) {
        AndroidDriver driver;
        if (testClass instanceof SauceLabApkBaseTest) {
            driver = ((SauceLabApkBaseTest) testClass).getDriver();
            return driver;
        } else if (testClass instanceof ChromeBrowserBaseTest) {
            driver = ((ChromeBrowserBaseTest) testClass).getDriver();
            return driver;
        } else if (testClass instanceof BatteryAlarmBaseTest) {
            driver = ((BatteryAlarmBaseTest) testClass).getDriver();
            return driver;
        } else {
            return null;
        }
    }
}

