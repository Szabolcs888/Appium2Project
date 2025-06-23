package com.myappium2project.exceptions;

/**
 * Base exception for all custom exceptions in the Appium project.
 */
public class AppiumProjectException extends RuntimeException {
    public AppiumProjectException(String message) {
        super(message);
    }

    public AppiumProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}