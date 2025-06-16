package com.myappium2project.configdata.builders.appiumoptions;

import com.myappium2project.configdata.enums.TestApp;
import com.myappium2project.configdata.models.options.appium.AppiumOptionsData;
import com.myappium2project.configdata.providers.options.appium.AppiumOptionsProvider;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Provides Appium {@link UiAutomator2Options} configuration for the Battery Alarm app.
 * <p>
 * This app is only tested locally, as it is available solely via the Play Store
 * and its versions may change over time.
 */
public class BatteryAlarmAppOptionsBuilder {

    private BatteryAlarmAppOptionsBuilder() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Builds a {@link UiAutomator2Options} object for local testing of the Battery Alarm Android app.
     * <p>
     * Uses configuration values loaded from {@link AppiumOptionsProvider} based on the {@link TestApp#BATTERYALARM} key.
     *
     * @return a fully configured {@code UiAutomator2Options} instance
     */
    public static UiAutomator2Options getBatteryAlarmAppLocalOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        AppiumOptionsData optionsData = AppiumOptionsProvider.getAppiumOptions(TestApp.BATTERYALARM.getName());
        options.setPlatformName(optionsData.getPlatformName())
                .setPlatformVersion(optionsData.getPlatformVersion())
                .setAutomationName(optionsData.getAutomationName())
                .setDeviceName(optionsData.getDeviceName())
                .setAppPackage(optionsData.getAppPackage())
                .setAppActivity(optionsData.getAppActivity())
                .setNoReset(optionsData.getNoReset());
        return options;
    }
}