package com.myappium2project.logging.pagelogmessages;

/**
 * Cura Healthcare log messages used across Cura Healthcare pages.
 */
public final class CuraPageLogMessages {

    private CuraPageLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String pageNotLoadAssertLog(String pageName) {
        return String.format("The '%s' page should be loaded, but it is not.", pageName);
    }
}