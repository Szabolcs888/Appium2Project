package com.myappium2project.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.myappium2project.utils.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * Class for email sending operations.
 */
public class SendGridEmailHelper {
    private static final Logger LOG = LogManager.getLogger(SendGridEmailHelper.class);
    private static final String EMAIL_SENDING_DATA_PATH = "src/main/resources/emailsendingdata/sendGridCredentials.txt";
    private static final List<String> EMAIL_SENDING_DATA = CommonUtils.readDataFromFile(EMAIL_SENDING_DATA_PATH);
    private static final String API_KEY = EMAIL_SENDING_DATA.get(0);
    private static final String FROM_EMAIL = EMAIL_SENDING_DATA.get(1);
    private static final String TO_EMAIL = EMAIL_SENDING_DATA.get(2);

    public void sendEmailWithReport(String testStartDateTime, String testEndDateTime) {
        String emailSubject = "Test Results";
        String emailTextContent = "<h3>The test was run at: " + testStartDateTime + " - " + testEndDateTime + "</h3>";
        String emailableReportPath = "target/surefire-reports/emailable-report.html";
        String extentReportPath = "reports/extent-report.html";
        String logPath = "logs/logFile.log";
        String serverLogPath = "logs/serverLog.log";
        String extentReportlink = "https://appiumreports.netlify.app/extent-report.html#";
        String extentReportlinkInHtml = getHtmlLink(extentReportlink);

        try {
            String htmlContent = readHtmlFromFile(emailableReportPath);
            SendGridEmailHelper sendGridEmailHelper = new SendGridEmailHelper();
            sendGridEmailHelper.sendTestResults(
                    emailSubject, emailTextContent + System.lineSeparator() +
                            htmlContent + extentReportlinkInHtml,
                    Arrays.asList(emailableReportPath, extentReportPath, logPath, serverLogPath));
        } catch (IOException e) {
            LOG.error("Failed to send test results email", e);
        }
    }

    private static void sendTestResults(
            String subject, String htmlContent, List<String> attachmentPaths) throws IOException {
        Mail mail = createEmail(subject, htmlContent, attachmentPaths);
        sendEmail(mail);
    }

    private static Mail createEmail(String subject, String htmlContent, List<String> attachmentPaths) {
        Email from = new Email(FROM_EMAIL);
        Email to = new Email(TO_EMAIL);
        Content content = new Content("text/html", htmlContent);
        Mail mail = new Mail(from, subject, to, content);
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
            System.out.println("Email successfully sent with status code: " + response.getStatusCode());
        } catch (IOException ex) {
            System.out.println("Failed to send email: " + ex.getMessage());
            throw ex;
        }
    }

    private static String readHtmlFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(new File(filePath).toPath()), StandardCharsets.UTF_8);
    }

    private static String getHtmlLink(String link) {
        String htmlLink = "<h1>Extent Report</h1>" +
                "<p>A detailed report can be found at the following link:</p>" +
                "<a href=\"" + link + "\">View Extent Report</a>";
        return htmlLink;
    }
}