package com.myappium2project.logging.pagelogmessages;

public class CommonPageLogMessages {
    public static final String PRESS_BUTTON_LOG = "We press the '{}' button";
    public static final String PRESS_BUTTON_ON_LOG = "We press the '{}' button on the {}";

    public static final String FILL_INPUT_LOG = "We fill the '{}' input field with: '{}'";
    public static final String FILL_USERNAME_INPUT_LOG = "We fill the 'Username' input field with the '{}' username";
    public static final String FILL_PASSWORD_INPUT_LOG = "We fill the 'Password' input field with the '{}' password";

    public static final String ERROR_MESSAGE_IS_NOT_AVAILABLE_LOG = "The error message is not available";

    public static String getTextIsNotAvailableLog(String text) {
        return String.format("The '%s' text is not available", text);
    }
}