package com.myappium2project.reporting.extent;

import java.util.Map;

/**
 * Data model for configuring ExtentReports settings.
 * <p>
 * Typically loaded from a JSON file to dynamically set the theme, titles,
 * and system information of the generated HTML test report.
 */
public class ExtentReportsConfig {
    private String theme;
    private String documentTitle;
    private String reportName;
    private Map<String, String> systemInfo;

    /**
     * Default constructor required for JSON deserialization.
     */
    public ExtentReportsConfig() {
    }

    public String getTheme() {
        return theme;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public String getReportName() {
        return reportName;
    }

    public Map<String, String> getSystemInfo() {
        return Map.copyOf(systemInfo);
    }

    @Override
    public String toString() {
        return "ExtentReportsConfig{" +
                "theme='" + theme + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", reportName='" + reportName + '\'' +
                ", systemInfo=" + systemInfo +
                '}';
    }
}