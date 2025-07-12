package com.myappium2project.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myappium2project.reporting.email.models.TestResult;
import com.myappium2project.reporting.extent.initializer.ExtentReportInitializer;
import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.utils.common.ScreenshotUtils;
import com.myappium2project.utils.common.TestRunContextHolder;
import io.appium.java_client.android.AndroidDriver;
import com.myappium2project.logging.appenders.ExtentAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.myappium2project.tests.basetests.BatteryAlarmAppTestBase;
import com.myappium2project.tests.basetests.BrowserTestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * TestNG listener class that handles test execution events such as start, success, failure, and finish.
 * <p>
 * Responsibilities include:
 * <ul>
 *     <li>Initializing and flushing ExtentReports</li>
 *     <li>Capturing screenshots on failure</li>
 *     <li>Logging test results to console and summary log</li>
 *     <li>Collecting results for email report generation</li>
 * </ul>
 */
public class TestListener implements ITestListener {
    private static final Logger LOG = LogManager.getLogger(TestListener.class);
    private static final Logger SUMMARY_LOG = LogManager.getLogger("summaryLogger");
    private static final List<TestResult> emailReportResults = new ArrayList<>();
    private String currentSuiteName;
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    /**
     * Called before any test methods are run in the suite.
     * <p>
     * Initializes the {@link ExtentReports} instance and stores the suite name
     * in the {@link TestRunContextHolder} for use later in the test lifecycle
     * (e.g., for reporting and logging purposes).
     */
    @Override
    public void onStart(ITestContext context) {
        currentSuiteName = context.getSuite().getName();
        TestRunContextHolder.setSuiteName(currentSuiteName);

        LOG.info("{} test(s) run will start", currentSuiteName);
        extentReports = ExtentReportInitializer.create();
    }

    /**
     * Called before each test method.
     * Starts a new ExtentTest instance for logging.
     */
    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentAppender.setExtentTest(extentTest);
        LOG.info("Test STARTED: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Passed");
        ExtentAppender.setExtentTest(null);

        emailReportResults.add(buildEmailTestResult(result, "PASS"));
        LOG.info("Test PASSED: {}", result.getName());
    }

    /**
     * Called when a test method fails.
     * Captures a screenshot, attaches it to the report, and logs the failure.
     */
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

        emailReportResults.add(buildEmailTestResult(result, "FAIL"));
        LOG.error("Test FAILED: {}", testName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOG.error("Test FAILED with certain success percentage: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped");
        ExtentAppender.setExtentTest(null);

        emailReportResults.add(buildEmailTestResult(result, "SKIP"));
        LOG.info("Test SKIPPED: {}", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        ExtentAppender.setExtentTest(null);
        LOG.info("{} test(s) run completed{}", currentSuiteName, System.lineSeparator());

        logSummary(context);
    }

    /**
     * Extracts the {@link AndroidDriver} instance from the base test class
     * depending on which application is being tested.
     *
     * @param testClass the test class instance
     * @return the AndroidDriver or null if unknown base type
     */
    private AndroidDriver getDriverFromTestClass(Object testClass) {
        AndroidDriver driver;
        if (testClass instanceof SauceLabsAppTestBase) {
            driver = ((SauceLabsAppTestBase) testClass).getDriver();
            return driver;
        } else if (testClass instanceof BrowserTestBase) {
            driver = ((BrowserTestBase) testClass).getDriver();
            return driver;
        } else if (testClass instanceof BatteryAlarmAppTestBase) {
            driver = ((BatteryAlarmAppTestBase) testClass).getDriver();
            return driver;
        } else {
            return null;
        }
    }

    /**
     * Builds a {@link TestResult} object specifically for use in the HTML-formatted email report.
     * <p>
     * Extracts and formats relevant test metadata including:
     * <ul>
     *     <li>Test method name</li>
     *     <li>Test class and application package</li>
     *     <li>Execution status (PASS, FAIL, SKIP)</li>
     *     <li>Duration in seconds (formatted and raw)</li>
     * </ul>
     *
     * @param result the TestNG {@link ITestResult} object containing raw test information
     * @param status the execution status to be shown in the email report
     * @return a formatted {@link TestResult} used in the email report builder
     */
    private TestResult buildEmailTestResult(ITestResult result, String status) {
        Class<?> clazz = result.getTestClass().getRealClass();
        String testName = result.getName();
        String className = clazz.getSimpleName();
        String packageName = clazz.getPackageName();
        String appPackage = packageName.replaceFirst("^.*\\.tests\\.", "");
        String combined = appPackage + "." + className;

        long millis = result.getEndMillis() - result.getStartMillis();
        double durationSeconds = millis / 1000.0;
        String durationFormatted = String.format("%.2f s", durationSeconds);

        return new TestResult(testName, combined, status, durationFormatted, durationSeconds);
    }

    /**
     * Logs a summary of the test suite execution, including total,
     * passed, failed, and skipped test counts.
     * <p>
     * The output is written to the summary log file (not the console),
     * using the {@code summaryLogger} configured in Log4j.
     *
     * @param context the TestNG test context containing result statistics
     */
    private void logSummary(ITestContext context) {
        int numberOfTests = context.getAllTestMethods().length;
        int numberOfPassedTests = context.getPassedTests().size();
        int numberOfFailedTests = context.getFailedTests().size();
        int numberOfSkippedTests = context.getSkippedTests().size();

        SUMMARY_LOG.info("===============================================");
        SUMMARY_LOG.info(currentSuiteName);
        SUMMARY_LOG.info("Total tests run: {}, Passes: {}, Failures: {}, Skips: {}",
                numberOfTests, numberOfPassedTests, numberOfFailedTests, numberOfSkippedTests);
        SUMMARY_LOG.info("===============================================");
    }

    public static List<TestResult> getResults() {
        return new ArrayList<>(emailReportResults);
    }
}