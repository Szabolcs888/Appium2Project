package com.myappium2project.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollUtils {

    public static boolean tryScroll(AndroidDriver driver) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}