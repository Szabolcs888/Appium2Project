package com.myappium2project.logging.pagelogmessages;

/**
 * Common log messages used across pages.
 */
public final class CommonPageLogMessages {
    public static final String PRESS_BUTTON_LOG = "We press the '{}' button";
    public static final String PRESS_BUTTON_ON_LOG = "We press the '{}' button on the {}";

    public static final String FILL_INPUT_LOG = "We fill the '{}' input field with: '{}'";
    public static final String FILL_USERNAME_INPUT_LOG = "We fill the 'Username' input field with the '{}' username";
    public static final String FILL_PASSWORD_INPUT_LOG = "We fill the 'Password' input field with the '{}' password";

    public static final String ERROR_MESSAGE_NOT_AVAILABLE_LOG = "The error message is not available";

    private CommonPageLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String textNotAvailableLog(String text) {
        return String.format("The '%s' text is not available", text);
    }
}