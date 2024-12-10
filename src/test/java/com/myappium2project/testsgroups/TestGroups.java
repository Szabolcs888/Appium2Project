package com.myappium2project.testsgroups;

/**
 * Contains test group constants for TestNG annotations.
 * This class is not meant to be instantiated.
 * <p>
 * Note: The "REGRESSION" test group is defined directly in the XML file and not as a constant here.
 */
public class TestGroups {
    public static final String SMOKE = "smoke";
    public static final String INTEGRATION = "integration";
    public static final String E2E = "e2e";

    private TestGroups() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}