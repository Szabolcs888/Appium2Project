package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SlabTestLogMessages;
import com.myappium2project.pages.saucelab.*;
import com.myappium2project.pages.saucelab.productspages.*;
import com.myappium2project.tests.basetests.SauceLabApkTestBase;
import com.myappium2project.testsdata.SaucelabData;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.commonutils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {TestGroups.E2E})
public class CartEmptyingTests extends SauceLabApkTestBase {

    @Test(timeOut = 62_000, priority = 1)
    public void testPlacingProductsInCartAndThenEmptyingThemSL() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(SaucelabData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(SaucelabData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        ProductsPage productPage = new ProductsPage(driver, wait);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceAscendingOrderOption();
        productPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productPage.pressTestAllTheThingsTShirtProductText();
        TestAllTheThingsTShirtPage testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        testAllTheThingsTShirtPage.pressGrayCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);

        productPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressAddToCartButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productPage.pressBackpackProductText();
        BackPackPage backPackPage = new BackPackPage(driver);
        backPackPage.pressAddToCartButton();
        backPackPage.pressRedCircleButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        productPage.pressBikeLightProductText();
        BikeLightPage bikeLightPage = new BikeLightPage(driver);
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressAddToCartButton();

        productPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.pressRemoveItemButtons();

        LOG.info(SlabTestLogMessages.CHECK_CART_EMPTY_LOG);
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver, wait);
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info(SlabTestLogMessages.CART_EMPTY_LOG);
        } else {
            LOG.error(SlabTestLogMessages.CART_NOT_EMPTY_LOG);
        }
        Assert.assertTrue(isDisplayedNoItemsText, SlabTestLogMessages.CART_NOT_EMPTY_ASSERT_LOG);

        cartNoItemsPage.pressGoShoppingButton();

        LOG.info(SlabTestLogMessages.CHECK_CART_COUNTER_AVAILABLE_LOG);
        boolean isDisplayedProductCounter = productPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info(SlabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(SlabTestLogMessages.CART_COUNTER_AVAILABLE_LOG);
        }
        Assert.assertFalse(isDisplayedProductCounter, SlabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_ASSERT_LOG);
    }
}