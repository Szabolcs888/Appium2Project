package com.myappium2project.configdata.builders.appiumoptions;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.enums.TestApp;
import com.myappium2project.configdata.models.options.appium.AppiumOptionsData;
import com.myappium2project.configdata.models.options.browserstack.BrowserStackOptions;
import com.myappium2project.configdata.providers.options.appium.AppiumOptionsProvider;
import com.myappium2project.configdata.providers.options.browserstack.BrowserStackOptionsProvider;
import com.myappium2project.utils.common.BrowserStackCapabilityMapper;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;

/**
 * Provides Appium {@link UiAutomator2Options} configurations for running tests on the SauceLabs demo app.
 * <p>
 * Supports both local Android and cloud-based Android testing (e.g. via BrowserStack).
 * Configuration values are loaded via {@link AppiumOptionsProvider} and augmented with cloud-specific capabilities when needed.
 */
public class SauceLabsAppOptionsBuilder {
    private static final String APP_NAME = TestApp.SAUCELABS.getName();

    private SauceLabsAppOptionsBuilder() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Builds {@link UiAutomator2Options} for local Android testing of the SauceLabs app.
     * <p>
     * Loads the local APK file from the classpath based on {@link TestPaths#SAUCELABS_LOCAL_ANDROID_APK},
     * and applies additional Appium settings from {@link AppiumOptionsProvider}.
     *
     * @return configured options for local test execution
     */
    public static UiAutomator2Options getSauceLabsAppLocalOptions() {
        ClassLoader classLoader = SauceLabsAppOptionsBuilder.class.getClassLoader();
        File file = new File(classLoader.getResource(TestPaths.SAUCELABS_LOCAL_ANDROID_APK).getFile());
        String apkPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        AppiumOptionsData optionsData = AppiumOptionsProvider.getAppiumOptions(APP_NAME);

        options.setPlatformName(optionsData.getPlatformName())
                .setPlatformVersion(optionsData.getPlatformVersion())
                .setAutomationName(optionsData.getAutomationName())
                .setDeviceName(optionsData.getDeviceName())
                .setAppPackage(optionsData.getAppPackage())
                .setAppActivity(optionsData.getAppActivity())
                .setApp(apkPath)
                .setNoReset(optionsData.getNoReset());
        return options;
    }

    /**
     * Builds {@link UiAutomator2Options} for cloud-based Android testing of the SauceLabs app.
     * <p>
     * Uses the {@code "bstack:options"} capability to configure BrowserStack-specific settings.
     *
     * @return configured options for cloud test execution
     */
    public static UiAutomator2Options getSauceLabsAppCloudOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        AppiumOptionsData optionsData = AppiumOptionsProvider.getAppiumOptions(APP_NAME);
        BrowserStackOptions sauceLabsOptions = BrowserStackOptionsProvider.getSauceLabsOptions();

        options.setPlatformName(optionsData.getPlatformName())
                .setPlatformVersion(optionsData.getPlatformVersion())
                .setAutomationName(optionsData.getAutomationName())
                .setDeviceName(optionsData.getDeviceName())
                .setApp(optionsData.getApp())
                .setCapability("bstack:options", BrowserStackCapabilityMapper.buildFrom(sauceLabsOptions));
        return options;
    }
}