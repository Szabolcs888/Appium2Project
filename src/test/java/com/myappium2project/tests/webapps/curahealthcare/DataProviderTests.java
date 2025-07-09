package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.configdata.configpaths.AppConfig;
import com.myappium2project.configdata.providers.testinputs.CuraLoginTestDataProvider;
import com.myappium2project.tests.basetests.BrowserTestBase;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myappium2project.pages.webapps.curahealthcare.HamburgerMenu;
import com.myappium2project.pages.webapps.curahealthcare.LoginPage;
import com.myappium2project.pages.webapps.curahealthcare.MakeAppointmentPage;

/**
 * Test class for login functionality of the Cura Healthcare web application.
 * <p>
 * This test class uses TestNG's DataProvider to verify login behavior with various credential combinations.
 * It dynamically sets the test name for better reporting via the {@link ITest} interface.
 * <p>
 * The test runs in a browser environment and inherits setup/teardown logic from {@link BrowserTestBase}.
 */
public class DataProviderTests extends BrowserTestBase implements ITest {
    private static final int LOGIN_DATA_MIN_LENGTH = 4;

    /**
     * Stores the current test name for use with TestNG and reporting tools (e.g. ExtentReports).
     * Ensures each test case generated via DataProvider has a descriptive name.
     */
    private static final ThreadLocal<String> testName = new ThreadLocal<>();

    /**
     * Returns the current test name used by TestNG and reporting frameworks.
     * This is required to support dynamic test names when using DataProvider.
     *
     * @return the dynamically generated test name
     */
    @Override
    public String getTestName() {
        return testName.get();
    }

    /**
     * Hook that runs before each test method.
     * Extracts values from the test data array to construct a descriptive test name
     * based on the username and password validity.
     *
     * @param data an array of parameters provided by the DataProvider
     */
    @BeforeMethod(alwaysRun = true)
    public void initDataDrivenTestName(Object[] data) {
        if (data.length >= LOGIN_DATA_MIN_LENGTH) {
            String username = String.valueOf(data[0]);
            String usernameStatus = String.valueOf(data[1]);
            String password = String.valueOf(data[2]);
            String passwordStatus = String.valueOf(data[3]);

            testName.set(String.format("Login with user='%s' (%s), password='%s' (%s)",
                    username, usernameStatus, password, passwordStatus));
        }
    }

    /**
     * Tests the login functionality of the Cura Healthcare web application using multiple data sets.
     * The test attempts to log in and checks whether the actual outcome matches the expected result.
     *
     * @param username               the username input
     * @param usernameValidityStatus whether the username is valid or not (e.g., "valid", "invalid")
     * @param password               the password input
     * @param passwordValidityStatus whether the password is valid or not
     * @param expectedResult         the expected outcome of the login attempt (true = success)
     */
    @Test(dataProvider = "curaLoginDataFromJson", dataProviderClass = CuraLoginTestDataProvider.class)
    public void testsAllLogin(
            String username, String usernameValidityStatus, String password,
            String passwordValidityStatus, boolean expectedResult) {
        driver.get(AppConfig.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(username, usernameValidityStatus);
        loginPage.fillPasswordInput(password, passwordValidityStatus);
        loginPage.pressLoginButton();

        String loginExpectedResultMessage = getLoginExpectedResultMessage(expectedResult);

        LOG.info("We check if the login is successful. The expected result: {}", loginExpectedResultMessage);

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded(AppConfig.CURA_MAKE_APPOINTMENT_PAGE_URL);
        logLoginResult(isMakeAppointmentPageLoaded);

        Assert.assertEquals(isMakeAppointmentPageLoaded, expectedResult,
                "The login result should be '" + expectedResult + "', but it is '" + isMakeAppointmentPageLoaded + "'.");
    }

    /**
     * Returns a textual description of the expected login result.
     *
     * @param expectedResult true if login is expected to succeed
     * @return "successful login" or "failed login"
     */
    private static String getLoginExpectedResultMessage(boolean expectedResult) {
        return expectedResult ? "successful login" : "failed login";
    }

    private void logLoginResult(boolean isSuccessful) {
        String resultMessage = isSuccessful ? "Login is successful" : "Login failed";
        LOG.info(resultMessage);
    }
}