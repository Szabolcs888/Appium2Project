package com.myappium2project.utils;

import com.google.common.collect.ImmutableList;
import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

public class AppiumActions {
    private static final Logger LOG = LogManager.getLogger(AppiumActions.class);
    private static final String SCROLL_DIRECTION_LOG = "We scroll {}";

    public static void navigateBack(AndroidDriver driver) {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_ON_LOG, "back", "phone");
        driver.navigate().back();
    }

    public static void scrollWithFreeCoordinates(
            AndroidDriver driver, int numbersOfRuns, int startX, int startY, int endX, int endY, String logMessage) {
        for (int i = 0; i < numbersOfRuns; i++) {
            try {
                LOG.info(logMessage);
                Duration SCROLL_DURATION = Duration.ofMillis(300);
                scrollAction(driver, new Point(startX, startY), new Point(endX, endY), SCROLL_DURATION);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void scrollWithFixCoordinates(
            AndroidDriver driver, int numbersOfRuns, String pageDirection, double scrollRatio) {
        for (int i = 0; i < numbersOfRuns; i++) {
            CommonUtils.threadSleep(500);
            Duration SCROLL_DURATION = Duration.ofMillis(300);
            if (scrollRatio < 0 || scrollRatio > 1) {
                throw new Error("Scroll distance must be between 0 and 1!");
            }

            Dimension size = driver.manage().window().getSize();
            Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
            int top = (int) (midPoint.y - midPoint.y * scrollRatio);
            int bottom = (int) (midPoint.y + midPoint.y * scrollRatio);
            int left = (int) (midPoint.x - midPoint.x * scrollRatio);
            int right = (int) (midPoint.x + midPoint.x * scrollRatio);
            switch (pageDirection) {
                case "UP" -> {
                    LOG.info(SCROLL_DIRECTION_LOG, "up");
                    scrollAction(driver, new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DURATION);
                }
                case "DOWN" -> {
                    LOG.info(SCROLL_DIRECTION_LOG, "down");
                    scrollAction(driver, new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DURATION);
                }
                case "LEFT" -> {
                    LOG.info(SCROLL_DIRECTION_LOG, "to the left");
                    scrollAction(driver, new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DURATION);
                }
                case "RIGHT" -> {
                    LOG.info(SCROLL_DIRECTION_LOG, "to the right");
                    scrollAction(driver, new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DURATION);
                }
            }
        }
    }

    public static void scrollAction(AndroidDriver driver, Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence fingerAction = new Sequence(input, 0); //mutató létrehozása
        fingerAction.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        fingerAction.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        fingerAction.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        fingerAction.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(fingerAction));
    }

    public static void longPress(AndroidDriver driver, WebElement webElement) {
        Point location = webElement.getLocation();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence fingerAction = new Sequence(input, 0);
        fingerAction.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        fingerAction.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        fingerAction.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
        fingerAction.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(fingerAction));
    }
}