package com.myappium2project.configdata.enums;

/**
 * Enum representing supported browser types for web testing on mobile devices.
 * <p>
 * Used to safely parse and map browser types defined in configuration files (e.g., {@code config.properties}).
 */
public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String name;

    BrowserType(String name) {
        this.name = name;
    }

    /**
     * Parses the given raw string to its corresponding {@link BrowserType} enum.
     *
     * @param raw the browser type string from configuration (e.g., "chrome", "firefox", "edge")
     * @return the corresponding {@link BrowserType}
     * @throws IllegalArgumentException if the input is null, blank, or does not match a supported browser
     */
    public static BrowserType from(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("Missing 'browser.type' in config.properties. Allowed values: chrome, firefox, edge.");
        }

        return switch (raw.toLowerCase()) {
            case "chrome" -> CHROME;
            case "firefox" -> FIREFOX;
            case "edge" -> EDGE;
            default ->
                    throw new IllegalArgumentException("Invalid browser type: '" + raw + "'. Allowed: chrome, firefox, edge.");
        };
    }

    public String getName() {
        return name;
    }
}