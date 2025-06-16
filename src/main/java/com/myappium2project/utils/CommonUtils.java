package com.myappium2project.utils;

import com.myappium2project.configpaths.MainPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;

/**
 * Utility class containing general-purpose helper methods for common test framework operations.
 */
public final class CommonUtils {
    private static final Logger LOG = LogManager.getLogger(CommonUtils.class);
    private static final String FAILED_DELETE_FILE_MESSAGE = "Failed to delete file: ";

    private CommonUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Pauses the current thread for the specified number of milliseconds.
     * <p>
     * Wraps {@link Thread#sleep(long)} and rethrows any {@link InterruptedException}
     * as an unchecked {@link IllegalStateException}.
     *
     * @param milliseconds the number of milliseconds to sleep
     * @throws IllegalStateException if the thread is interrupted during sleep
     */
    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            LOG.error("Thread sleep was interrupted");
            throw new IllegalStateException("Thread sleep was interrupted", e);
        }
    }

    /**
     * Deletes previously generated HTML reports and screenshots.
     * <p>
     * This is typically used before a new test run to ensure clean reporting output.
     */
    public static void cleanReportsAndScreenshots() {
        deleteDirectoryFiles(MainPaths.ACTUAL_REPORT_SCREENSHOT_PATH, "actualreportscreenshots");
        deleteFile(MainPaths.EXTENT_REPORT_FILE_PATH);
    }

    /**
     * Deletes all files (not subdirectories) in the specified directory.
     *
     * @param directoryPath the path to the directory to clean
     * @param directoryName the name used for logging context
     */
    private static void deleteDirectoryFiles(Path directoryPath, String directoryName) {
        File dirPathAsString = directoryPath.toFile(); // Path -> File átalakítás
        File[] files = dirPathAsString.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.delete()) {
                        LOG.warn("Failed to delete file from the {} directory: {}", directoryName, file.getName());
                    } else {
                        LOG.debug("Deleted file from the actualReportScreenshots directory: {}", file.getName());
                    }
                }
            }
        }
    }

    /**
     * Attempts to delete a single file and logs a warning if deletion fails.
     *
     * @param filePath the path of the file to delete
     */
    private static void deleteFile(Path filePath) {
        File file = new File(String.valueOf(filePath));
        if (!file.delete()) {
            LOG.warn(FAILED_DELETE_FILE_MESSAGE + "{}", file.getName());
        } else {
            LOG.debug("Deleted file: {}", filePath);
        }
    }
}