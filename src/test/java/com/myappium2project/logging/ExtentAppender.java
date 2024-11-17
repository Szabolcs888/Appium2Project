package com.myappium2project.logging;

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

@Plugin(name = "ExtentAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public class ExtentAppender extends AbstractAppender {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    protected ExtentAppender(String name, Layout<?> layout) {
        super(name, null, layout, false);
    }

    public static void setExtentReports(ExtentReports reports) {
        extentReports = reports;
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
    public static ExtentAppender createAppender(@PluginAttribute("name") String name,
                                                @PluginElement("Layout") Layout<?> layout) {
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new ExtentAppender(name, layout);
    }

    public static void reset() {
        extentTest = null;
    }
}