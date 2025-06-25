package com.myappium2project.exceptions;

import java.io.Serial;

/**
 * Thrown when a JSON file cannot be read or deserialized properly.
 */
public class JsonReadException extends AppiumProjectException {
    @Serial
    private static final long serialVersionUID = 1L;

    public JsonReadException(String message) {
        super(message);
    }

    public JsonReadException(String message, Throwable cause) {
        super(message, cause);
    }
}