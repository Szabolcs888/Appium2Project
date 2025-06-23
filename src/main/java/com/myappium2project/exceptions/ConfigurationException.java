package com.myappium2project.exceptions;

/**
 * Thrown when a configuration file is missing, malformed, or contains invalid values.
 */
public class ConfigurationException extends AppiumProjectException {
    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}