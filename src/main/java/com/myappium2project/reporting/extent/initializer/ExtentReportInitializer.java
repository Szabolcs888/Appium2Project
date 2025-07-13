package com.myappium2project.reporting.extent.initializer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myappium2project.configpaths.MainPaths;
import com.myappium2project.reporting.extent.config.ExtentReportsConfig;
import com.myappium2project.reporting.extent.config.ExtentReportsConfigProvider;

import java.util.Locale;

public final class ExtentReportInitializer {

    private ExtentReportInitializer() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Initializes and configures the {@link ExtentReports} instance using external JSON-based settings.
     * <p>
     * Loads configuration values such as theme, document title, report name, and system information
     * from the JSON file defined in {@link com.myappium2project.configpaths.MainPaths}.
     * <p>
     * This class is responsible solely for the creation of a fully configured {@code ExtentReports} object.
     *
     * @return the configured {@link ExtentReports} instance
     */
    public static ExtentReports create() {
        String reportPath = MainPaths.EXTENT_REPORT_FILE_PATH.toString();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        ExtentReportsConfig config = ExtentReportsConfigProvider.get();
        Theme theme = Theme.valueOf(config.getTheme().toUpperCase(Locale.ENGLISH));
        sparkReporter.config().setTheme(theme);
        sparkReporter.config().setDocumentTitle(config.getDocumentTitle());
        sparkReporter.config().setReportName(config.getReportName());

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        config.getSystemInfo().forEach(extentReports::setSystemInfo);

        return extentReports;
    }
}