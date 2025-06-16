package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.configdata.models.accounts.SauceLabsAppAccount;
import com.myappium2project.configdata.providers.accounts.SauceLabsAppAccountProvider;
import com.myappium2project.configdata.testinputs.TestInputMocks;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import com.myappium2project.pages.nativeapps.saucelabs.HamburgerMenu;
import com.myappium2project.pages.nativeapps.saucelabs.LoginPage;
import com.myappium2project.pages.nativeapps.saucelabs.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends SauceLabsAppTestBase {
    private static final String EXPECTED_ERROR_MESSAGE_INCORRECT_DATA = "Provided credentials do not match any user in this service.";
    private static final String EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME = "Username is required";
    private static final String EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD = "Password is required";
    private static final String ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG = "The error message should be displayed, but it is not.";

    private static final SauceLabsAppAccount SAUCE_ACC1 = SauceLabsAppAccountProvider.getAccount(0);

    private HamburgerMenu hamburgerMenu;

    @BeforeMethod(alwaysRun = true)
    public void initializeHamburgerMenu() {
        hamburgerMenu = new HamburgerMenu(driver, wait);
    }

    @Test(priority = 5,
            groups = {TestGroups.SMOKE})
    public void testLoginValidData() throws InterruptedException {
        SauceLabsCommonSteps.loginToSauceLabs(driver, hamburgerMenu, SAUCE_ACC1);

        String productsPageName = "Products";
        ProductsPage productPage = new ProductsPage(driver);
        String productPageTitleText = productPage.getProductPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(productPageTitleText, productsPageName);
    }

    @Test(priority = 1, groups = {TestGroups.SMOKE})
    public void testLoginValidUsernameInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        attemptInvalidLogin(SAUCE_ACC1.getEmail(), CommonTestLogMessages.VALID_LOG,
                TestInputMocks.getInvalidPassword(), CommonTestLogMessages.INVALID_LOG, loginPage);

        String actualErrorMessageText = loginPage.getIncorrectDataErrorMessageText();
        verifyErrorMessage(loginPage.isDisplayedIncorrectDataErrorMessage(),
                actualErrorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA);
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testLoginInvalidUsernameValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        attemptInvalidLogin(TestInputMocks.getInvalidUsername(), CommonTestLogMessages.INVALID_LOG,
                SAUCE_ACC1.getPassword(), CommonTestLogMessages.VALID_LOG, loginPage);

        String actualErrorMessageText = loginPage.getIncorrectDataErrorMessageText();
        verifyErrorMessage(loginPage.isDisplayedIncorrectDataErrorMessage(),
                actualErrorMessageText, EXPECTED_ERROR_MESSAGE_INCORRECT_DATA);
    }

    @Test(priority = 3,
            groups = {TestGroups.SMOKE})
    public void testLoginEmptyUsernameValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        attemptInvalidLogin(TestInputMocks.getEmptyString(), CommonTestLogMessages.EMPTY_LOG,
                SAUCE_ACC1.getPassword(), CommonTestLogMessages.VALID_LOG, loginPage);

        String actualErrorMessageText = loginPage.getEmptyUsernameErrorMessageText();
        verifyErrorMessage(loginPage.isDisplayedEmptyUsernameErrorMessage(),
                actualErrorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_USERNAME);
    }

    @Test(priority = 4,
            groups = {TestGroups.SMOKE})
    public void testLoginValidUsernameEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        attemptInvalidLogin(SAUCE_ACC1.getEmail(), CommonTestLogMessages.VALID_LOG,
                TestInputMocks.getEmptyString(), CommonTestLogMessages.EMPTY_LOG, loginPage);

        String actualErrorMessageText = loginPage.getEmptyPasswordErrorMessageText();
        verifyErrorMessage(loginPage.isDisplayedEmptyPasswordErrorMessage(),
                actualErrorMessageText, EXPECTED_ERROR_MESSAGE_EMPTY_PASSWORD);
    }

    private void attemptInvalidLogin(String username, String usernameLogContext,
                                     String password, String passwordLogContext, LoginPage loginPage) throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        loginPage.fillUserNameInput(username, usernameLogContext);
        loginPage.fillPasswordInput(password, passwordLogContext);
        loginPage.pressLoginButton();
    }

    private void verifyErrorMessage(boolean isDisplayed, String actualMessage, String expectedMessage) {
        LOG.info(CommonTestLogMessages.CHECK_ERROR_MESSAGE_LOG);
        LOG.info(CommonTestLogMessages.EXPECTED_ERROR_MESSAGE_LOG, actualMessage);
        if (isDisplayed && expectedMessage.equals(actualMessage)) {
            LOG.info(CommonTestLogMessages.CORRECT_ERROR_MESSAGE_LOG);
        } else {
            LOG.error(CommonTestLogMessages.INCORRECT_ERROR_MESSAGE_LOG);
        }

        Assert.assertTrue(isDisplayed, ERROR_MESSAGE_NOT_APPEAR_ASSERT_LOG);
        Assert.assertEquals(actualMessage, expectedMessage,
                CommonTestLogMessages.incorrectErrorMessageAssertLog(actualMessage, expectedMessage));
    }
}