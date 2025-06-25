package com.myappium2project.configdata.models.accounts;

/**
 * Data model representing a user account and appointment details for the CURA Healthcare web application.
 * <p>
 * Typically used to populate test inputs for login and appointment scheduling.
 */
public class CuraHealthcareAccount {
    private String username;
    private String password;
    private String facility;
    private String readmission;
    private String healthcareProgram;
    private String visitDate;
    private String comment;

    /**
     * Default constructor required for JSON deserialization.
     */
    public CuraHealthcareAccount() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFacility() {
        return facility;
    }

    public String getReadmission() {
        return readmission;
    }

    public String getHealthcareProgram() {
        return healthcareProgram;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "CuraAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", facility='" + facility + '\'' +
                ", readmission='" + readmission + '\'' +
                ", healthcareProgram='" + healthcareProgram + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}