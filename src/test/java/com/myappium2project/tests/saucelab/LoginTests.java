package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SLabTestLogMessages;
import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataSaucelab;
import org.testng.Assert;
import com.myappium2project.pages.saucelab.HamburgerMenu;
import com.myappium2project.pages.saucelab.LoginPage;
import com.myappium2project.pages.saucelab.ProductsPage;
import org.testng.annotations.Test;

public class LoginTests extends SauceLabApkBaseTest {
    private static final String EXPECTED_ERROR_MESSAGE_INCORRECT_DATA = "Provided credentials do not match any user in this service.";
    private static final String EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME = "Username is required";
    private static final String EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD = "Password is required";
    private static final String ERROR_MESSAGE_VALIDATION_ASSERTLOG = "The error message should be displayed, but it is not.";

    @Test(priority = 5,
            groups = {"smoke"})
    public void testLoginWithValidData() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        String productsPageName = "Products";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), productsPageName);
        ProductsPage productPage = new ProductsPage(driver);
        String productPageTitleText = productPage.getProductPageTitleText();
        if (productPageTitleText.equals(productsPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), productsPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), productsPageName);
        }
        Assert.assertEquals(productPageTitleText, productsPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(productsPageName));
    }

    @Test(priority = 1,
            groups = {"smoke"})
    public void testLoginWithValidUsernameInvalidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(CommonTestData.INVALID_PASSWORD, CommonTestData.INVALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getIncorrectDataErrorMessageText();
        LOG.info(CommonTestLogMessages.getExpectedErrorMessageLog(), errorMessageText);
        if (loginPage.isDisplayedIncorrectDataErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE_INCORRECT_DATA)) {
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        } else {
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertTrue(loginPage.isDisplayedIncorrectDataErrorMessage(), ERROR_MESSAGE_VALIDATION_ASSERTLOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA));
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testLoginWithInvalidUsernameValidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CommonTestData.INVALID_USERNAME, CommonTestData.INVALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getIncorrectDataErrorMessageText();
        LOG.info(CommonTestLogMessages.getExpectedErrorMessageLog(), errorMessageText);
        if (loginPage.isDisplayedIncorrectDataErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE_INCORRECT_DATA))
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        else
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        Assert.assertTrue(loginPage.isDisplayedIncorrectDataErrorMessage(), ERROR_MESSAGE_VALIDATION_ASSERTLOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA));
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithEmptyUsernameValidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("", CommonTestData.EMPTY_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getEmptyUsernameErrorMessageText();
        LOG.info(CommonTestLogMessages.getExpectedErrorMessageLog(), errorMessageText);
        if (loginPage.isDisplayedEmptyUsernameErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME))
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        else
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        Assert.assertTrue(loginPage.isDisplayedEmptyUsernameErrorMessage(), ERROR_MESSAGE_VALIDATION_ASSERTLOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME));
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testLoginWithValidUsernameEmptyPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput("", CommonTestData.EMPTY_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getEmptyPasswordErrorMessageText();
        LOG.info(CommonTestLogMessages.getExpectedErrorMessageLog(), errorMessageText);
        if (loginPage.isDisplayedEmptyPasswordErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD))
            LOG.info(CommonTestLogMessages.ERROR_MESSAGE_CORRECT_LOG);
        else
            LOG.error(CommonTestLogMessages.ERROR_MESSAGE_INCORRECT_ERRORLOG);
        Assert.assertTrue(loginPage.isDisplayedEmptyPasswordErrorMessage(), ERROR_MESSAGE_VALIDATION_ASSERTLOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD,
                CommonTestLogMessages.getErrorMessageValidationAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD));
    }
}