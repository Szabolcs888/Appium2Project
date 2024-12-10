package com.myappium2project.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

/**
 * Utility class for Appium scroll actions for page classes.
 * This class is not meant to be instantiated.
 */
public final class ScrollUtils {

    public static boolean tryScroll(AndroidDriver driver) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
            return true;
        } catch (NoSuchElementException _) {
            return false;
        }
    }

    private ScrollUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}