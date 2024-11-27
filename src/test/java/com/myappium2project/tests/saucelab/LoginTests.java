package com.myappium2project.tests.saucelab;

import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataSaucelab;
import org.testng.Assert;
import com.myappium2project.pages.saucelab.HamburgerMenu;
import com.myappium2project.pages.saucelab.LoginPage;
import com.myappium2project.pages.saucelab.ProductsPage;
import org.testng.annotations.Test;

public class LoginTests extends SauceLabApkBaseTest {
    private static final String EXPECTED_ERROR_MESSAGE = "Provided credentials do not match any user in this service.";
    private static final String LOG_CHECK_ERROR_MESSAGE = "We check whether the error message appears and, if so, whether it is correct";
    private static final String LOG_ERROR_MESSAGE_CORRECT = "The error message is correct";
    private static final String LOG_ERROR_MESSAGE_INCORRECT = "The error message is not correct";
    private static final String ASSERT_MESSAGE_ERROR_DISPLAY = "The error message should be displayed, but it is not.";

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithValidData() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info("We check if we are on the 'Products' page");
        ProductsPage productPage = new ProductsPage(driver);
        String productPageTitleText = productPage.getProductPageTitleText();
        String expectedPageTitleText = "Products";
        if (productPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Products' page");
        } else {
            LOG.error("We are not on the 'Products' page");
        }
        Assert.assertEquals(productPageTitleText, expectedPageTitleText,
                "The page title should be 'Products', but it is not.");
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

        LOG.info(LOG_CHECK_ERROR_MESSAGE);
        String errorMessageText = loginPage.getErrorMessageText();
        if (loginPage.isDisplayedErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info(LOG_ERROR_MESSAGE_CORRECT);
        } else {
            LOG.error(LOG_ERROR_MESSAGE_INCORRECT);
        }
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(),
                ASSERT_MESSAGE_ERROR_DISPLAY);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                "The error message text should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
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

        LOG.info(LOG_CHECK_ERROR_MESSAGE);
        String errorMessageText = loginPage.getErrorMessageText();
        if (loginPage.isDisplayedErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE))
            LOG.info(LOG_ERROR_MESSAGE_CORRECT);
        else
            LOG.error(LOG_ERROR_MESSAGE_INCORRECT);
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(),
                ASSERT_MESSAGE_ERROR_DISPLAY);
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE,
                "The error message text should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }
}