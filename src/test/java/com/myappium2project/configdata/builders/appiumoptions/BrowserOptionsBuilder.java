package com.myappium2project.configdata.builders.appiumoptions;

import com.myappium2project.configdata.models.options.appium.AppiumOptionsData;
import com.myappium2project.configdata.models.options.browserstack.BrowserStackOptions;
import com.myappium2project.configdata.providers.options.appium.AppiumOptionsProvider;
import com.myappium2project.configdata.providers.options.browserstack.BrowserStackOptionsProvider;
import com.myappium2project.utils.common.BrowserStackCapabilityMapper;
import io.appium.java_client.android.options.UiAutomator2Options;

/**
 * Builds Appium {@link UiAutomator2Options} configurations for web browser testing on Android devices.
 * <p>
 * Supports both local and cloud-based testing (e.g. BrowserStack), using data from {@link AppiumOptionsProvider}.
 */
public final class BrowserOptionsBuilder {

    private BrowserOptionsBuilder() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Creates Appium options for local Android browser testing.
     *
     * @param browserName the name of the browser (e.g. "chrome")
     * @return configured {@link UiAutomator2Options} for local test execution
     */
    public static UiAutomator2Options getBrowserLocalOptions(String browserName) {
        UiAutomator2Options options = new UiAutomator2Options();
        AppiumOptionsData optionsData = AppiumOptionsProvider.getAppiumOptions(browserName);

        options.setPlatformName(optionsData.getPlatformName())
                .setPlatformVersion(optionsData.getPlatformVersion())
                .setAutomationName(optionsData.getAutomationName())
                .setDeviceName(optionsData.getDeviceName())
                .withBrowserName(optionsData.getBrowserName())
                .setNoReset(optionsData.getNoReset());
        return options;
    }

    /**
     * Creates Appium options for cloud-based Android browser testing (e.g. on BrowserStack).
     * <p>
     * Includes {@code "bstack:options"} capabilities if applicable.
     *
     * @param browserName the name of the browser (e.g. "chrome")
     * @return configured {@link UiAutomator2Options} for cloud test execution
     */
    public static UiAutomator2Options getBrowserCloudOptions(String browserName) {
        UiAutomator2Options options = new UiAutomator2Options();
        AppiumOptionsData optionsData = AppiumOptionsProvider.getAppiumOptions(browserName);

        BrowserStackOptions browserStackOptions = switch (browserName) {
            case "chrome" -> BrowserStackOptionsProvider.getChromeOptions();
         // case "firefox" -> BrowserStackOptionsProvider.getFirefoxOptions(); // Future expansion potential
            default -> null;
        };

        options.setPlatformName(optionsData.getPlatformName())
                .setPlatformVersion(optionsData.getPlatformVersion())
                .setAutomationName(optionsData.getAutomationName())
                .setDeviceName(optionsData.getDeviceName())
                .setCapability("browserName", optionsData.getBrowserName());
        options.setCapability("bstack:options", BrowserStackCapabilityMapper.buildFrom(browserStackOptions));

     // System.out.println("Final Capabilities sent to BrowserStack: " + options.asMap()); // Very useful for debugging!
        return options;
    }
}