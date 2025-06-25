package com.myappium2project.utils.common;

import com.myappium2project.configdata.models.options.browserstack.BrowserStackOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for converting {@link BrowserStackOptions} into a Map-based
 * capabilities representation compatible with BrowserStack's desired capabilities format.
 */
public final class BrowserStackCapabilityMapper {

    private BrowserStackCapabilityMapper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Converts the provided {@link BrowserStackOptions} into a {@link Map} of capabilities.
     *
     * @param options the BrowserStackOptions object containing configuration values
     * @return a Map representing the capabilities for use with BrowserStack
     */
    public static Map<String, Object> buildFrom(BrowserStackOptions options) {
        Map<String, Object> map = new HashMap<>();

        if (options.getUserName() != null) {
            map.put("userName", options.getUserName());
        }
        if (options.getAccessKey() != null) {
            map.put("accessKey", options.getAccessKey());
        }
        if (options.getAppiumVersion() != null) {
            map.put("appiumVersion", options.getAppiumVersion());
        }
        if (options.getProjectName() != null) {
            map.put("projectName", options.getProjectName());
        }
        if (options.getBuildName() != null) {
            map.put("buildName", options.getBuildName());
        }
        if (options.getSessionName() != null) {
            map.put("sessionName", options.getSessionName());
        }
        if (options.getDebug() != null) {
            map.put("debug", options.getDebug());
        }
        if (options.getDeviceName() != null) {
            map.put("deviceName", options.getDeviceName());
        }

        return map;
    }
}