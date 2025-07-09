package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.configdata.configpaths.AppConfig;
import com.myappium2project.configdata.models.accounts.CuraHealthcareAccount;
import com.myappium2project.configdata.providers.accounts.CuraHealthcareAccountProvider;
import com.myappium2project.configdata.testinputs.TestInputMocks;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.BrowserTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.webapps.curahealthcare.HamburgerMenu;
import com.myappium2project.pages.webapps.curahealthcare.LoginPage;
import com.myappium2project.pages.webapps.curahealthcare.MakeAppointmentPage;

/**
 * Verifies the login functionality for the app with valid and/or invalid credentials.
 */
public class LoginTests extends BrowserTestBase {
    private static final String EXPECTED_ERROR_MESSAGE = "Login failed! Please ensure the username and password are valid.";
    private static final CuraHealthcareAccount CURA_ACC1 = CuraHealthcareAccountProvider.getAccount(0);

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
    public void testLoginValidData() {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        CuraCommonSteps.loginToCura(driver, hamburgerMenu, CURA_ACC1);

        String makeAppointmentPageName = "Make Appointment";
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded(AppConfig.CURA_MAKE_APPOINTMENT_PAGE_URL);
        CuraCommonAssertions.verifyPageLoaded(isMakeAppointmentPageLoaded, makeAppointmentPageName);
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testLoginValidUsernameInvalidPassword() {
        attemptInvalidLogin(CURA_ACC1.getUsername(), CommonTestLogMessages.VALID_LOG,
                TestInputMocks.getInvalidPassword(), CommonTestLogMessages.INVALID_LOG);
    }

    @Test(priority = 3,
            groups = {TestGroups.SMOKE})
    public void testLoginInvalidUsernameValidPassword() {
        attemptInvalidLogin(TestInputMocks.getInvalidUsername(), CommonTestLogMessages.INVALID_LOG,
                CURA_ACC1.getPassword(), CommonTestLogMessages.VALID_LOG);
    }

    @Test(priority = 4,
            groups = {TestGroups.SMOKE})
    public void testLoginEmptyUsernameEmptyPassword() {
        attemptInvalidLogin(TestInputMocks.getEmptyString(), CommonTestLogMessages.EMPTY_LOG,
                TestInputMocks.getEmptyString(), CommonTestLogMessages.EMPTY_LOG);
    }

    private void attemptInvalidLogin(String username, String usernameLogContext,
                                     String password, String passwordLogContext) {
        driver.get(AppConfig.CURA_BASE_URL);
        LOG.info("We navigate to CURA base URL: {}", AppConfig.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(username, usernameLogContext);
        loginPage.fillPasswordInput(password, passwordLogContext);
        loginPage.pressLoginButton();

        verifyErrorMessage(loginPage);
    }

    private void verifyErrorMessage(LoginPage loginPage) {
        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (EXPECTED_ERROR_MESSAGE.equals(errorMessageText)) {
            LOG.info(CommonTestLogMessages.CORRECT_ERROR_MESSAGE_LOG);
        } else {
            LOG.error(CommonTestLogMessages.INCORRECT_ERROR_MESSAGE_LOG);
        }

        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.incorrectErrorMessageAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
    }
}