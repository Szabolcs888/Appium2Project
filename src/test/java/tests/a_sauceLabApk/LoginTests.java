package tests.a_sauceLabApk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.a_sauceLabApk.HamburgerMenu;
import pages.a_sauceLabApk.LoginPage;
import pages.a_sauceLabApk.ProductsPage;
import tests._baseTests.SauceLabApkBaseTest;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.util.List;

public class LoginTests extends SauceLabApkBaseTest {
    private static final Logger LOG = LogManager.getLogger(LoginTests.class);
    private static final String TEST_DATA_PATH = "src/test/resources/testData/sauceLabCredentials.txt";
    private static final String EXPECTED_ERROR_MESSAGE = "Provided credentials do not match any user in this service.";

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithValidData() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
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
        Assert.assertEquals(productPageTitleText, expectedPageTitleText, "The page title should be 'Products', but it is not.");
    }

    @Test(priority = 1,
            groups = {"smoke"})
    public void testLoginWithValidUsernameInvalidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput("wrongPassword", "invalid");
        loginPage.pressLoginButton();

        LOG.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (loginPage.isDisplayedErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE)) {
            LOG.info("The error message is correct");
        } else {
            LOG.error("The error message is not correct");
        }
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "The error message should be displayed, but it is not.");
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE, "The error message text should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testLoginWithInvalidUsernameValidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("wrongUsername", "invalid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginButton();

        LOG.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (loginPage.isDisplayedErrorMessage() && errorMessageText.equals(EXPECTED_ERROR_MESSAGE))
            LOG.info("The error message is correct");
        else
            LOG.error("The error message is correct");
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "The error message should be displayed, but it is not.");
        Assert.assertEquals(errorMessageText, EXPECTED_ERROR_MESSAGE, "The error message text should be '" + EXPECTED_ERROR_MESSAGE + "', but it is '" + errorMessageText + "'.");
    }
}
