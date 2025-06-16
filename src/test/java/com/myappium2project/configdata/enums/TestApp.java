package com.myappium2project.configdata.enums;

/**
 * Enum representing the mobile applications under test.
 * <p>
 * Each enum value maps to a string identifier used for configuration lookups and option selection.
 */
public enum TestApp {
    SAUCELABS("saucelabs"),
    BATTERYALARM("batteryalarm");

    private final String name;

    TestApp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}