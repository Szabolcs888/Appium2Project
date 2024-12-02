package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.SLabTestLogMessages;
import com.myappium2project.pages.saucelab.*;
import com.myappium2project.pages.saucelab.productspages.*;
import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataSaucelab;
import com.myappium2project.utils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartEmptyingTests extends SauceLabApkBaseTest {

    @Test(timeOut = 620_00, priority = 1)
    public void testPlacingProductsInTheCartAndThenEmptyingThemSL() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
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

        LOG.info(SLabTestLogMessages.CHECK_CART_EMPTY_LOG);
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver, wait);
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info(SLabTestLogMessages.CART_EMPTY_LOG);
        } else {
            LOG.error(SLabTestLogMessages.CART_NOT_EMPTY_ERRORLOG);
        }
        Assert.assertTrue(isDisplayedNoItemsText, SLabTestLogMessages.CART_EMPTY_VALIDATION_ERROR_ASSERTLOG);

        cartNoItemsPage.pressGoShoppingButton();

        LOG.info(SLabTestLogMessages.CHECK_CART_COUNTER_AVAILABLE_LOG);
        boolean isDisplayedProductCounter = productPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info(SLabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(SLabTestLogMessages.CART_COUNTER_AVAILABLE_ERRORLOG);
        }
        Assert.assertFalse(isDisplayedProductCounter, SLabTestLogMessages.CART_COUNTER_AVAILABLE_VALIDATION_ERROR_ASSERTLOG);
    }
}