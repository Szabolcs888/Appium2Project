package com.myappium2project.configdata.enums;

/**
 * Enum representing the test execution environment: local or cloud.
 * <p>
 * Provides helper methods for converting from string input and for checking environment type.
 */
public enum TestEnvironment {
    LOCAL("local"),
    CLOUD("cloud");

    private final String value;

    TestEnvironment(String value) {
        this.value = value;
    }

    /**
     * Parses a string value to its corresponding {@link TestEnvironment} enum.
     *
     * @param value the string representation of the environment
     * @return the matching {@code TestEnvironment} enum
     * @throws IllegalArgumentException if the value is null, blank, or invalid
     */
    public static TestEnvironment from(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Missing or empty 'run.environment'. Allowed: local, cloud");
        }

        return switch (value.trim().toLowerCase()) {
            case "local" -> LOCAL;
            case "cloud" -> CLOUD;
            default -> throw new IllegalArgumentException(
                    "Invalid 'run.environment': '" + value + "'. Allowed: local, cloud"
            );
        };
    }

    public boolean isCloud() {
        return this == CLOUD;
    }

    public boolean isLocal() {
        return this == LOCAL;
    }

    public String getValue() {
        return value;
    }
}