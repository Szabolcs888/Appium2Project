package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SlabTestLogMessages;
import com.myappium2project.tests.basetests.SauceLabApkTestBase;
import com.myappium2project.testsdata.SaucelabData;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import com.myappium2project.pages.saucelab.HamburgerMenu;
import com.myappium2project.pages.saucelab.LoginPage;
import com.myappium2project.pages.saucelab.ProductsPage;
import org.testng.annotations.Test;

public class LoginTests extends SauceLabApkTestBase {
    private static final String EXPECTED_ERROR_MESSAGE_INCORRECT_DATA = "Provided credentials do not match any user in this service.";
    private static final String EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME = "Username is required";
    private static final String EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD = "Password is required";
    private static final String ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG = "The error message should be displayed, but it is not.";

    @Test(priority = 5,
            groups = {TestGroups.SMOKE})
    public void testLoginWithValidData() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(SaucelabData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(SaucelabData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        String productsPageName = "Products";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, productsPageName);
        ProductsPage productPage = new ProductsPage(driver);
        String productPageTitleText = productPage.getProductPageTitleText();
        if (productPageTitleText.equals(productsPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, productsPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, productsPageName);
        }
        Assert.assertEquals(productPageTitleText, productsPageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(productsPageName));
    }

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
    public void testLoginWithValidUsernameInvalidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(SaucelabData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CommonTestLogMessages.INVALID_PASSWORD_LOG, CommonTestLogMessages.INVALID_LOG);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getIncorrectDataErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (loginPage.isDisplayedIncorrectDataErrorMessage() &&
                EXPECTED_ERROR_MESSAGE_INCORRECT_DATA.equals(errorMessageText)) {
            LOG.info(CommonTestLogMessages.CORRECT_ERROR_MESSAGE_LOG);
        } else {
            LOG.error(CommonTestLogMessages.INCORRECT_ERROR_MESSAGE_LOG);
        }
        Assert.assertTrue(loginPage.isDisplayedIncorrectDataErrorMessage(), ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA,
                CommonTestLogMessages.incorrectErrorMessageAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA));
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testLoginWithInvalidUsernameValidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CommonTestLogMessages.INVALID_USERNAME_LOG, CommonTestLogMessages.INVALID_LOG);
        loginPage.fillPasswordInput(SaucelabData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getIncorrectDataErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (loginPage.isDisplayedIncorrectDataErrorMessage() &&
                EXPECTED_ERROR_MESSAGE_INCORRECT_DATA.equals(errorMessageText)) {
            LOG.info(CommonTestLogMessages.CORRECT_ERROR_MESSAGE_LOG);
        } else {
            LOG.error(CommonTestLogMessages.INCORRECT_ERROR_MESSAGE_LOG);
        }
        Assert.assertTrue(loginPage.isDisplayedIncorrectDataErrorMessage(), ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA,
                CommonTestLogMessages.incorrectErrorMessageAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA));
    }

    @Test(priority = 3,
            groups = {TestGroups.SMOKE})
    public void testLoginWithEmptyUsernameValidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("", CommonTestLogMessages.EMPTY_LOG);
        loginPage.fillPasswordInput(SaucelabData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getEmptyUsernameErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (loginPage.isDisplayedEmptyUsernameErrorMessage() &&
                EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME.equals(errorMessageText)) {
            LOG.info(CommonTestLogMessages.CORRECT_ERROR_MESSAGE_LOG);
        } else {
            LOG.error(CommonTestLogMessages.INCORRECT_ERROR_MESSAGE_LOG);
        }
        Assert.assertTrue(loginPage.isDisplayedEmptyUsernameErrorMessage(), ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME,
                CommonTestLogMessages.incorrectErrorMessageAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME));
    }

    @Test(priority = 4,
            groups = {TestGroups.SMOKE})
    public void testLoginWithValidUsernameEmptyPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(SaucelabData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput("", CommonTestLogMessages.EMPTY_LOG);
        loginPage.pressLoginButton();

        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        String errorMessageText = loginPage.getEmptyPasswordErrorMessageText();
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, errorMessageText);
        if (loginPage.isDisplayedEmptyPasswordErrorMessage() &&
                EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD.equals(errorMessageText)) {
            LOG.info(CommonTestLogMessages.CORRECT_ERROR_MESSAGE_LOG);
        } else {
            LOG.error(CommonTestLogMessages.INCORRECT_ERROR_MESSAGE_LOG);
        }
        Assert.assertTrue(loginPage.isDisplayedEmptyPasswordErrorMessage(), ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD,
                CommonTestLogMessages.incorrectErrorMessageAssertLog(errorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD));
    }
}