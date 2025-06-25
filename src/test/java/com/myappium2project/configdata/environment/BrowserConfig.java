package com.myappium2project.configdata.environment;

import com.myappium2project.configdata.enums.BrowserType;
import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.utils.ConfigReader;

/**
 * Provides centralized access to the configured browser type for web testing.
 * <p>
 * The value is read from the {@code config.properties} key {@code browser.type}
 * and mapped to a {@link BrowserType} enum.
 */
public final class BrowserConfig {
    private static final BrowserType BROWSER_TYPE;

    static {
        String rawBrowserType = ConfigReader.get(ConfigDataKeys.BROWSER_TYPE.getKey());
        BROWSER_TYPE = BrowserType.from(rawBrowserType);
    }

    private BrowserConfig() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static BrowserType getBrowserType() {
        return BROWSER_TYPE;
    }
}