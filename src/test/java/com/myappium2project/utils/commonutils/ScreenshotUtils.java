package com.myappium2project.utils.commonutils;

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
 * Utility class for screenshot actions.
 * This class is not meant to be instantiated.
 */
public final class ScreenshotUtils {
    private static final Logger LOG = LogManager.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void captureAndSaveScreenshot(AndroidDriver driver, String testName) {
        String screenshotPath = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + testName + ".png";
        String actualReportScreenshotPath = System.getProperty("user.dir") + "/reports/actualReportScreenshots/" + testName + ".png";
        takeScreenshot(driver, screenshotPath, actualReportScreenshotPath);
    }

    public static String getScreenshotUrl(String testName) {
        return "https://appiumreports.netlify.app/actualReportScreenshots/" + testName + ".png";
    }

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