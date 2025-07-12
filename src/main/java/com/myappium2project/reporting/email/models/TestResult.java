package com.myappium2project.email.models;

/**
 * Represents the result of a single automated test execution.
 * <p>
 * Stores metadata such as the test name, class name, execution status,
 * and duration in both formatted and numeric forms.
 */
public class TestResult {
    private final String name;
    private final String className;
    private final String status;
    private final String durationFormatted;
    private final double durationSeconds;

    public TestResult(String name, String className, String status, String durationFormatted, double durationSeconds) {
        this.name = name;
        this.className = className;
        this.status = status;
        this.durationFormatted = durationFormatted;
        this.durationSeconds = durationSeconds;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getStatus() {
        return status;
    }

    public String getDurationFormatted() {
        return durationFormatted;
    }

    public double getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", status='" + status + '\'' +
                ", durationFormatted='" + durationFormatted + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}