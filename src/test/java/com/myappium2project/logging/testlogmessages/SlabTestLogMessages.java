package com.myappium2project.logging.testlogmessages;

/**
 * Saucelab log messages used across Saucelab tests.
 * This class is not meant to be instantiated.
 */
public final class SlabTestLogMessages {
    public static final String CHECK_CART_EMPTY_LOG = "We check if the cart is empty";
    public static final String CART_EMPTY_LOG = "The cart is empty";
    public static final String CART_NOT_EMPTY_LOG = "The cart is not empty";
    public static final String CART_NOT_EMPTY_ASSERT_LOG = "The cart should be empty, but it is not.";

    public static final String CHECK_CART_COUNTER_AVAILABLE_LOG = "We check if the cart counter is available";
    public static final String CART_COUNTER_NOT_AVAILABLE_LOG = "The cart counter is not available";
    public static final String CART_COUNTER_AVAILABLE_LOG = "The cart counter is available";
    public static final String CART_COUNTER_NOT_AVAILABLE_ASSERT_LOG = "The cart counter should not be available, but it is.";

    public static String incorrectPageTitleAssertLog(String expectedPageTitleText) {
        return String.format("The page title should be '%s', but it is not.", expectedPageTitleText);
    }

    private SlabTestLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}