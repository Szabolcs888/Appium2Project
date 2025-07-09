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
     * Reads a JSON file from the resources folder and maps it to an object of the specified class.
     *
     * @param filePath The path of the JSON file inside the resources directory (e.g., "data/user.json").
     * @param clazz    The class to which the JSON should be mapped (e.g., User.class).
     * @param <T>      The type of the object to be returned.
     * @return An instance of type T populated with data from the JSON file.
     * @throws JsonReadException If the file is not found or deserialization fails.
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
     * Reads a JSON array file from the resources folder and maps it to a List of the specified type.
     *
     * @param filePath    The path to the JSON array file inside resources (e.g., "data/users.json").
     * @param elementType The class of the elements contained in the list (e.g., User.class).
     * @param <T>         The type of elements in the returned list.
     * @return A List of objects of type T populated with data from the JSON array.
     * @throws JsonReadException If the file is not found or the deserialization fails.
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