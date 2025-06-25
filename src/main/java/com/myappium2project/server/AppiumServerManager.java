package com.myappium2project.server;

import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.exceptions.ServerLogInitializationException;
import com.myappium2project.utils.ConfigReader;
import com.myappium2project.utils.LogUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class for managing the local Appium server lifecycle in non-cloud test environments.
 * <p>
 * This class conditionally starts or stops the Appium server from code,
 * if it is not already running manually or as an external process.
 * <p>
 * Typically used as a fallback mechanism when the server is not started via script (e.g. BAT file).
 */
public class AppiumServerManager {
    private static final Logger LOG = LogManager.getLogger(AppiumServerManager.class);
    private static final int APPIUM_PORT = Integer.parseInt(ConfigReader.get(ConfigDataKeys.APPIUM_PORT.getKey()));
    private static final Object LOCK = new Object();
    private static AppiumDriverLocalService server;
    private static PrintStream serverLogStream;

    /**
     * Starts the local Appium server from code, only if:
     * <ul>
     *   <li>the tests are not running in a cloud environment</li>
     *   <li>the server was not already started by this process or externally</li>
     * </ul>
     *
     * <p>This method uses an explicit synchronization block to guard shared static state.
     * Although the current test execution model is single-threaded, this provides defensive protection
     * against accidental concurrent access, and allows for safe extension to parallel test runs in the future.</p>
     *
     * @param isCloud {@code true} if the tests are running in a cloud environment (e.g. BrowserStack)
     */
    public void startFromCodeIfRequired(boolean isCloud) {
        if (isCloud) {
            return;
        }

        synchronized (LOCK) {
            if (server != null && server.isRunning()) {
                LOG.info("Appium Server was already running (started by this process), Port: {}{}", APPIUM_PORT, System.lineSeparator());
                return;
            }
            if (isAppiumServerRunning(APPIUM_PORT)) {
                LOG.info("Appium Server is already running on port {} (external process){}", APPIUM_PORT, System.lineSeparator());
                return;
            }

            getInstance().start();
            LOG.info("The Appium Server was started from code");
            LOG.info("Appium Server URL: {}", server.getUrl());
            LOG.info("Appium Server is running: {}", server.isRunning() + System.lineSeparator());
        }
    }

    /**
     * Stops the Appium server <strong>only if</strong> it was previously started by this process.
     * <p>
     * Also closes the associated server log stream if it exists.
     * This method uses the same explicit locking mechanism as the startup method to ensure safe access
     * to shared static resources, and to prevent potential race conditions in future parallel executions.
     * </p>
     */
    public void stopIfStartedFromCode() {
        synchronized (LOCK) {
            if (server != null && server.isRunning()) {
                server.stop();
                LOG.info("The Appium Server (started by this process) has been stopped{}", System.lineSeparator());
            }
            if (serverLogStream != null) {
                serverLogStream.close();
                serverLogStream = null;
            }
            server = null;
        }
    }

    /**
     * Checks if the given port is already occupied by an Appium server process.
     *
     * @param port the port to check
     * @return true if the server appears to be running on the given port
     */
    private boolean isAppiumServerRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException _) {
                }
            }
        }
        return isServerRunning;
    }

    private static AppiumDriverLocalService getInstance() {
        if (server == null) {
            setInstance();
        }
        return server;
    }

    // Avoid try-with-resources: OutputStream must remain open for AppiumServer to write logs
    private static void setInstance() {
        String ipAddress = ConfigReader.get(ConfigDataKeys.APPIUM_IP_ADDRESS.getKey());
        String serverLogPath = LogUtils.createServerLogPath();

        try {
            OutputStream outputStream = Files.newOutputStream(Paths.get(serverLogPath));
            serverLogStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ServerLogInitializationException("Could not create server log file at: " + serverLogPath, e);
        }

        String logLevel = ConfigReader.get(ConfigDataKeys.APPIUM_SERVER_LOG_LEVEL.getKey());

        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .withIPAddress(ipAddress)
                .usingPort(APPIUM_PORT)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, logLevel)
                .withArgument(GeneralServerFlag.LOG_TIMESTAMP);

        server = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        server.addOutPutStream(serverLogStream);
    }
}