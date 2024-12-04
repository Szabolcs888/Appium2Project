package com.myappium2project.logging.pagelogmessages;

public class CuraPageLogMessages {

    public static String getPageLoadValidationAssertLog(String pageName) {
        return String.format("The '%s' page should be loaded, but it is not.", pageName);
    }
}