package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserTestBase;
import com.myappium2project.testsdata.CuraHealthcareData;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarechrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarechrome.LoginPage;
import com.myappium2project.pages.curahealthcarechrome.MakeAppointmentPage;

public class LoginTests extends ChromeBrowserTestBase {
    private static final String EXPECTED_ERROR_MESSAGE = "Login failed! Please ensure the username and password are valid.";

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
    public void testLoginWithValidDataCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        String makeAppointmentPageName = "Make Appointment";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, makeAppointmentPageName);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, makeAppointmentPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, makeAppointmentPageName);
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded, CuraPageLogMessages.pageNotLoadAssertLog(makeAppointmentPageName));
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testLoginWithValidUsernameInvalidPasswordCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CommonTestLogMessages.INVALID_PASSWORD_LOG, CommonTestLogMessages.INVALID_LOG);
        loginPage.pressLoginButton();

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

    @Test(priority = 3,
            groups = {TestGroups.SMOKE})
    public void testLoginWithInvalidUsernameValidPasswordCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CommonTestLogMessages.INVALID_USERNAME_LOG, CommonTestLogMessages.INVALID_LOG);
        loginPage.fillPasswordInput(CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

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

    @Test(priority = 4,
            groups = {TestGroups.SMOKE})
    public void testLoginWithEmptyUsernameEmptyPasswordCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("", CommonTestLogMessages.EMPTY_LOG);
        loginPage.fillPasswordInput("", CommonTestLogMessages.EMPTY_LOG);
        loginPage.pressLoginButton();

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