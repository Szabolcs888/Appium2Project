package com.myappium2project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myappium2project.exceptions.JsonReadException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Utility class for reading JSON files from the classpath and deserializing them into Java objects using Jackson.
 * <p>
 * Supports reading both single objects and lists of objects.
 */
public final class JsonDataReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonDataReader() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Reads a JSON file from the classpath and deserializes it into an object of the specified type.
     *
     * @param filePath the relative path to the JSON resource file (e.g. {@code "data/user.json"})
     * @param clazz    the target class type for deserialization
     * @param <T>      the type of the resulting object
     * @return a deserialized object of type {@code T}
     * @throws IllegalArgumentException if the file is not found
     * @throws RuntimeException         if deserialization fails
     */
    public static <T> T readJsonFromResource(String filePath, Class<T> clazz) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("JSON file not found: " + filePath);
            }
            return objectMapper.readValue(inputStream, clazz);
        } catch (IOException e) {
            throw new JsonReadException("Failed to read JSON file: " + filePath, e);
        }
    }

    /**
     * Reads a JSON file from the classpath and deserializes it into a list of the specified element type.
     *
     * @param filePath    the relative path to the JSON resource file (e.g. {@code "data/users.json"})
     * @param elementType the class of the list's element type
     * @param <T>         the type of elements in the resulting list
     * @return a list of deserialized objects of type {@code T}
     * @throws IllegalArgumentException if the file is not found
     * @throws RuntimeException         if deserialization fails
     */
    public static <T> List<T> readJsonListFromResource(String filePath, Class<T> elementType) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("JSON file not found: " + filePath);
            }
            return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, elementType));
        } catch (IOException e) {
            throw new JsonReadException("Failed to read JSON list from file: " + filePath, e);
        }
    }
}