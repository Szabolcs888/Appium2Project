package com.myappium2project.exceptions;

/**
 * Thrown when a JSON file cannot be read or deserialized properly.
 */
public class JsonReadException extends AppiumProjectException {
    public JsonReadException(String message) {
        super(message);
    }

    public JsonReadException(String message, Throwable cause) {
        super(message, cause);
    }
}