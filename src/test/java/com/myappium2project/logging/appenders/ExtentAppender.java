package com.myappium2project.logging.appenders;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
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
 * Class captures and formats log events for reporting and visualization in ExtentReports.
 */
@Plugin(name = "ExtentAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public final class ExtentAppender extends AbstractAppender {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    private ExtentAppender(String name, Layout<?> layout) {
        super(name, null, layout, false);
    }

    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }

    public static ExtentReports setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("User", "Szabolcs");
        return extentReports;
    }

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