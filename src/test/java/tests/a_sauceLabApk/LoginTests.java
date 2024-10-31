package tests.a_sauceLabApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.a_sauceLabApk.HamburgerMenu;
import pages.a_sauceLabApk.LoginPage;
import pages.a_sauceLabApk.ProductsPage;
import tests._baseTests.SauceLabApkBaseTest;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.util.List;

@Listeners(TestListener.class)
public class LoginTests extends SauceLabApkBaseTest {
    private static final Logger log = LogManager.getLogger(LoginTests.class);
    private static final String testDataPath = "src/test/resources/testData/sauceLabCredentials.txt";
    private static final String expectedErrorMessage = "Provided credentials do not match any user in this service.";

    @Test(priority = 3,
            groups = {"smoke"})
    public void testLoginWithValidData() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginButton();

        log.info("We check if we are on the 'Products' page");
        ProductsPage productPage = new ProductsPage(driver);
        String productPageTitleText = productPage.getProductPageTitleText();
        String expectedPageTitleText = "Products";
        if (productPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Products' page");
        } else {
            log.error("We are not on the 'Products' page");
        }
        Assert.assertEquals(productPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 1,
            groups = {"smoke"})
    public void testLoginWithValidUsernameInvalidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput("wrongPassword", "invalid");
        loginPage.pressLoginButton();

        log.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (loginPage.isDisplayedErrorMessage() && errorMessageText.equals(expectedErrorMessage)) {
            log.info("The error message is correct");
        } else {
            log.error("The error message is not correct");
        }
        Assert.assertTrue(loginPage.isDisplayedErrorMessage());
        Assert.assertEquals(errorMessageText, expectedErrorMessage);
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testLoginWithInvalidUsernameValidPassword() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("wrongUsername", "invalid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginButton();

        log.info("We check whether the error message appears and, if so, whether it is correct");
        String errorMessageText = loginPage.getErrorMessageText();
        if (loginPage.isDisplayedErrorMessage() && errorMessageText.equals(expectedErrorMessage))
            log.info("The error message is correct");
        else
            log.error("The error message is correct");
        Assert.assertTrue(loginPage.isDisplayedErrorMessage());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }
}
