package com.myappium2project.drivers;

import com.myappium2project.configdata.builders.appiumoptions.BatteryAlarmAppOptionsBuilder;
import com.myappium2project.configdata.builders.appiumoptions.BrowserOptionsBuilder;
import com.myappium2project.configdata.builders.appiumoptions.SauceLabsAppOptionsBuilder;
import com.myappium2project.configdata.environment.EnvironmentConfig;
import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Factory class for creating configured {@link AndroidDriver} instances
 * based on the app name and execution environment (local or cloud).
 * <p>
 * Supports native apps (e.g., SauceLabs, BatteryAlarm) and mobile browsers (e.g., Chrome, Firefox).
 */
public class DriverFactory {

    private DriverFactory() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Creates and returns an {@link AndroidDriver} instance for the specified app.
     *
     * @param appName the name of the application or browser (e.g., "saucelabs", "batteryalarm", "chrome")
     * @return a configured AndroidDriver instance pointing to the appropriate Appium server
     * @throws MalformedURLException    if the Appium server URL is malformed
     * @throws IllegalArgumentException if the app name is not recognized
     */
    public static AndroidDriver createDriver(String appName) throws MalformedURLException {
        boolean isCloud = EnvironmentConfig.isCloud();
        String appiumLocalUrl = ConfigReader.get(ConfigDataKeys.APPIUM_LOCAL_URL.getKey());
        String appiumCloudUrl = ConfigReader.get(ConfigDataKeys.APPIUM_CLOUD_URL.getKey());
        URL url = isCloud ? new URL(appiumCloudUrl) : new URL(appiumLocalUrl);

        return switch (appName) {
            case "saucelabs" -> createSauceLabsDriver(isCloud, url);
            case "batteryalarm" -> createBatteryAlarmDriver(url);
            case "chrome", "firefox" -> createBrowserDriver(isCloud, url, appName);
            default -> throw new IllegalArgumentException("Unknown app name: " + appName);
        };
    }

    private static AndroidDriver createSauceLabsDriver(boolean isCloud, URL url) {
        return new AndroidDriver(url, isCloud ? SauceLabsAppOptionsBuilder.getSauceLabsAppCloudOptions() : SauceLabsAppOptionsBuilder.getSauceLabsAppLocalOptions());
    }

    private static AndroidDriver createBrowserDriver(boolean isCloud, URL url, String appName) {
        return new AndroidDriver(url, isCloud ? BrowserOptionsBuilder.getBrowserCloudOptions(appName) : BrowserOptionsBuilder.getBrowserLocalOptions(appName));
    }

    private static AndroidDriver createBatteryAlarmDriver(URL url) {
        return new AndroidDriver(url, BatteryAlarmAppOptionsBuilder.getBatteryAlarmAppLocalOptions());
    }
}