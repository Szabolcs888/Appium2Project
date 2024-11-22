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

public class CommonUtils {
    private static final Logger LOG = LogManager.getLogger(CommonUtils.class);

    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            LOG.error("Thread sleep was interrupted");
            throw new RuntimeException(e);
        }
    }

    public static List<String> readDataFromFile(String path) {
        LOG.info("We request the test data from the list");
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
                throw new RuntimeException("Test data format error: " + item, e);
            }
        }
        return splitLines;
    }

    private static void deleteDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    private static void deleteFile(String path) {
        File file = new File(path);
        if (file.delete()) {
        } else {
            System.out.println("Failed to delete the file: " + file.getName());
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
        deleteDirectoryContents(new File(System.getProperty("user.dir") + "/reports/actualReportScreenshots/"));
        deleteFile(System.getProperty("user.dir") + "/reports/emailable-report.html");
        deleteFile(System.getProperty("user.dir") + "/target/surefire-reports/emailable-report.html");
        deleteFile(System.getProperty("user.dir") + "/reports/extent-report.html");
    }
}