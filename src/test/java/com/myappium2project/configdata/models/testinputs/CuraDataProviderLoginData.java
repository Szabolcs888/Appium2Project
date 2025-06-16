package com.myappium2project.configdata.models.testinputs;

/**
 * Data model representing input values and expected outcomes for login tests
 * of the CURA Healthcare web application.
 * <p>
 * Primarily used with data-driven test methods (e.g., TestNG DataProviders)
 * to validate different login scenarios including valid and invalid credentials.
 */
public class CuraDataProviderLoginData {
    private String username;
    private String usernameStatus;
    private String password;
    private String passwordStatus;
    private boolean expectedResult;

    public CuraDataProviderLoginData() {
    }

    public String getUsername() {
        return username;
    }

    public String getUsernameStatus() {
        return usernameStatus;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordStatus() {
        return passwordStatus;
    }

    public boolean isExpectedResult() {
        return expectedResult;
    }

    @Override
    public String toString() {
        return "CuraDataProviderLoginData{" +
                "username='" + username + '\'' +
                ", usernameStatus='" + usernameStatus + '\'' +
                ", password='" + password + '\'' +
                ", passwordStatus='" + passwordStatus + '\'' +
                ", expectedResult=" + expectedResult +
                '}';
    }
}