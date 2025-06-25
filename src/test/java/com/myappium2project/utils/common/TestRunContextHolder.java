package com.myappium2project.utils.common;

/**
 * Utility class for storing suite-level context data during test execution.
 * <p>
 * Currently holds the suite name, which is set by the TestNG listener at the start of the test run,
 * and retrieved later for logging and reporting purposes (e.g., in {@code @AfterSuite}).
 * <p>
 * Although the project currently runs tests in a single-threaded environment, this implementation
 * uses {@link ThreadLocal} as a lightweight precautionary measure. It prepares the design for
 * potential future use cases involving parallel test execution, even if such scenarios are not
 * actively planned or required at the moment.
 */
public final class TestRunContextHolder {
    private static final ThreadLocal<String> suiteName = new ThreadLocal<>();

    private TestRunContextHolder() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void setSuiteName(String name) {
        suiteName.set(name);
    }

    public static String getSuiteName() {
        return suiteName.get();
    }

    public static void clear() {
        suiteName.remove();
    }
}