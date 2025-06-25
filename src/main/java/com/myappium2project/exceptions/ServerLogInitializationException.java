package com.myappium2project.exceptions;

import java.io.Serial;

/**
 * Thrown when initialization of the Appium server log stream fails.
 */
public class ServerLogInitializationException extends AppiumProjectException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ServerLogInitializationException(String message) {
        super(message);
    }

    public ServerLogInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}