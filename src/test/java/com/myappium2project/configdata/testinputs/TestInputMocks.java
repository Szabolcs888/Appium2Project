package com.myappium2project.configdata.testinputs;

/**
 * Provides predefined invalid or edge-case input values for testing purposes.
 * <p>
 * These constants help simulate user input validation scenarios, such as invalid credentials or formats.
 */
public class TestInputMocks {

    private TestInputMocks() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String getInvalidUsername() {
        return "invalid_username";
    }

    public static String getInvalidPassword() {
        return "invalid_password";
    }

    public static String getEmptyString() {
        return "";
    }

    public static String getShortPassword() {
        return "123";
    }

    public static String getInvalidEmailFormat() {
        return "user@invalid@domain";
    }
}