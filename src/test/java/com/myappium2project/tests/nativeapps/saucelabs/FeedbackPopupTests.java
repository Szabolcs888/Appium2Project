package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.configdata.models.accounts.SauceLabsAppAccount;
import com.myappium2project.configdata.providers.accounts.SauceLabsAppAccountProvider;
import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.nativeapps.saucelabs.HamburgerMenu;
import com.myappium2project.pages.nativeapps.saucelabs.ProductsPage;
import com.myappium2project.pages.nativeapps.saucelabs.productspages.FleeceJacketPage;

@Test(groups = {TestGroups.INTEGRATION})
public class FeedbackPopupTests extends SauceLabsAppTestBase {
    private static final String EXPECTED_POPUP_TEXT = "Thank you for submitting your review!";

    private static final SauceLabsAppAccount SAUCE_ACC1 = SauceLabsAppAccountProvider.getAccount(0);

    @Test(priority = 1)
    public void testFeedbackPopupOnProductsPageWithoutLoggedIn() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressThirdStarButtonUnderBackpack();

        String feedbackPopupText = productPage.getFeedbackPopupText();
        verifyPopupText(feedbackPopupText);

        productPage.pressCloseModalButtonOnFeedbackPopup();

        boolean isCloseMButtonAvailable = productPage.isCloseModalButtonAvailable();
        verifyCloseModalButtonNotAvailable(isCloseMButtonAvailable);
    }

    @Test(priority = 2)
    public void testFeedbackPopupOnFleeceJacketPageInLoggedIn() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        SauceLabsCommonSteps.loginToSauceLabs(driver, hamburgerMenu, SAUCE_ACC1);

        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();
        productPage.pressFleeceJacketProductText();

        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver, wait);
        fleeceJacketPage.pressFifthStarButton();

        String feedbackPopupText = fleeceJacketPage.getFeedbackPopupText();
        verifyPopupText(feedbackPopupText);

        fleeceJacketPage.pressCloseModalButtonOnFeedbackPopup();

        boolean isCloseMButtonAvailable = fleeceJacketPage.isCloseModalButtonAvailable();
        verifyCloseModalButtonNotAvailable(isCloseMButtonAvailable);
    }

    private void verifyPopupText(String actualText) {
        LOG.info("We check that the text of the pop-up window matches this: '{}'", EXPECTED_POPUP_TEXT);
        if (EXPECTED_POPUP_TEXT.equals(actualText)) {
            LOG.info("The popup text is correct");
        } else {
            LOG.error("The popup text is not correct");
        }

        Assert.assertEquals(actualText, EXPECTED_POPUP_TEXT, "The popup text should be 'Thank you for submitting your review!', but it is not.");
    }

    private void verifyCloseModalButtonNotAvailable(boolean isAvailable) {
        LOG.info("We check if the 'Close Modal' button is still available");
        if (!isAvailable) {
            LOG.info("The 'Close Modal' button is not available");
        } else {
            LOG.error("The 'Close Modal' button is available");
        }

        Assert.assertFalse(isAvailable, "The 'Close Modal' button should not be available, but it is.");
    }
}