package com.myappium2project.tests.saucelab;

import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.utils.TestDataFilePaths;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.HamburgerMenu;
import com.myappium2project.pages.saucelab.LoginPage;
import com.myappium2project.pages.saucelab.ProductsPage;
import com.myappium2project.pages.saucelab.productsPages.FleeceJacketPage;
import com.myappium2project.utils.CommonUtils;

import java.util.List;

public class FeedbackPopupTests extends SauceLabApkBaseTest {
    private static final String TEST_DATA_PATH = TestDataFilePaths.getSaucelabTestDataPath();

    @Test(priority = 1)
    public void testFeedbackPopupOnProductsPageWithoutLoggedIn() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressThirdStarButtonUnderTheBackpack();

        LOG.info("We check that the text of the pop-up window matches this: 'Thank you for submitting your review!'");
        String feedbackPopupText = productPage.getFeedbackPopupText();
        String expectedFeedbackPopupText = "Thank you for submitting your review!";
        if (feedbackPopupText.equals(expectedFeedbackPopupText)) {
            LOG.info("The popup text is correct");
        } else {
            LOG.error("The popup text is not correct");
        }
        Assert.assertEquals(feedbackPopupText, expectedFeedbackPopupText, "The popup text should be 'Thank you for submitting your review!', but it is not.");

        productPage.pressCloseModalButtonOnFeedbackPopup();

        LOG.info("We check whether the 'Close Modal' button is still available");
        boolean isTheCloseMButtonAvailable = productPage.isTheCloseModalButtonAvailable();
        if (!isTheCloseMButtonAvailable) {
            LOG.info("The 'Close Modal' button is not available");
        } else {
            LOG.error("The 'Close Modal' button is available");
        }
        Assert.assertFalse(isTheCloseMButtonAvailable, "The 'Close Modal' button should not be available, but it is.");
    }

    @Test(priority = 2)
    public void testFeedbackPopupOnFleeceJacketPageInLoggedIn() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);

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

        LOG.info("We check that the text of the pop-up window matches this: 'Thank you for submitting your review!'");
        String feedbackPopupText = fleeceJacketPage.getFeedbackPopupText();
        String expectedFeedbackPopupText = "Thank you for submitting your review!";
        if (feedbackPopupText.equals(expectedFeedbackPopupText)) {
            LOG.info("The popup text is correct");
        } else {
            LOG.error("The popup text is not correct");
        }
        Assert.assertEquals(feedbackPopupText, expectedFeedbackPopupText, "The popup text should be 'Thank you for submitting your review!', but it is not.");

        fleeceJacketPage.pressCloseModalButtonOnFeedbackPopup();

        LOG.info("We check whether the 'Close Modal' button is still available");
        boolean isTheCloseMButtonAvailable = fleeceJacketPage.isTheCloseModalButtonAvailable();
        if (!isTheCloseMButtonAvailable) {
            LOG.info("The 'Close Modal' button is not available");
        } else {
            LOG.error("The 'Close Modal' button is available");
        }
        Assert.assertFalse(isTheCloseMButtonAvailable, "The 'Close Modal' button should not be available, but it is.");
    }
}
