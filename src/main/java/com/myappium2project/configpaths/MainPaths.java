package com.myappium2project.configpaths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility class providing centralized definitions of commonly used file and directory paths.
 * <p>
 * These paths include:
 * <ul>
 *   <li>Log directories for test execution and Appium server</li>
 *   <li>Report output locations and configuration</li>
 *   <li>Screenshot storage for HTML reports</li>
 *   <li>External configuration files located on the classpath (e.g., ExtentReports, SendGrid)</li>
 * </ul>
 * Paths are resolved either as {@link Path} relative to the project root ({@code user.dir}),
 * or as {@link String} for classpath resource references.
 */
public final class MainPaths {
    public static final Path USER_DIR = Paths.get(System.getProperty("user.dir")).toAbsolutePath();

    // Logs
    public static final Path LOGS_DIR_PATH = USER_DIR.resolve("logs");
    public static final Path TEST_RUN_LOGS_DIR_PATH = LOGS_DIR_PATH.resolve("test-run");
    public static final Path APPIUM_SERVER_LOGS_DIR_PATH = LOGS_DIR_PATH.resolve("appium-server");

    // Reports
    public static final String EXTENT_REPORTS_CONFIG_JSON = "reporting/extent-reports_config.json";
    public static final Path REPORTS_DIR_PATH = USER_DIR.resolve("reports");
    public static final Path EXTENT_REPORT_FILE_PATH = USER_DIR.resolve("reports/extent-report.html");
    public static final Path ACTUAL_REPORT_SCREENSHOT_PATH = USER_DIR.resolve("reports/actualReportScreenshots");

    // Test resources
    public static final Path ORIGINAL_REPORT_SCREENSHOT_PATH = USER_DIR.resolve("src/test/resources/screenshots");

    // Email configs
    public static final String SENDGRID_CREDENTIALS_JSON = "emailsendingdata/sendgrid_account.json";

    private MainPaths() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}