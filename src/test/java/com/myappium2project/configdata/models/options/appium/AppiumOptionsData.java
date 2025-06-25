package com.myappium2project.configdata.models.options.appium;

/**
 * Data model representing Appium capabilities for Android (or iOS) test sessions.
 * <p>
 * Typically loaded from JSON files to configure local or cloud-based Appium drivers.
 */
public class AppiumOptionsData {
    private String platformName;
    private String platformVersion;
    private String automationName;
    private String deviceName;
    private String appPackage;
    private String appActivity;
    private String app;
    private String browserName;
    private Boolean noReset;
    private Boolean fullReset;

    /**
     * Default constructor required for JSON deserialization.
     */
    public AppiumOptionsData() {
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public String getApp() {
        return app;
    }

    public String getBrowserName() {
        return browserName;
    }

    public Boolean getNoReset() {
        return noReset;
    }

    public Boolean getFullReset() {
        return fullReset;
    }

    @Override
    public String toString() {
        return "AppiumOptionsData{" +
                "platformName='" + platformName + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", automationName='" + automationName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", appPackage='" + appPackage + '\'' +
                ", appActivity='" + appActivity + '\'' +
                ", app='" + app + '\'' +
                ", browserName='" + browserName + '\'' +
                ", noReset=" + noReset +
                ", fullReset=" + fullReset +
                '}';
    }
}