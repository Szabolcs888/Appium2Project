package com.myappium2project.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for common utility methods.
 * This class is not meant to be instantiated.
 */
public final class CommonUtils {
    private static final Logger LOG = LogManager.getLogger(CommonUtils.class);
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String FAILED_DELETE_FILE_MESSAGE = "Failed to delete file: ";

    private CommonUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            LOG.error("Thread sleep was interrupted");
            throw new IllegalStateException("Thread sleep was interrupted", e);
        }
    }

    public static List<String> readDataFromFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (
                IOException e) {
            LOG.error("The testData's file is not found!");
        }
        return splittingLines(lines);
    }

    private static List<String> splittingLines(List<String> lines) {
        List<String> splitLines = new ArrayList<>();
        for (String item : lines) {
            try {
                splitLines.add(item.split("_:")[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                LOG.warn("Incorrect format in line: {}", item);
                throw new IllegalArgumentException("Test data format error: " + item, e);
            }
        }
        return splitLines;
    }

    private static void deleteDirectoryFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.delete()) {
                        System.out.println(FAILED_DELETE_FILE_MESSAGE + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private static void deleteFile(String path) {
        File file = new File(path);
        if (!file.delete()) {
            System.out.println(FAILED_DELETE_FILE_MESSAGE + file.getName());
        }
    }

    public static void copyFile(String sourcePath, String destinationPath) {
        try {
            File sourceFile = new File(sourcePath);
            File destinationFile = new File(destinationPath);
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            System.out.println("Failed to copy from target/surefire-reports/emailable-report.html: " + e.getMessage());
        }
    }

    public static void cleanReportsAndScreenshots() {
        deleteDirectoryFiles(new File(USER_DIR + "/reports/actualReportScreenshots/"));
        deleteFile(USER_DIR + "/reports/emailable-report.html");
        deleteFile(USER_DIR + "/target/surefire-reports/emailable-report.html");
        deleteFile(USER_DIR + "/reports/extent-report.html");
    }
}