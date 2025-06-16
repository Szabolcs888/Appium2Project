package com.myappium2project.configdata.models.options.browserstack;

/**
 * Data model representing BrowserStack-specific capabilities for Appium tests.
 * <p>
 * Typically used to populate the {@code "bstack:options"} capability when executing tests in the cloud.
 */
public class BrowserStackOptions {
    private String userName;
    private String accessKey;
    private String appiumVersion;
    private String projectName;
    private String buildName;
    private String sessionName;
    private String debug;
    private String deviceName;

    public BrowserStackOptions() {
    }

    public String getUserName() {
        return userName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getAppiumVersion() {
        return appiumVersion;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getBuildName() {
        return buildName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getDebug() {
        return debug;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public String toString() {
        return "BrowserStackOptions{" +
                "userName='" + userName + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", appiumVersion='" + appiumVersion + '\'' +
                ", projectName='" + projectName + '\'' +
                ", buildName='" + buildName + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", debug='" + debug + '\'' +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}