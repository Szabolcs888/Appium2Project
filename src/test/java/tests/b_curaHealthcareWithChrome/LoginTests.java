package tests.b_curaHealthcareWithChrome;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.b_curaHealthcareWithChrome.HamburgerMenu;
import pages.b_curaHealthcareWithChrome.LoginPage;
import pages.b_curaHealthcareWithChrome.MakeAppointmentPage;
import tests._baseTests.ChromeBrowserBaseTest;
import utils.CommonUtils;

import java.util.List;

@Listeners(TestListener.class)
public class LoginTests extends ChromeBrowserBaseTest {
    private static final Logger log = LogManager.getLogger(LoginTests.class);
    private static final String testDataPath = "src/test/resources/testData/curaHealthcareCredentials.txt";
    private static final String expectedErrorMessage = "Login failed! Please ensure the username and password are valid.";

    @Test(priority = 1,
            groups = {"smoke"})
    public void testLoginWithValidDataCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        log.info("We check if we are on the 'Make Appointment' page");
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            log.info("We are on the 'Make Appointment' page");
        } else {
            log.error("We are not on the 'Make Appointment' page");
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded);
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testLoginWithValidUsernameInvalidPasswordCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput("invalidPassword", "invalid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        log.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(expectedErrorMessage)) {
            log.info("The error message is correct");
        } else {
            log.error("The error message is not correct");
        }
        Assert.assertEquals(errorMessageText, expectedErrorMessage);
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithInvalidUsernameValidPasswordCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("invalidUsername", "invalid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        log.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(expectedErrorMessage)) {
            log.info("The error message is correct");
        } else {
            log.error("The error message is not correct");
        }
        Assert.assertEquals(errorMessageText, expectedErrorMessage);
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

        log.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (errorMessageText.equals(expectedErrorMessage)) {
            log.info("The error message is correct");
        } else {
            log.error("The error message is not correct");
        }
        Assert.assertEquals(errorMessageText, expectedErrorMessage);
    }
}
