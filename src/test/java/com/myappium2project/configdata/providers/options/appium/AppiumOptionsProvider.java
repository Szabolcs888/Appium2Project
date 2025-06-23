package com.myappium2project.configdata.providers.options.appium;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.environment.EnvironmentConfig;
import com.myappium2project.configdata.models.options.appium.AppiumOptionsData;
import com.myappium2project.utils.JsonDataReader;

/**
 * Provides Appium options configuration for different test applications and environments.
 * <p>
 * This class resolves the correct JSON configuration file based on the given app name and the current
 * test environment (local or cloud), and deserializes it into an {@link AppiumOptionsData} object.
 */
public class AppiumOptionsProvider {

    private AppiumOptionsProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Returns the Appium options for the given application, based on the current environment.
     *
     * @param appName the name of the application (e.g., "saucelabs", "batteryalarm", "chrome", "firefox")
     * @return the deserialized {@link AppiumOptionsData} object
     * @throws IllegalArgumentException if the app name is unknown or mapping is missing
     */
    public static AppiumOptionsData getAppiumOptions(String appName) {
        String environment = EnvironmentConfig.getEnvironment().getValue(); // "local" vagy "cloud
        String path = resolveJsonPathForApp(appName, environment);
        AppiumOptionsData optionsData = JsonDataReader.readJsonFromResource(path, AppiumOptionsData.class);
        return optionsData;
    }

    /**
     * Resolves the JSON file path for a specific application and environment.
     *
     * @param appName     the name of the application
     * @param environment the current environment ("local" or "cloud")
     * @return the path to the JSON file
     * @throws IllegalArgumentException if no path mapping exists for the given app
     */
    private static String resolveJsonPathForApp(String appName, String environment) {
        boolean isCloud = "cloud".equals(environment);

        return switch (appName) {
            case "saucelabs" -> isCloud
                    ? TestPaths.APPIUM_SAUCELABS_CLOUD_OPTIONS_JSON
                    : TestPaths.APPIUM_SAUCELABS_LOCAL_OPTIONS_JSON;
            case "batteryalarm" -> TestPaths.APPIUM_BATTERYALARM_OPTIONS_JSON;
            case "chrome" -> isCloud
                    ? TestPaths.APPIUM_CHROME_CLOUD_OPTIONS_JSON
                    : TestPaths.APPIUM_CHROME_LOCAL_OPTIONS_JSON;
            case "firefox" -> TestPaths.APPIUM_FIREFOX_LOCAL_OPTIONS_JSON;
            default -> throw new IllegalArgumentException("Unknown app name: " + appName);
        };
    }
}