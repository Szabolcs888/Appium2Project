package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.pages.nativeapps.saucelabs.CartNoItemsPage;
import com.myappium2project.pages.nativeapps.saucelabs.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * Provides common assertion utilities for SauceLabs App tests.
 * Includes reusable verification methods for page access, cart state, and UI elements.
 */
public class SauceLabsCommonAssertions {
    private static final Logger LOG = LoggerFactory.getLogger(SauceLabsCommonAssertions.class);

    private SauceLabsCommonAssertions() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    static void verifyPageLoaded(String actualPageName, String expectedPageName) {
        LOG.info(CommonTestLogMessages.CHECK_ON_PAGE_LOG, expectedPageName);
        if (actualPageName.equals(expectedPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, expectedPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, expectedPageName);
        }

        Assert.assertEquals(actualPageName, expectedPageName, "The page title should be '" + expectedPageName + "', but it is not.");
    }

    static void verifyCartIsEmpty(CartNoItemsPage cartNoItemsPage) {
        LOG.info("We check if the cart is empty");
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info("The cart is empty");
        } else {
            LOG.error("The cart is not empty");
        }

        Assert.assertTrue(isDisplayedNoItemsText, "The cart should be empty, but it is not.");
    }

    static void verifyCartCounterIsNotAvailable(ProductsPage productsPage) {
        LOG.info("We check if the cart counter is available");
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info("The cart counter is not available");
        } else {
            LOG.error("The cart counter is available");
        }

        Assert.assertFalse(isDisplayedProductCounter, "The cart counter should not be available, but it is.");
    }
}