package com.myappium2project.logging.testlogmessages;

public class CommonTestLogMessages {
    public static final String START_APP_LOG = "------- START: {} -------";
    public static final String STOPPED_APP_LOG = "------- STOPPED: {} -------\n";

    public static final String CHECK_ERROR_MESSAGE_LOG = "We check if the error message appears and, if so, if it is correct";
    public static final String EXPECTED_ERROR_MESSAGE_LOG = "Expected error message: '{}'";
    public static final String ERROR_MESSAGE_CORRECT_LOG = "The error message is correct";
    public static final String ERROR_MESSAGE_INCORRECT_ERRORLOG = "The error message is not correct";

    public static final String CHECK_PAGE_LOG = "We check if we are on the '{}' page";
    public static final String ON_PAGE_LOG = "We are on the '{}' page";
    public static final String NOT_ON_PAGE_ERRORLOG = "We are not on the '{}' page";

    public static String getErrorMessageValidationAssertLog(String errorMessage, String expectedErrorMessage) {
        return String.format("The error message should be '%s', but it is '%s'.", expectedErrorMessage, errorMessage);
    }
}