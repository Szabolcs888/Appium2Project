package com.myappium2project.appium.options;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;

/**
 * A utility class for generating various Appium configuration options.
 * This class is not meant to be instantiated and provides static methods
 * for obtaining pre-configured UiAutomator2Options for different scenarios.
 */
public final class AppiumOptionsFactory {

    public static UiAutomator2Options getSauceLabApkOptions() {
        ClassLoader classLoader = AppiumOptionsFactory.class.getClassLoader();
        File file = new File(classLoader.getResource("apks/Android-MyDemoAppRN.1.3.0.build-244.apk").getFile());
        String apkPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setPlatformVersion("10")
                .setAutomationName("UIAutomator2")
                .setDeviceName("17fad31f")
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity")
                .setApp(apkPath)
                //.setFullReset(true)
                .setNoReset(true);
        return options;
    }

    public static UiAutomator2Options getBatteryAlarmApkOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setPlatformVersion("10")
                .setAutomationName("UIAutomator2")
                .setDeviceName("17fad31f")
                .setAppPackage("simple.batttery.alarm")
                .setAppActivity(".main")
                //.setFullReset(true)
                .setNoReset(true);
        return options;
    }

    public static UiAutomator2Options getChromeOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("Android")
                .setPlatformVersion("10")
                .setAutomationName("UIAutomator2")
                .setDeviceName("17fad31f")
                .noReset()
                .withBrowserName("Chrome");
        return options;
    }

    private AppiumOptionsFactory() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}