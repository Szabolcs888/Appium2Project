package com.myappium2project.tests.saucelab;

import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataSaucelab;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.HamburgerMenu;
import com.myappium2project.pages.saucelab.LoginPage;
import com.myappium2project.pages.saucelab.ProductsPage;
import com.myappium2project.pages.saucelab.productspages.FleeceJacketPage;

public class FeedbackPopupTests extends SauceLabApkBaseTest {
    private static final String CHECK_POPUP_TEXT_LOG = "We check that the text of the pop-up window matches this: 'Thank you for submitting your review!'";
    private static final String EXPECTED_POPUP_TEXT = "Thank you for submitting your review!";
    private static final String POPUP_TEXT_CORRECT_LOG = "The popup text is correct";
    private static final String POPUP_TEXT_INCORRECT_ERRORLOG = "The popup text is not correct";

    private static final String CLOSE_MODAL_BUTTON_AVAILABLE_VALIDATION_ERROR_ASSERTLOG = "The popup text should be 'Thank you for submitting your review!', but it is not.";
    private static final String CHECK_CLOSE_MODAL_BUTTON_AVAILABLE_LOG = "We check if the 'Close Modal' button is still available'";
    private static final String CLOSE_MODAL_BUTTON_NOT_AVAILABLE_LOG = "The 'Close Modal' button is not available";
    private static final String CLOSE_MODAL_BUTTON_AVAILABLE_ERRORLOG = "The 'Close Modal' button is available";
    private static final String CLOSE_MODAL_BUTTON_NOT_AVAILABLE_VALIDATION_ERROR_ASSERTLOG = "The 'Close Modal' button should not be available, but it is.";

    @Test(priority = 1)
    public void testFeedbackPopupOnProductsPageWithoutLoggedIn() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressThirdStarButtonUnderBackpack();

        LOG.info(CHECK_POPUP_TEXT_LOG);
        String feedbackPopupText = productPage.getFeedbackPopupText();
        if (feedbackPopupText.equals(EXPECTED_POPUP_TEXT)) {
            LOG.info(POPUP_TEXT_CORRECT_LOG);
        } else {
            LOG.error(POPUP_TEXT_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(feedbackPopupText, EXPECTED_POPUP_TEXT, CLOSE_MODAL_BUTTON_AVAILABLE_VALIDATION_ERROR_ASSERTLOG);

        productPage.pressCloseModalButtonOnFeedbackPopup();

        LOG.info(CHECK_CLOSE_MODAL_BUTTON_AVAILABLE_LOG);
        boolean isCloseMButtonAvailable = productPage.isCloseModalButtonAvailable();
        if (!isCloseMButtonAvailable) {
            LOG.info(CLOSE_MODAL_BUTTON_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(CLOSE_MODAL_BUTTON_AVAILABLE_ERRORLOG);
        }
        Assert.assertFalse(isCloseMButtonAvailable, CLOSE_MODAL_BUTTON_NOT_AVAILABLE_VALIDATION_ERROR_ASSERTLOG);
    }

    @Test(priority = 2)
    public void testFeedbackPopupOnFleeceJacketPageInLoggedIn() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressFleeceJacketProductText();

        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver, wait);
        fleeceJacketPage.pressFifthStarButton();

        LOG.info(CHECK_POPUP_TEXT_LOG);
        String feedbackPopupText = fleeceJacketPage.getFeedbackPopupText();
        if (feedbackPopupText.equals(EXPECTED_POPUP_TEXT)) {
            LOG.info(POPUP_TEXT_CORRECT_LOG);
        } else {
            LOG.error(POPUP_TEXT_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(feedbackPopupText, EXPECTED_POPUP_TEXT, CLOSE_MODAL_BUTTON_AVAILABLE_VALIDATION_ERROR_ASSERTLOG);
        fleeceJacketPage.pressCloseModalButtonOnFeedbackPopup();

        LOG.info(CHECK_CLOSE_MODAL_BUTTON_AVAILABLE_LOG);
        boolean isCloseMButtonAvailable = fleeceJacketPage.isCloseModalButtonAvailable();
        if (!isCloseMButtonAvailable) {
            LOG.info(CLOSE_MODAL_BUTTON_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(CLOSE_MODAL_BUTTON_AVAILABLE_ERRORLOG);
        }
        Assert.assertFalse(isCloseMButtonAvailable, CLOSE_MODAL_BUTTON_NOT_AVAILABLE_VALIDATION_ERROR_ASSERTLOG);
    }
}