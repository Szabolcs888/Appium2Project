package com.myappium2project.utils.common;

import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.utils.ConfigReader;
import com.myappium2project.configpaths.MainPaths;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for capturing and managing screenshots during test execution.
 * <p>
 * Provides methods to take screenshots using Appium's AndroidDriver, store them
 * in predefined locations, and generate URLs for embedded report views.
 */
public final class ScreenshotUtils {
    private static final Logger LOG = LogManager.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Captures a screenshot using the provided {@link AndroidDriver} and stores
     * it in two predefined locations: the original path and the report path.
     *
     * @param driver   the AndroidDriver instance used to capture the screenshot
     * @param testName the name of the test, used as the screenshot file name
     */
    public static void captureAndSaveScreenshot(AndroidDriver driver, String testName) {
        String screenshotPath = MainPaths.ORIGINAL_REPORT_SCREENSHOT_PATH.resolve(testName + ".png").toString();
        String actualReportScreenshotPath = MainPaths.ACTUAL_REPORT_SCREENSHOT_PATH.resolve(testName + ".png").toString();

        takeScreenshot(driver, screenshotPath, actualReportScreenshotPath);
    }

    /**
     * Generates the Netlify-based URL for accessing the screenshot in a browser.
     *
     * @param testName the name of the test
     * @return the public URL where the screenshot can be viewed
     */
    public static String getScreenshotUrl(String testName) {
        String baseUrl = ConfigReader.get(ConfigDataKeys.REPORT_NETLIFY_SCREENSHOTS_URL.getKey());
        return baseUrl + testName + ".png";
    }

    /**
     * Internal helper method to capture and save the screenshot file to two different paths.
     *
     * @param driver                     the driver used to take the screenshot
     * @param screenshotPath             the original screenshot file path
     * @param actualReportScreenshotPath the secondary path for embedding in the report
     */
    private static void takeScreenshot(AndroidDriver driver, String screenshotPath, String actualReportScreenshotPath) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            FileUtils.copyFile(scrFile, new File(actualReportScreenshotPath));
        } catch (WebDriverException e) {
            LOG.error("Failed to take screenshot due to WebDriver issue", e);
        } catch (IOException e) {
            LOG.error("Failed to save screenshot due to file operation issue", e);
        } catch (ClassCastException e) {
            LOG.error("Driver does not support screenshot capturing", e);
        }
    }
}