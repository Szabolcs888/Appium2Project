package com.myappium2project.email.data;

/**
 * POJO class representing the SendGrid email credentials loaded from a JSON file.
 */
public class SendGridCredentials {
    private String apiKey;
    private String senderEmail;
    private String receiverEmail;

    public SendGridCredentials() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    @Override
    public String toString() {
        return "SendGridCredentials{" +
                "apiKey='" + apiKey + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                '}';
    }
}