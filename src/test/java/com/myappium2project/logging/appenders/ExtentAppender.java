package com.myappium2project.logging.appenders;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myappium2project.configdata.models.reportconfig.ExtentReportsConfig;
import com.myappium2project.configdata.providers.reportconfig.ExtentReportsConfigProvider;
import com.myappium2project.configpaths.MainPaths;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * Custom Log4j2 appender that bridges log events into ExtentReports test entries.
 * <p>
 * This allows test logs (via Log4j) to appear inside ExtentReports for each test method,
 * provided the {@link ExtentTest} context is correctly initialized per test.
 * <p>
 * It is typically used in conjunction with {@link com.myappium2project.listeners.TestListener},
 * which sets up the ExtentReports and injects the current test via {@code setExtentTest()}.
 *
 * <p><b>Note:</b> Logging only works while a test is active and an {@link ExtentTest} instance is available.
 */
@Plugin(name = "ExtentAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public final class ExtentAppender extends AbstractAppender {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    private ExtentAppender(String name, Layout<?> layout) {
        super(name, null, layout, false);
    }

    /**
     * Sets the active {@link ExtentTest} instance for this appender.
     * <p>
     * This method should be called before logging test steps to ensure logs are recorded in the correct test node.
     *
     * @param test the current test instance from ExtentReports
     */
    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }

    /**
     * Initializes and configures the {@link ExtentReports} instance using JSON-based settings.
     * <p>
     * The configuration is loaded from the JSON specified in {@link com.myappium2project.configdata.configpaths.TestPaths}.
     * This includes theme, document title, report name, and system info.
     *
     * @return the configured {@link ExtentReports} instance
     */
    public static ExtentReports setupExtentReports() {
        String reportPath = MainPaths.EXTENT_REPORT_FILE_PATH.toString();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        ExtentReportsConfig config = ExtentReportsConfigProvider.get();
        Theme theme = Theme.valueOf(config.getTheme().toUpperCase());
        sparkReporter.config().setTheme(theme);
        sparkReporter.config().setDocumentTitle(config.getDocumentTitle());
        sparkReporter.config().setReportName(config.getReportName());

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        config.getSystemInfo().forEach(extentReports::setSystemInfo);

        return extentReports;
    }

    /**
     * Called automatically by Log4j2 to handle each log event.
     * <p>
     * If an {@link ExtentTest} is active, the log message is forwarded to ExtentReports with INFO status.
     *
     * @param event the log event to append
     */
    @Override
    public void append(LogEvent event) {
        if (extentTest != null) {
            extentTest.log(Status.INFO, event.getMessage().getFormattedMessage());
        }
    }

    @PluginFactory
    public static ExtentAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<?> layout) {
        Layout<?> effectiveLayout = layout;
        if (effectiveLayout == null) {
            effectiveLayout = PatternLayout.createDefaultLayout();
        }
        return new ExtentAppender(name, effectiveLayout);
    }
}