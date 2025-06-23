package com.myappium2project.exceptions;

/**
 * Thrown when a log file cannot be accessed, found, or processed.
 */
public class LogFileException extends AppiumProjectException {
    public LogFileException(String message) {
        super(message);
    }

    public LogFileException(String message, Throwable cause) {
        super(message, cause);
    }
}