package com.myappium2project.logging.pagelogmessages;

/**
 * Saucelab log messages used across Saucelab pages.
 * This class is not meant to be instantiated.
 */
public final class SlabPageLogMessages {
    public static final String PRESS_BUTTON_UNDER_LOG = "We press the '{}' button under the '{}'";

    public static String pageTitleTextNotAvailableLog(String pageTitle) {
        return String.format("The '%s' page title text is not available", pageTitle);
    }

    private SlabPageLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}