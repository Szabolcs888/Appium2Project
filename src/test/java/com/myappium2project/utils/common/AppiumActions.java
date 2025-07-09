package com.myappium2project.utils.common;

import com.google.common.collect.ImmutableList;
import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

/**
 * Utility class providing reusable Appium-based actions for Android automation.
 * <p>
 * Includes helper methods for navigation, scrolling, and touch gestures
 * such as long-press or free coordinate scrolling.
 * <p>
 * These methods abstract low-level Appium interactions into more readable and maintainable operations.
 * All actions are logged for easier debugging and test result tracing.
 */
public final class AppiumActions {
    private static final Logger LOG = LogManager.getLogger(AppiumActions.class);
    private static final String SCROLL_DIRECTION_LOG = "We scroll {}";

    private AppiumActions() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void navigateBack(AndroidDriver driver) {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_ON_LOG, "back", "phone");
        driver.navigate().back();
    }

    /**
     * Performs a scroll gesture using absolute screen coordinates.
     * Useful when relative positions are unreliable or fixed layout is expected.
     *
     * @param driver     the Android driver
     * @param runs       number of scroll gestures to perform
     * @param startX     X coordinate of the start point
     * @param startY     Y coordinate of the start point
     * @param endX       X coordinate of the end point
     * @param endY       Y coordinate of the end point
     * @param logMessage message to be logged before scrolling
     */
    public static void scrollWithFreeCoordinates(
            AndroidDriver driver, int numbersOfRuns, int startX, int startY, int endX, int endY, String logMessage) {
        Duration scrollDuration = Duration.ofMillis(300);
        LOG.info(logMessage);
        Point startPoint = new Point(startX, startY);
        Point endPoint = new Point(endX, endY);
        for (int i = 0; i < numbersOfRuns; i++) {
            try {
                scrollAction(driver, startPoint, endPoint, scrollDuration);
            } catch (Exception _) {
            // Scroll failure is expected occasionally due to popup interference – no action required
            }
        }
    }

    /**
     * Scrolls the page in a given direction using coordinates based on screen size and scroll ratio.
     *
     * @param driver        the Android driver
     * @param numbersOfRuns number of scroll attempts
     * @param pageDirection direction to scroll (UP, DOWN, LEFT, RIGHT)
     * @param scrollRatio   ratio (0–1) of how far to scroll relative to screen size
     * @throws IllegalArgumentException if scrollRatio is out of bounds
     */
    public static void scrollWithFixCoordinates(
            AndroidDriver driver, int numbersOfRuns, String pageDirection, double scrollRatio) {
        validateScrollRatio(scrollRatio);

        Duration scrollDuration = Duration.ofMillis(300);
        Dimension size = driver.manage().window().getSize();
        Point midPoint = calculateMidPoint(size);

        for (int i = 0; i < numbersOfRuns; i++) {
            CommonUtils.threadSleep(500);
            performScroll(driver, pageDirection, midPoint, scrollDuration, scrollRatio);
        }
    }

    private static void validateScrollRatio(double scrollRatio) {
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new IllegalArgumentException("Scroll distance must be between 0 and 1!");
        }
    }

    private static Point calculateMidPoint(Dimension size) {
        int midX = (int) (size.width * 0.5);
        int midY = (int) (size.height * 0.5);
        return new Point(midX, midY);
    }

    private static void performScroll(AndroidDriver driver, String pageDirection, Point midPoint,
                                      Duration scrollDuration, double scrollRatio) {
        int top = (int) (midPoint.y - midPoint.y * scrollRatio);
        int bottom = (int) (midPoint.y + midPoint.y * scrollRatio);
        int left = (int) (midPoint.x - midPoint.x * scrollRatio);
        int right = (int) (midPoint.x + midPoint.x * scrollRatio);

        switch (pageDirection) {
            case "UP" -> {
                LOG.info(SCROLL_DIRECTION_LOG, "up");
                scrollAction(driver, new Point(midPoint.x, top), new Point(midPoint.x, bottom), scrollDuration);
            }
            case "DOWN" -> {
                LOG.info(SCROLL_DIRECTION_LOG, "down");
                scrollAction(driver, new Point(midPoint.x, bottom), new Point(midPoint.x, top), scrollDuration);
            }
            case "LEFT" -> {
                LOG.info(SCROLL_DIRECTION_LOG, "to the left");
                scrollAction(driver, new Point(left, midPoint.y), new Point(right, midPoint.y), scrollDuration);
            }
            case "RIGHT" -> {
                LOG.info(SCROLL_DIRECTION_LOG, "to the right");
                scrollAction(driver, new Point(right, midPoint.y), new Point(left, midPoint.y), scrollDuration);
            }
            default -> {
                if (LOG.isWarnEnabled()) {
                    LOG.warn("Unexpected page direction: {}", pageDirection);
                }
            }
        }
    }

    private static void scrollAction(AndroidDriver driver, Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence fingerAction = new Sequence(input, 0);
        fingerAction.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        fingerAction.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        fingerAction.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        fingerAction.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(fingerAction));
    }
}