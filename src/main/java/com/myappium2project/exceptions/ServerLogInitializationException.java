package com.myappium2project.exceptions;

/**
 * Thrown when initialization of the Appium server log stream fails.
 */
public class ServerLogInitializationException extends AppiumProjectException {
    public ServerLogInitializationException(String message) {
        super(message);
    }

    public ServerLogInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}