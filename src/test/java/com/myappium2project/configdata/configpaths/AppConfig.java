package com.myappium2project.configdata.configpaths;

/**
 * Contains application-level configuration constants used across the test framework.
 */
public class AppConfig {
    public static final String CURA_BASE_URL = "https://katalon-demo-cura.herokuapp.com";
    public static final String CURA_MAIN_PAGE_URL = "https://katalon-demo-cura.herokuapp.com/";
    public static final String CURA_MAKE_APPOINTMENT_PAGE_URL = "https://katalon-demo-cura.herokuapp.com/#appointment";

    private AppConfig() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}