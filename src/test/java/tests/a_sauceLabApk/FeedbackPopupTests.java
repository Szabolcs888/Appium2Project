package tests.a_sauceLabApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.a_sauceLabApk.HamburgerMenu;
import pages.a_sauceLabApk.LoginPage;
import pages.a_sauceLabApk.ProductsPage;
import pages.a_sauceLabApk.productsPages.FleeceJacketPage;
import tests._baseTests.SauceLabApkBaseTest;
import utils.CommonUtils;

import java.util.List;

@Listeners(TestListener.class)
public class FeedbackPopupTests extends SauceLabApkBaseTest {
    private static final Logger log = LogManager.getLogger(FeedbackPopupTests.class);
    private static final String testDataPath = "src/test/resources/testData/sauceLabCredentials.txt";

    @Test(priority = 1)
    public void testFeedbackPopupOnProductsPageWithoutLoggedIn() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressThirdStarButtonUnderTheBackpack();

        log.info("We check that the text of the pop-up window matches this: 'Thank you for submitting your review!'");
        String feedbackPopupText = productPage.getFeedbackPopupText();
        String expectedFeedbackPopupText = "Thank you for submitting your review!";
        if (feedbackPopupText.equals(expectedFeedbackPopupText)) {
            log.info("The popup text is correct");
        } else {
            log.error("The popup text is not correct");
        }
        Assert.assertEquals(feedbackPopupText, expectedFeedbackPopupText);

        productPage.pressCloseModalButtonOnFeedbackPopup();

        log.info("We check whether the 'Close Modal' button is still available");
        boolean isTheCloseMButtonAvailable = productPage.isTheCloseModalButtonAvailable();
        if (!isTheCloseMButtonAvailable) {
            log.info("The 'Close Modal' button is not available");
        } else {
            log.error("The 'Close Modal' button is available");
        }
        Assert.assertFalse(isTheCloseMButtonAvailable);
    }

    @Test(priority = 2)
    public void testFeedbackPopupOnFleeceJacketPageInLoggedIn() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginButton();

        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressFleeceJacketProductText();

        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver, wait);
        fleeceJacketPage.pressFifthStarButton();

        log.info("We check that the text of the pop-up window matches this: 'Thank you for submitting your review!'");
        String feedbackPopupText = fleeceJacketPage.getFeedbackPopupText();
        String expectedFeedbackPopupText = "Thank you for submitting your review!";
        if (feedbackPopupText.equals(expectedFeedbackPopupText)) {
            log.info("The popup text is correct");
        } else {
            log.error("The popup text is not correct");
        }
        Assert.assertEquals(feedbackPopupText, expectedFeedbackPopupText);

        fleeceJacketPage.pressCloseModalButtonOnFeedbackPopup();

        log.info("We check whether the 'Close Modal' button is still available");
        boolean isTheCloseMButtonAvailable = fleeceJacketPage.isTheCloseModalButtonAvailable();
        if (!isTheCloseMButtonAvailable) {
            log.info("The 'Close Modal' button is not available");
        } else {
            log.error("The 'Close Modal' button is available");
        }
        Assert.assertFalse(isTheCloseMButtonAvailable);
    }
}
