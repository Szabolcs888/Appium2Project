package com.myappium2project.utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtils {

    public static void captureAndSaveScreenshot(AndroidDriver driver, String testName) {
        String screenshotPath = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + testName + ".png";
        String actualReportScreenshotPath = System.getProperty("user.dir") + "/reports/actualReportScreenshots/" + testName + ".png";

        takeScreenshot(driver, screenshotPath, actualReportScreenshotPath);
    }

    public static String getScreenshotUrl(String testName) {
        return "https://appiumreports.netlify.app/actualReportScreenshots/" + testName + ".png";
    }

    public static void takeScreenshot(AndroidDriver driver, String screenshotPath, String actualReportScreenshotPath) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            FileUtils.copyFile(scrFile, new File(actualReportScreenshotPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

