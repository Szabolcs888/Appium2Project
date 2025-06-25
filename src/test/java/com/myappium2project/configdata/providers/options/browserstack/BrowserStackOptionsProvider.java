package com.myappium2project.configdata.providers.options.browserstack;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.models.options.browserstack.BrowserStackOptions;
import com.myappium2project.utils.JsonDataReader;

/**
 * Provides preloaded BrowserStack-specific configuration options for supported test targets.
 * <p>
 * The options are loaded once from JSON files and exposed via static getters for reuse
 * across test initialization logic.
 */
public final class BrowserStackOptionsProvider {
    private static final BrowserStackOptions sauceLabsOptions = JsonDataReader.readJsonFromResource(
            TestPaths.BS_SAUCELABS_OPTIONS_JSON, BrowserStackOptions.class);
    private static final BrowserStackOptions chromeOptions = JsonDataReader.readJsonFromResource(
            TestPaths.BS_CHROME_OPTIONS_JSON, BrowserStackOptions.class);

    private BrowserStackOptionsProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static BrowserStackOptions getSauceLabsOptions() {
        return sauceLabsOptions;
    }

    public static BrowserStackOptions getChromeOptions() {
        return chromeOptions;
    }
}