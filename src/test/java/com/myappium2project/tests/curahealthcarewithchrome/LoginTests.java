package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;

public class LoginTests extends ChromeBrowserBaseTest {
    private static final String LOG_CHECK_ERROR_MESSAGE = "We check whether the error message appears and, if so, whether it is correct";
    private static final String LOG_ERROR_MESSAGE_CORRECT = "The error message is correct";
    private static final String LOG_ERROR_MESSAGE_INCORRECT = "The error message is not correct";
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

        LOG.info("We check if we are on the 'Make Appointment' page");
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info("We are on the 'Make Appointment' page");
        } else {
            LOG.error("We are not on the 'Make Appointment' page");
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded, "The 'Make Appointment' page should be loaded, but it is not.");
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

        LOG.info(LOG_CHECK_ERROR_MESSAGE);
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(LOG_ERROR_MESSAGE_CORRECT);
        } else {
            LOG.error(LOG_ERROR_MESSAGE_INCORRECT);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                "The error message should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
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

        LOG.info(LOG_CHECK_ERROR_MESSAGE);
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(LOG_ERROR_MESSAGE_CORRECT);
        } else {
            LOG.error(LOG_ERROR_MESSAGE_INCORRECT);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                "The error message should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
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

        LOG.info(LOG_CHECK_ERROR_MESSAGE);
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(LOG_ERROR_MESSAGE_CORRECT);
        } else {
            LOG.error(LOG_ERROR_MESSAGE_INCORRECT);
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                "The error message should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }
}