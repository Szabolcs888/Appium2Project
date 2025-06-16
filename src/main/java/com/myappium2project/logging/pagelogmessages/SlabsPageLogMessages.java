package com.myappium2project.logging.pagelogmessages;

/**
 * Saucelab log messages used across Saucelab pages.
 */
public final class SlabsPageLogMessages {
    public static final String PRESS_BUTTON_UNDER_LOG = "We press the '{}' button under the '{}'";

    private SlabsPageLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String pageTitleTextNotAvailableLog(String pageTitle) {
        return String.format("The '%s' page title text is not available", pageTitle);
    }
}