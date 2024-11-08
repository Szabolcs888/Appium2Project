package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import logging.ExtentAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests._baseTests.BatteryAlarmBaseTest;
import tests._baseTests.ChromeBrowserBaseTest;
import tests._baseTests.SauceLabApkBaseTest;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class);
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    String suiteName;

    @Override
    public void onStart(ITestContext context) {
        suiteName = context.getSuite().getName();
        log.info("{} test(s) run will start", suiteName);
        extentReports = ExtentAppender.setupExtentReports();
        ExtentAppender.setExtentReports(extentReports);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentAppender.setExtentTest(extentTest);
        log.info("Test STARTED: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed");
        ExtentAppender.reset();
        log.info("Test PASSED: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        AndroidDriver driver = getDriverFromTestClass(testClass);

        ScreenshotUtils.captureAndSaveScreenshot(driver, result.getName());
        String screenshotUrl = ScreenshotUtils.getScreenshotUrl(result.getName());
        extentTest.addScreenCaptureFromPath(screenshotUrl, "Screenshot");

        extentTest.log(Status.FAIL, "Test Failed");
        ExtentAppender.reset();
        log.error("Test FAILED: {}", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.error("Test FAILED with certain success percentage: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped");
        ExtentAppender.reset();
        log.info("Test SKIPPED: {}", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        ExtentAppender.reset();
        log.info("{} test(s) run completed\n", suiteName);
    }

    private AndroidDriver getDriverFromTestClass(Object testClass) {
        AndroidDriver driver = null;
        if (testClass instanceof SauceLabApkBaseTest) {
            return driver = ((SauceLabApkBaseTest) testClass).getDriver();
        } else if (testClass instanceof ChromeBrowserBaseTest) {
            return driver = ((ChromeBrowserBaseTest) testClass).getDriver();
        } else if (testClass instanceof BatteryAlarmBaseTest) {
            return driver = ((BatteryAlarmBaseTest) testClass).getDriver();
        } else {
            return null;
        }
    }
}

