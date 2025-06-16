package com.myappium2project.server;

import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.utils.ConfigReader;
import com.myappium2project.configpaths.MainPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utility class responsible for uploading the generated test report to Netlify using the Netlify CLI.
 * <p>
 * The upload is executed via a shell command built from configuration values defined in {@code config.properties},
 * such as the Bash executable path and Netlify deploy command prefix.
 * <p>
 * This class assumes that the Netlify CLI is already installed and accessible via the specified Bash environment.
 */
public final class NetlifyUploader {
    private static final Logger LOG = LogManager.getLogger(NetlifyUploader.class);

    private NetlifyUploader() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Uploads the local HTML test report directory to Netlify using a configured shell command.
     * <p>
     * Builds the command dynamically from:
     * <ul>
     *     <li>{@code ConfigDataKeys.BASH_EXECUTABLE_PATH}</li>
     *     <li>{@code ConfigDataKeys.NETLIFY_DEPLOY_COMMAND_PREFIX}</li>
     * </ul>
     * Assumes that the Netlify CLI is installed and authenticated.
     */
    public static void uploadReportToNetlify() {
        try {
            String reportsDirectory = MainPaths.REPORTS_DIR_PATH.toString().replace("\\", "/");
            String netlifyDeployPrefix = ConfigReader.get(ConfigDataKeys.NETLIFY_DEPLOY_COMMAND_PREFIX.getKey());
            String fullCommand = netlifyDeployPrefix + reportsDirectory;
            String bashPath = ConfigReader.get(ConfigDataKeys.BASH_EXECUTABLE_PATH.getKey());

            ProcessBuilder processBuilder = new ProcessBuilder(bashPath, "-c", fullCommand);
            processBuilder.directory(new File(reportsDirectory));
            Process process = processBuilder.start();
            System.out.println("Waiting for the report to be uploaded to the server...");

            if (LOG.isDebugEnabled()) {
                printCliOutput(process);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                LOG.info("Report uploaded to Netlify{}", System.lineSeparator());
            } else {
                LOG.error("Error uploading report. Exit code: {}{}", exitCode, System.lineSeparator());
            }
        } catch (IOException | InterruptedException e) {
            LOG.error("Exception occurred during report upload: {}", e.getMessage());
        }
    }

    /**
     * Prints the output of the Netlify CLI process to the logger for debugging purposes.
     */
    private static void printCliOutput(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LOG.debug("Netlify CLI output: {}", line);
            }
        } catch (IOException e) {
            LOG.debug("An error occurred while reading CLI output: {}", e.getMessage());
        }
    }
}