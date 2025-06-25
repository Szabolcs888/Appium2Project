package com.myappium2project.utils;

import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.exceptions.LogFileException;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for generating file paths for Appium server log output.
 * <p>
 * Constructs the path based on configuration properties and the current timestamp.
 * Ensures the target directory exists before returning the full log file path.
 */
public final class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Creates a timestamped log file path for the Appium server logs.
     * <p>
     * The path is constructed using the following configuration keys:
     * <ul>
     *   <li>{@code log.base.directory}</li>
     *   <li>{@code appium.server.log.subdirectory}</li>
     *   <li>{@code appium.server.log.filename.prefix}</li>
     * </ul>
     * The parent directories are created automatically if they do not exist.
     *
     * @return the full path to the log file as a string
     */
    public static String createServerLogPath() {
        String baseDir = ConfigReader.get(ConfigDataKeys.LOG_BASE_DIRECTORY.getKey());
        String subDir = ConfigReader.get(ConfigDataKeys.APPIUM_SERVER_LOG_SUBDIRECTORY.getKey());
        String filePrefix = ConfigReader.get(ConfigDataKeys.APPIUM_SERVER_LOG_FILENAME_PREFIX.getKey());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String fileName = filePrefix + timestamp + ".log";

        String fullPath = Paths.get(baseDir, subDir, fileName).toString();

        File logFile = new File(fullPath);
        File parentDir = logFile.getParentFile();
        if (!parentDir.mkdirs() && !parentDir.exists()) {
            throw new LogFileException("Failed to create log directory: " + parentDir.getAbsolutePath());
        }

        return fullPath;
    }
}