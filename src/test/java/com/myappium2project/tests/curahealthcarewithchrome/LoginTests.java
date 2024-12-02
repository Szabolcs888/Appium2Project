package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;

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
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        String makeAppointmentPageName = "Make Appointment";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), makeAppointmentPageName);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), makeAppointmentPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), makeAppointmentPageName);
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded, CommonTestLogMessages.getPageLoadErrorAssertLog(makeAppointmentPageName));
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
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.getErrorMessageErrorAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
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
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.getErrorMessageErrorAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
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
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                CommonTestLogMessages.getErrorMessageErrorAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE));
    }
}