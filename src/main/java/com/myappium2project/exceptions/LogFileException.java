package com.myappium2project.exceptions;

import java.io.Serial;

/**
 * Thrown when a log file cannot be accessed, found, or processed.
 */
public class LogFileException extends AppiumProjectException {
    @Serial
    private static final long serialVersionUID = 1L;

    public LogFileException(String message) {
        super(message);
    }

    public LogFileException(String message, Throwable cause) {
        super(message, cause);
    }
}