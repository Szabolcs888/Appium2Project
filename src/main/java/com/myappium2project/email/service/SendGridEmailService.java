package com.myappium2project.email.service;

import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.email.models.SendGridCredentials;
import com.myappium2project.email.providers.SendGridCredentialsProvider;
import com.myappium2project.reporting.email.models.TestResult;
import com.myappium2project.reporting.email.builder.HtmlEmailReportBuilder;
import com.myappium2project.exceptions.LogFileException;
import com.myappium2project.utils.ConfigReader;
import com.myappium2project.configpaths.MainPaths;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Utility class for composing and sending automated test result emails using the SendGrid API.
 * <p>
 * The email includes a formatted HTML report, optional file attachments (e.g. Extent Report, logs),
 * and an embedded link to the online test report.
 * <p>
 * Email credentials and recipients are loaded from {@link SendGridCredentialsProvider}.
 */
public final class SendGridEmailService {
    private static final Logger LOG = LogManager.getLogger(SendGridEmailService.class);

    private static final SendGridCredentials CREDENTIALS = SendGridCredentialsProvider.getCredentials();
    private static final String API_KEY = CREDENTIALS.getApiKey();
    private static final String SENDER_EMAIL = CREDENTIALS.getSenderEmail();
    private static final String RECEIVER_EMAIL = CREDENTIALS.getReceiverEmail();

    private SendGridEmailService() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Sends a test summary email using SendGrid with an HTML report and file attachments.
     *
     * @param testStartDateTime formatted start timestamp of the test run
     * @param testEndDateTime   formatted end timestamp of the test run
     * @param suiteName         the name of the executed test suite
     * @param results           list of individual test results to include in the HTML report;
     *                          if null or empty, a warning message will be shown instead
     */
    public static void sendEmailWithReport(String testStartDateTime, String testEndDateTime, String suiteName, List<TestResult> results) {
        String emailSubject = "Test Results";
        String extentReportPath = MainPaths.EXTENT_REPORT_FILE_PATH.toString();
        String logDirPath = getLatestLogFilePath(MainPaths.TEST_RUN_LOGS_DIR_PATH.toString());
        String serverLogDirPath = getLatestLogFilePath(MainPaths.APPIUM_SERVER_LOGS_DIR_PATH.toString());
        String extentReportLink = ConfigReader.get(ConfigDataKeys.REPORT_NETLIFY_URL.getKey());
        String extentReportLinkInHtml = getHtmlLink(extentReportLink);

        logMissingFiles(extentReportPath, logDirPath, serverLogDirPath);

        String htmlContent;
        if (results == null || results.isEmpty()) {
            LOG.warn("No test results to report — email will include attachments only.");
            htmlContent = "<p><strong>No test cases were executed or reported.</strong></p>";
        } else {
            htmlContent = HtmlEmailReportBuilder.buildReport(testStartDateTime, testEndDateTime, suiteName, results);
        }

        try {
            sendTestResults(emailSubject, htmlContent + extentReportLinkInHtml,
                    Arrays.asList(extentReportPath, logDirPath, serverLogDirPath));
        } catch (IOException e) {
            LOG.error("Failed to send test results email", e);
        }
    }

    private static void logMissingFiles(String extentReportPath, String logPath, String serverLogPath) {
        if (!Files.exists(Path.of(extentReportPath))) {
            LOG.error("The extent-report.html not found: {}", extentReportPath);
        }
        if (!Files.exists(Path.of(logPath))) {
            LOG.warn("Test log file not found: {}", logPath);
        }
        if (!Files.exists(Path.of(serverLogPath))) {
            LOG.warn("Server log file not found: {}", serverLogPath);
        }
    }

    private static void sendTestResults(String subject, String htmlContent, List<String> attachmentPaths) throws IOException {
        Mail mail = createEmail(subject, htmlContent, attachmentPaths);
        sendEmail(mail);
    }

    private static Mail createEmail(String subject, String htmlContent, List<String> attachmentPaths) {
        Email sender = new Email(SENDER_EMAIL);
        Email receiver = new Email(RECEIVER_EMAIL);
        Content content = new Content("text/html", htmlContent);
        Mail mail = new Mail(sender, subject, receiver, content);
        addAttachments(mail, attachmentPaths);
        return mail;
    }

    private static void addAttachments(Mail mail, List<String> attachmentPaths) {
        if (attachmentPaths != null && !attachmentPaths.isEmpty()) {
            for (String attachmentPath : attachmentPaths) {
                File attachmentFile = new File(attachmentPath);
                byte[] fileContent;
                try {
                    fileContent = Files.readAllBytes(attachmentFile.toPath());
                } catch (IOException e) {
                    continue;
                }
                String encodedContent = Base64.getEncoder().encodeToString(fileContent);

                Attachments attachments = new Attachments();
                attachments.setContent(encodedContent);
                attachments.setType("application/octet-stream");
                attachments.setFilename(attachmentFile.getName());
                attachments.setDisposition("attachment");
                mail.addAttachments(attachments);
            }
        }
    }

    private static void sendEmail(Mail mail) throws IOException {
        SendGrid sendGrid = new SendGrid(API_KEY);
        Request request = new Request();
        System.out.println("Waiting to send email...");
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            int httpStatusCode = response.getStatusCode();
            int httpStatusAccepted = 202;
            if (httpStatusCode == httpStatusAccepted) {
                LOG.info("Email successfully sent with status code: {}", httpStatusCode);
            } else {
                LOG.error("Failed to send email! Status code: {}", httpStatusCode);
            }
        } catch (IOException ex) {
            LOG.error("Failed to send email: {}", ex.getMessage());
            throw ex;
        }
    }

    private static String getHtmlLink(String link) {
        String htmlLink = "<h2>Extent Report</h2>" +
                "<p>A detailed report can be found at the following link:</p>" +
                "<a href=\"" + link + "\">View Extent Report</a>";
        return htmlLink;
    }

    private static String getLatestLogFilePath(String logsDirectoryPath) {
        try (Stream<Path> files = Files.list(Paths.get(logsDirectoryPath))) {
            return files
                    .filter(p -> p.toString().endsWith(".log"))
                    .max(Comparator.comparingLong(p -> p.toFile().lastModified()))
                    .map(Path::toString)
                    .orElseThrow(() -> new RuntimeException("No .log files found in: " + logsDirectoryPath));
        } catch (IOException e) {
            throw new LogFileException("Failed to read log directory: " + logsDirectoryPath, e);
        }
    }
}