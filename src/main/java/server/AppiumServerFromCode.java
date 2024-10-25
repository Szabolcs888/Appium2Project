package server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServerFromCode {
    private static final Logger log = LogManager.getLogger(AppiumServerFromCode.class);
    static AppiumDriverLocalService server;

    public void startAppiumServer() {
        if (!isAppiumServerRunning(4723)) {
            getInstance().start();
            log.info("The Appium Server starts from code");
            System.out.println("URL: " + server.getUrl());
            System.out.println("Is Server Running: " + server.isRunning());
        } else {
            System.out.println("Appium Server is running on port 4723\n");
        }
    }

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
                } catch (IOException e) {
                }
            }
        }
        return isServerRunning;
    }

    static AppiumDriverLocalService getInstance() {
        if (server == null) {
            setInstance();
        }
        return server;
    }

    static void setInstance() {
        String nodeJSMainPath = "c:/Users/szigl/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
        String nodeExePath = "c:/Program Files/nodejs/node.exe";
        String logFilePath = System.getProperty("user.dir") + "/logs/serverLog.log";

        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder
                .withAppiumJS(new File(nodeJSMainPath))
                .usingDriverExecutable(new File(nodeExePath))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(logFilePath))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

        server = AppiumDriverLocalService.buildService(appiumServiceBuilder);
    }

    public void stopAppiumServer() {
        if (server != null && server.isRunning()) {
            getInstance().stop();
            log.info("The Appium Server is down\n");
        }
    }
}

