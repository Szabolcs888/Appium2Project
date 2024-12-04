package com.myappium2project.logging.testlogmessages;

public class CuraTestLogMessages {
    public static final String CHECK_APPOINTMENT_DATA_LOG = "We check if the appointment data matches the ones we provided";
    public static final String ORIGINAL_APPOINTMENT_DATA_CONSOLELOG = "Original appointment data: \n";
    public static final String CORRECT_APPOINTMENT_DATA_LOG = "The appointment data is correct on the '{}' page.";
    public static final String INCORRECT_APPOINTMENT_DATA_ERRORLOG = "The appointment data is not correct on the '{}', page.";
    public static final String APPOINTMENT_DATA_VALIDATION_ASSERTLOG = "The appointment data should match the provided data, but it does not.";

    public static String getAppointmentDataConsoleLog(String pageName) {
        return String.format("The appointment data is on the '%s', page: \n", pageName);
    }

    public static String getAppointmentDataValidationAssertLog(String pageName) {
        return String.format("The appointment data on the '%s' page should match the provided data, but it does not.", pageName);
    }
}