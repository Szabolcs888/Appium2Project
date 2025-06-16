package com.myappium2project.testsgroups;

/**
 * Defines the names of TestNG groups used to categorize test cases.
 * <p>
 * These constants are typically referenced in the {@code groups} attribute of the {@link org.testng.annotations.Test} annotation.
 */
public class TestGroups {
    public static final String SMOKE = "smoke";
    public static final String INTEGRATION = "integration";
    public static final String E2E = "e2e";

    private TestGroups() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}