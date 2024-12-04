package com.myappium2project.logging.pagelogmessages;

public class SlabPageLogMessages {
    public static final String PRESS_BUTTON_UNDER_LOG = "We press the '{}' button under the '{}'";

    public static String getPageTitleTextIsNotAvailableLog(String pageTitle) {
        return String.format("The '%s' page title text is not available", pageTitle);
    }
}