package com.myappium2project.reporting.extent;

import com.myappium2project.configpaths.MainPaths;
import com.myappium2project.utils.JsonDataReader;

/**
 * Provides a single shared instance of {@link ExtentReportsConfig} loaded from a JSON resource.
 * <p>
 * This configuration includes theming, titles, and system information for ExtentReports.
 */
public final class ExtentReportsConfigProvider {

    private static final ExtentReportsConfig reportConfig =
            JsonDataReader.readJsonFromResource(MainPaths.EXTENT_REPORTS_CONFIG_JSON, ExtentReportsConfig.class);

    private ExtentReportsConfigProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static ExtentReportsConfig get() {
        return reportConfig;
    }
}