package com.myappium2project.logging.testlogmessages;

/**
 * Provides reusable log messages for test reporting and assertions.
 * <p>
 * This class helps ensure consistent logging output across different test classes.
 */
public final class CommonTestLogMessages {
    public static final String START_APP_LOG = "------- START: {} -------";
    public static final String STOPPED_APP_LOG = "------- STOPPED: {} -------" + System.lineSeparator();

    public static final String VALID_LOG = "valid";
    public static final String INVALID_LOG = "invalid";
    public static final String EMPTY_LOG = "empty";

    public static final String CHECK_ERROR_MESSAGE_LOG = "We check if the error message appears and, if so, if it is correct";
    public static final String EXPECTED_ERROR_MESSAGE_LOG = "Expected error message: '{}'";
    public static final String CORRECT_ERROR_MESSAGE_LOG = "The error message is correct";
    public static final String INCORRECT_ERROR_MESSAGE_LOG = "The error message is not correct";

    public static final String CHECK_ON_PAGE_LOG = "We check if we are on the '{}' page";
    public static final String ON_PAGE_LOG = "We are on the '{}' page";
    public static final String NOT_ON_PAGE_LOG = "We are not on the '{}' page";

    private CommonTestLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Returns a formatted assertion log message for mismatched error messages.
     *
     * @param actual   the actual error message shown
     * @param expected the expected error message
     * @return formatted message for assertion logging
     */
    public static String incorrectErrorMessageAssertLog(String errorMessage, String expectedErrorMessage) {
        return String.format("The error message should be '%s', but it is '%s'.", expectedErrorMessage, errorMessage);
    }
}