package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarechrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarechrome.LoginPage;
import com.myappium2project.pages.curahealthcarechrome.MakeAppointmentPage;

public class LoginTests extends ChromeBrowserBaseTest {
    private static final String EXPECTED_ERROR_MESSAGE = "Login failed! Please ensure the username and password are valid.";

    @Test(priority = 1,
            groups = {"smoke"})
    public void testLoginWithValidDataCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        String makeAppointmentPageName = "Make Appointment";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, makeAppointmentPageName);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, makeAppointmentPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, makeAppointmentPageName);
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded, CuraPageLogMessages.getPageLoadValidationAssertLog(makeAppointmentPageName));
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testLoginWithValidUsernameInvalidPasswordCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(CommonTestData.INVALID_PASSWORD, CommonTestData.INVALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithInvalidUsernameValidPasswordCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CommonTestData.INVALID_USERNAME, CommonTestData.INVALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testLoginWithEmptyUsernameEmptyPasswordCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("", CommonTestData.EMPTY_LOG_MESSAGE);
        loginPage.fillPasswordInput("", CommonTestData.EMPTY_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
    }
}