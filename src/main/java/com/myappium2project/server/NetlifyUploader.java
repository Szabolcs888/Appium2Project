package com.myappium2project.server;

import java.io.File;
import java.io.IOException;

public class NetlifyUploader {

    public static void uploadReportToNetlify() {
        try {
            String reportsDirectory = "C:/munka/repositoryProjects/Appium2/Appium2Project/reports";
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "C:/Program Files/Git/bin/bash.exe", "-c", "netlify deploy --prod --dir=\"" + reportsDirectory + "\"");
            processBuilder.directory(new File(reportsDirectory));
            Process process = processBuilder.start();
            System.out.println("Waiting for the report to be uploaded to the server...");

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Report uploaded to Netlify\n");
            } else {
                System.out.println("Error uploading report. Exit code: " + exitCode + " \n");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Exception occurred during report upload: " + e);
        }
    }
}
