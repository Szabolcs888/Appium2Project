package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.utils.TestDataFilePaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;
import com.myappium2project.utils.CommonUtils;

import java.util.List;

public class LoginTests extends ChromeBrowserBaseTest {
    private static final Logger LOG = LogManager.getLogger(LoginTests.class);
    private static final String TEST_DATA_PATH = TestDataFilePaths.CURA_TEST_DATA_PATH;
    private static final String EXPECTED_ERROR_MESSAGE = "Login failed! Please ensure the username and password are valid.";

    @Test(priority = 1,
            groups = {"smoke"})
    public void testLoginWithValidDataCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
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
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput("invalidPassword", "invalid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info("The error message is correct");
        } else {
            LOG.error("The error message is not correct");
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE, "The error message should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithInvalidUsernameValidPasswordCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("invalidUsername", "invalid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info("The error message is correct");
        } else {
            LOG.error("The error message is not correct");
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE, "The error message should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testLoginWithEmptyUsernameEmptyPasswordCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("", "empty");
        loginPage.fillPasswordInput("", "empty");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info("The error message is correct");
        } else {
            LOG.error("The error message is not correct");
        }
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE, "The error message should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }
}
