package com.myappium2project.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

import static io.appium.java_client.AppiumBy.androidUIAutomator;

/**
 * Utility class for scroll-related operations using Appium on Android.
 */
public final class ScrollUtils {

    private ScrollUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Attempts to scroll forward within a scrollable view using UiScrollable on Android.
     * <p>
     * If the scroll is possible (i.e. a scrollable element exists), the operation succeeds silently.
     * If not, the method returns {@code false} without throwing an exception.
     *
     * @param driver the active {@link AndroidDriver} instance
     * @return {@code true} if scroll was attempted; {@code false} if no scrollable element was found
     */
    public static boolean attemptScrollForward(AndroidDriver driver) {
        try {
            driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
            return true;
        } catch (NoSuchElementException _) {
            return false;
        }
    }
}