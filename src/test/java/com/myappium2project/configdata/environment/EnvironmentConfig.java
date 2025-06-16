package com.myappium2project.configdata.environment;

import com.myappium2project.configdata.enums.TestEnvironment;
import com.myappium2project.configkeys.ConfigDataKeys;
import com.myappium2project.utils.ConfigReader;

/**
 * Provides centralized access to the current test execution environment.
 * <p>
 * Determines whether tests are running locally or in the cloud based on the {@code config.properties}
 * value for {@code run.environment}.
 */
public class EnvironmentConfig {
    private static final TestEnvironment ENVIRONMENT;

    static {
        String rawEnvironment = ConfigReader.get(ConfigDataKeys.RUN_ENVIRONMENT.getKey());
        ENVIRONMENT = TestEnvironment.from(rawEnvironment);
    }

    private EnvironmentConfig() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static TestEnvironment getEnvironment() {
        return ENVIRONMENT;
    }

    public static boolean isCloud() {
        return ENVIRONMENT.isCloud();
    }

    public static boolean isLocal() {
        return ENVIRONMENT.isLocal();
    }
}