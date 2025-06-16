package com.myappium2project.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for reading key-value pairs from the {@code config.properties} file located in the classpath.
 * <p>
 * Loads the properties once during static initialization and provides access via the {@link #get(String)} method.
 * Throws a {@link RuntimeException} if the file is missing or unreadable.
 */
public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Retrieves the value associated with the given key from the loaded {@code config.properties} file.
     *
     * @param key the name of the property to retrieve
     * @return the value associated with the key, or {@code null} if the key is not present
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }
}