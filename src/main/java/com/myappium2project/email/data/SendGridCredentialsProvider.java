package com.myappium2project.email.data;

import com.myappium2project.utils.JsonDataReader;
import com.myappium2project.configpaths.MainPaths;

/**
 * Utility class for providing access to {@link SendGridCredentials} loaded from a JSON resource.
 * <p>
 * The credentials are loaded once statically from the path defined in {@link MainPaths#SENDGRID_CREDENTIALS_JSON},
 * and can be accessed via the {@link #getCredentials()} method.
 */
public class SendGridCredentialsProvider {
    private static final SendGridCredentials credentials;

    static {
        credentials = JsonDataReader.readJsonFromResource(MainPaths.SENDGRID_CREDENTIALS_JSON, SendGridCredentials.class);
    }

    private SendGridCredentialsProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static SendGridCredentials getCredentials() {
        return credentials;
    }
}