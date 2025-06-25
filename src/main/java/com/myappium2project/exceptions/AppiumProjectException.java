package com.myappium2project.exceptions;

import java.io.Serial;

/**
 * Base exception for all custom exceptions in the Appium project.
 */
public class AppiumProjectException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public AppiumProjectException(String message) {
        super(message);
    }

    public AppiumProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}