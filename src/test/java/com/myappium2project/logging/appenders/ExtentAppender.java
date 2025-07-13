package com.myappium2project.logging.appenders;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
 * The test context (i.e., the current test instance) must be injected via {@code setExtentTest()}
 * before any logs can appear in the ExtentReports output.
 * <p>
 * The overall ExtentReports setup and test lifecycle integration should be handled
 * from the testing layer (typically via a TestNG listener).
 *
 * <p><b>Note:</b> Logging only works while a test is active and an {@link ExtentTest} instance is available.
 */
@Plugin(name = "ExtentAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public final class ExtentAppender extends AbstractAppender {
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

    /**
     * Factory method for creating the custom Log4j appender.
     *
     * @param name   the appender name
     * @param layout the log layout (optional, uses default if null)
     * @return a new ExtentAppender instance
     */
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