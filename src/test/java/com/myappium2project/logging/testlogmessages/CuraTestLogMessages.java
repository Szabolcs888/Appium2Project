package com.myappium2project.logging.testlogmessages;

/**
 * Cura Healthcare log messages used across Cura Healthcare tests.
 * This class is not meant to be instantiated.
 */
public final class CuraTestLogMessages {
    public static final String CHECK_APPOINTMENT_DATA_LOG = "We check if the appointment data matches the ones we provided";
    public static final String ORIGINAL_APPOINTMENT_DATA_LOG = "Original appointment data: " + System.lineSeparator();
    public static final String CORRECT_APPOINTMENT_DATA_LOG = "The appointment data is correct on the '{}' page.";
    public static final String INCORRECT_APPOINTMENT_DATA_LOG = "The appointment data is not correct on the '{}', page.";
    public static final String INCORRECT_APPOINTMENT_DATA_ASSERT_LOG = "The appointment data should match the provided data, but it does not.";

    private CuraTestLogMessages() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String appointmentDataLog(String pageName) {
        return String.format("The appointment data is on the '%s', page: %n", pageName);
    }

    public static String incorrectAppointmentDataAssertLog(String pageName) {
        return String.format("The appointment data on the '%s' page should match the provided data, but it does not.", pageName);
    }
}