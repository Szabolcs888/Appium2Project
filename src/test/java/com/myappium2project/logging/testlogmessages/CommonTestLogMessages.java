package com.myappium2project.logging.testlogmessages;

public class CommonTestLogMessages {
    public static final String CHECK_ERROR_MESSAGE_LOG = "We check if the error message appears and, if so, if it is correct.";
    public static final String ERROR_MESSAGE_CORRECT_LOG = "The error message is correct";
    public static final String ERROR_MESSAGE_INCORRECT_ERRORLOG = "The error message is not correct";

    public static String getCheckPageLog() {
        return "We check if we are on the '{}' page";
    }

    public static String getOnPageLog() {
        return "We are on the '{}' page";
    }

    public static String getNotOnPageErrorLog() {
        return "We are not on the '{}' page";
    }

    public static String getPageLoadErrorAssertLog(String pageName) {
        return String.format("The '%s' page should be loaded, but it is not.", pageName);
    }

    public static String getErrorMessageErrorAssertLog(String errorMessage, String expectedErrorMessage) {
        return String.format("The error message should be '%s', but it is '%s'.", expectedErrorMessage, errorMessage);
    }
}