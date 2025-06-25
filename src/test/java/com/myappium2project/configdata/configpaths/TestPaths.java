package com.myappium2project.configdata.configpaths;

/**
 * Centralized storage for file path constants used in testing.
 * <p>
 * Includes paths to test data, app installers, Appium/BrowserStack configuration files,
 * and reporting templates. These paths typically point to resources on the classpath.
 */
public final class TestPaths {
    // Application account data (per app and platform)
    public static final String CURA_ACCOUNTS_JSON = "testdatafiles/accounts/cura-healthcare_accounts.json";
    public static final String SLABS_ACCOUNTS_JSON = "testdatafiles/accounts/saucelabs_accounts.json";

    // Reporting configuration for ExtentReports
    public static final String EXTENT_REPORTS_CONFIG_JSON = "testdatafiles/reporting/extent-reports_config.json";

    // BrowserStack options
    public static final String BS_CHROME_OPTIONS_JSON = "testdatafiles/options/browserstack/chrome_bs-options.json";
    public static final String BS_SAUCELABS_OPTIONS_JSON = "testdatafiles/options/browserstack/saucelabs_bs-options.json";

    // Appium options
    public static final String APPIUM_SAUCELABS_LOCAL_OPTIONS_JSON = "testdatafiles/options/appium/local/saucelabs-local_appium-options.json";
    public static final String APPIUM_SAUCELABS_CLOUD_OPTIONS_JSON = "testdatafiles/options/appium/cloud/saucelabs-cloud_appium-options.json";
    public static final String APPIUM_CHROME_LOCAL_OPTIONS_JSON = "testdatafiles/options/appium/local/chrome-local_appium-options.json";
    public static final String APPIUM_CHROME_CLOUD_OPTIONS_JSON = "testdatafiles/options/appium/cloud/chrome-cloud_appium-options.json";
    public static final String APPIUM_FIREFOX_LOCAL_OPTIONS_JSON = "testdatafiles/options/appium/local/firefox-local_appium-options.json";
    public static final String APPIUM_BATTERYALARM_OPTIONS_JSON = "testdatafiles/options/appium/local/batteryalarm-local_appium-options.json";

    // Login test data for Cura web app (used in DataProvider-based tests)
    public static final String CURA_HEALTHCARE_DATA_PROVIDER_LOGIN_DATA_JSON = "testdatafiles/testinputs/cura-healthcare-login-data_data-provider-test.json";

    // Sauce Labs demo app apk
    public static final String SAUCELABS_LOCAL_ANDROID_APK = "appinstallers/Android-MyDemoAppRN.1.3.0.build-244.apk";

    private TestPaths() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}