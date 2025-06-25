package com.myappium2project.exceptions;

import java.io.Serial;

/**
 * Thrown when a configuration file is missing, malformed, or contains invalid values.
 */
public class ConfigurationException extends AppiumProjectException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}