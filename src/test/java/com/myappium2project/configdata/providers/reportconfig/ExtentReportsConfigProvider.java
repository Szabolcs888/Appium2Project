package com.myappium2project.configdata.providers.reportconfig;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.models.reportconfig.ExtentReportsConfig;
import com.myappium2project.utils.JsonDataReader;

/**
 * Provides a single shared instance of {@link ExtentReportsConfig} loaded from a JSON resource.
 * <p>
 * This configuration includes theming, titles, and system information for ExtentReports.
 */
public final class ExtentReportsConfigProvider {

    private static final ExtentReportsConfig reportConfig =
            JsonDataReader.readJsonFromResource(TestPaths.EXTENT_REPORTS_CONFIG_JSON, ExtentReportsConfig.class);

    private ExtentReportsConfigProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static ExtentReportsConfig get() {
        return reportConfig;
    }
}