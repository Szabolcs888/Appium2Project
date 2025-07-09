package com.myappium2project.configkeys;

/**
 * Enum representing the supported keys found in the {@code config.properties} file.
 * <p>
 * This centralizes all valid configuration keys used in the framework,
 * ensuring type safety and reducing errors from hardcoded strings.
 */
public enum ConfigDataKeys {
    APPIUM_PORT("appium.port"),
    APPIUM_IP_ADDRESS("appium.ip.address"),
    APPIUM_LOCAL_URL("appium.local.url"),
    APPIUM_CLOUD_URL("appium.cloud.url"),
    LOG_BASE_DIRECTORY("log.base.directory"),
    APPIUM_SERVER_LOG_SUBDIRECTORY("appium.server.log.subdirectory"),
    APPIUM_SERVER_LOG_FILENAME_PREFIX("appium.server.log.filename.prefix"),
    APPIUM_SERVER_LOG_LEVEL("appium.server.log.level"),
    NETLIFY_DEPLOY_COMMAND_PREFIX("netlify.deploy.command.prefix"),
    BASH_EXECUTABLE_PATH("bash.executable.path"),
    REPORT_NETLIFY_URL("report.netlify.url"),
    REPORT_NETLIFY_SCREENSHOTS_URL("report.netlify.screenshots.url"),
    RUN_ENVIRONMENT("run.environment"),
    BROWSER_TYPE("browser.type");

    private final String key;

    ConfigDataKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}