package com.myappium2project.utils;

/**
 * Utility class for common string manipulation operations used within the test framework.
 */

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Capitalizes the first character of the input string.
     * <p>
     * If the input is {@code null} or blank, the original value is returned unchanged.
     *
     * @param input the input string
     * @return the input string with the first character capitalized, or the original if null/blank
     */
    public static String capitalize(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}