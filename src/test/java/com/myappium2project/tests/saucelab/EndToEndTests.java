package com.myappium2project.tests.saucelab;

import com.myappium2project.pages.saucelab.*;
import com.myappium2project.pages.saucelab.productspages.*;
import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataSaucelab;
import com.myappium2project.utils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EndToEndTests extends SauceLabApkBaseTest {

    @Test(priority = 1,
            description = "Login first then shopping")
    public void testEndToEnd() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.pressDropdownMenuButton();
        productsPage.pressAbcOrderOption();

        productsPage.pressBikeLightProductText();
        BikeLightPage bikeLightPage = new BikeLightPage(driver);
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        boltTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);

        productsPage.pressOnesieProductText();
        OnesiePage onesiePage = new OnesiePage(driver);
        onesiePage.pressBlackCircleButton();
        onesiePage.pressCounterPlusButton();
        onesiePage.pressCounterPlusButton();
        onesiePage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressTestAllTheThingsTShirtProductText();
        TestAllTheThingsTShirtPage testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        testAllTheThingsTShirtPage.pressGrayCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        LOG.info("We check whether the correct products are in the cart");
        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        List<String> productsNamesListInMyCart = cartPage.getTheListOfProductNamesInMyCart(driver);
        Collections.sort(productsNamesListInMyCart);
        List<String> theListAsItShouldBe = Arrays.asList(
                "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println("The products in the cart: \n" + productsNamesListInMyCart);
        System.out.println("The cart should contain these products: \n" + theListAsItShouldBe);
        if (productsNamesListInMyCart.equals(theListAsItShouldBe)) {
            LOG.info("The correct products are in the cart");
        } else {
            LOG.error("There are no correct products in the cart");
        }
        Assert.assertEquals(productsNamesListInMyCart, theListAsItShouldBe,
                "The cart should contain the correct products, but it does not.");

        LOG.info("We check the number of products in the cart");
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 11;
        System.out.println("The number of products in the cart: " + productsQuantityInMyCart);
        System.out.println("This should be the number of products in the cart: " + expectedProductsQuantityInMyCart);
        if (productsQuantityInMyCart == expectedProductsQuantityInMyCart) {
            LOG.info("The number of products in the cart is correct");
        } else {
            LOG.error("The number of products in the cart is not correct");
        }
        Assert.assertEquals(productsQuantityInMyCart, expectedProductsQuantityInMyCart,
                "The number of products in the cart should be " + expectedProductsQuantityInMyCart + ", but it is " + productsQuantityInMyCart + ".");

        cartPage.pressProceedToCheckoutButton();

        LOG.info("We check whether we are on the 'Checkout' page");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        String expectedTitleText = "Checkout";
        if (checkoutPageTitleText.equals(expectedTitleText)) {
            LOG.info("We are on the 'Checkout' page");
        } else {
            LOG.error("We are not on the 'Checkout' page");
        }
        Assert.assertEquals(checkoutPageTitleText, expectedTitleText,
                "The page title should be 'Checkout', but it is not.");

        checkoutPage.fillFullNameInput(TestDataSaucelab.FULL_NAME_ACC1);
        checkoutPage.fillAddressLine1Input(TestDataSaucelab.ADDRESS_LINE1_ACC1);
        checkoutPage.fillCityInput(TestDataSaucelab.CITY_ACC1);
        checkoutPage.fillStateRegionInput(TestDataSaucelab.STATE_REGION_ACC1);
        checkoutPage.fillZipCodeInput(TestDataSaucelab.ZIP_CODE_ACC1);
        checkoutPage.fillCountryInput(TestDataSaucelab.COUNTRY_ACC1);
        checkoutPage.pressToPaymentButton();

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.fillFullNameInput(TestDataSaucelab.FULL_NAME_ACC1);
        checkoutPaymentPage.fillCardNumberInput(TestDataSaucelab.CARD_NUMBER_ACC1);
        checkoutPaymentPage.fillExpirationDateInput(TestDataSaucelab.EXPIRATION_DATE_ACC1);
        checkoutPaymentPage.fillSecurityCodeInput(TestDataSaucelab.SECURITY_CODE_ACC1);
        checkoutPaymentPage.pressReviewOrderButton();

        LOG.info("We check that the delivery data and payment data are correct");
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);

        List<String> originalDeliveryData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC1, TestDataSaucelab.ADDRESS_LINE1_ACC1, TestDataSaucelab.CITY_ACC1,
                TestDataSaucelab.STATE_REGION_ACC1, TestDataSaucelab.ZIP_CODE_ACC1, TestDataSaucelab.COUNTRY_ACC1);
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println("Delivery data is on the page: \n" + deliveryDataOnOrderReviewPage);
        System.out.println("Original delivery data: \n" + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info("The delivery data is correct");
        } else {
            LOG.error("The delivery data is not correct");
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData,
                "The delivery data should match the provided data, but it does not.");

        List<String> originalPaymentData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC1, TestDataSaucelab.CARD_NUMBER_ACC1, TestDataSaucelab.EXPIRATION_DATE_ACC1);
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println("Payment data is on the page: \n" + paymentDataOnOrderReviewPage);
        System.out.println("Original payment data: \n" + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info("The payment data is correct");
        } else {
            LOG.error("The payment data is not correct");
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData,
                "The payment data should match the provided data, but it does not.");

        checkoutOrderReviewPage.pressPlaceOrderButton();

        LOG.info("We check whether we are on the 'Checkout Complete' page");
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        String expectedPageTitleText = "Checkout Complete";
        if (checkoutCompletePageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Checkout Complete' page");
        } else {
            LOG.error("We are not on the 'Checkout Complete' page");
        }
        Assert.assertEquals(checkoutCompletePageTitleText, expectedPageTitleText,
                "The page title should be 'Checkout Complete', but it is not.");

        checkoutCompletePage.pressContinueShoppingButton();

        LOG.info("We check if the cart is empty");
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info("The cart is empty");
        } else {
            LOG.error("The cart is not empty");
        }
        Assert.assertTrue(isDisplayedNoItemsText,
                "The cart should be empty, but it is not.");

        LOG.info("We check if the cart counter is available");
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info("The cart counter is not available");
        } else {
            LOG.error("The cart counter is available");
        }
        Assert.assertFalse(isDisplayedProductCounter,
                "The cart counter should not be available, but it is.");

        AppiumActions.navigateBack(driver);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        LOG.info("We check whether we are on the 'Login' page");
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        String expectedLoginPageTitleText = "Login";
        if (loginPageTitleText.equals(expectedLoginPageTitleText)) {
            LOG.info("We are on the 'Login' page");
        } else {
            LOG.error("We are not on the 'Login' page");
        }
        Assert.assertEquals(loginPageTitleText, expectedLoginPageTitleText,
                "The page title should be 'Login', but it is not.");
    }

    @Test(priority = 2,
            description = "Shopping first then login")
    public void testEndToEnd2() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.pressDropdownMenuButton();
        productsPage.pressPriceAscendingOrderOption();
        productsPage.pressTestAllTheThingsTShirtProductText();

        TestAllTheThingsTShirtPage testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        testAllTheThingsTShirtPage.pressBlackCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressOnesieProductText();
        OnesiePage onesiePage = new OnesiePage(driver);
        onesiePage.pressCounterPlusButton();
        onesiePage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBikeLightProductText();
        BikeLightPage bikeLightPage = new BikeLightPage(driver);
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);

        productsPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBackpackProductText();
        BackPackPage backPackPage = new BackPackPage(driver);
        backPackPage.pressBlueCircleButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        LOG.info("We check whether the correct products are in the cart");
        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        List<String> productsNamesListInMyCart = cartPage.getTheListOfProductNamesInMyCart(driver);
        Collections.sort(productsNamesListInMyCart);
        List<String> theListAsItShouldBe = Arrays.asList(
                "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println("The products in the cart: \n" + productsNamesListInMyCart);
        System.out.println("The cart should contain these products: \n" + theListAsItShouldBe);
        if (productsNamesListInMyCart.equals(theListAsItShouldBe)) {
            LOG.info("The correct products are in the cart");
        } else {
            LOG.error("There are no correct products in the cart");
        }
        Assert.assertEquals(productsNamesListInMyCart, theListAsItShouldBe,
                "The cart should contain the correct products, but it does not.");

        LOG.info("We check the number of products in the cart");
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 12;
        System.out.println("The number of products in the cart: " + productsQuantityInMyCart);
        System.out.println("This should be the number of products in the cart: " + expectedProductsQuantityInMyCart);
        if (productsQuantityInMyCart == expectedProductsQuantityInMyCart) {
            LOG.info("The number of products in the cart is correct");
        } else {
            LOG.error("The number of products in the cart is not correct");
        }
        Assert.assertEquals(productsQuantityInMyCart, expectedProductsQuantityInMyCart,
                "The number of products in the cart should be " + expectedProductsQuantityInMyCart + ", but it is " + productsQuantityInMyCart + ".");

        cartPage.pressProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC2, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC2, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        LOG.info("We check whether we are on the 'Checkout' page");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        String expectedTitleText = "Checkout";
        if (checkoutPageTitleText.equals(expectedTitleText)) {
            LOG.info("We are on the 'Checkout' page");
        } else {
            LOG.error("We are not on the 'Checkout' page");
        }
        Assert.assertEquals(checkoutPageTitleText, expectedTitleText,
                "The page title should be 'Checkout', but it is not.");

        checkoutPage.fillFullNameInput(TestDataSaucelab.FULL_NAME_ACC2);
        checkoutPage.fillAddressLine1Input(TestDataSaucelab.ADDRESS_LINE1_ACC2);
        checkoutPage.fillCityInput(TestDataSaucelab.CITY_ACC2);
        checkoutPage.fillStateRegionInput(TestDataSaucelab.STATE_REGION_ACC2);
        checkoutPage.fillZipCodeInput(TestDataSaucelab.ZIP_CODE_ACC2);
        checkoutPage.fillCountryInput(TestDataSaucelab.COUNTRY_ACC2);
        checkoutPage.pressToPaymentButton();

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.fillFullNameInput(TestDataSaucelab.FULL_NAME_ACC2);
        checkoutPaymentPage.fillCardNumberInput(TestDataSaucelab.CARD_NUMBER_ACC2);
        checkoutPaymentPage.fillExpirationDateInput(TestDataSaucelab.EXPIRATION_DATE_ACC2);
        checkoutPaymentPage.fillSecurityCodeInput(TestDataSaucelab.SECURITY_CODE_ACC2);
        checkoutPaymentPage.pressReviewOrderButton();

        LOG.info("We check that the delivery data and payment data are correct");
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC2, TestDataSaucelab.ADDRESS_LINE1_ACC2, TestDataSaucelab.CITY_ACC2,
                TestDataSaucelab.STATE_REGION_ACC2, TestDataSaucelab.ZIP_CODE_ACC2, TestDataSaucelab.COUNTRY_ACC2);
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println("Delivery data is on the page: \n" + deliveryDataOnOrderReviewPage);
        System.out.println("Original delivery data: \n" + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info("The delivery data is correct");
        } else {
            LOG.error("The delivery data is not correct");
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData,
                "The delivery data should match the provided data, but it does not.");

        List<String> originalPaymentData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC2, TestDataSaucelab.CARD_NUMBER_ACC2, TestDataSaucelab.EXPIRATION_DATE_ACC2);
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println("Payment data is on the page: \n" + paymentDataOnOrderReviewPage);
        System.out.println("Original payment data: \n" + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info("The payment data is correct");
        } else {
            LOG.error("The payment data is not correct");
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData,
                "The payment data should match the provided data, but it does not.");

        checkoutOrderReviewPage.pressPlaceOrderButton();

        LOG.info("We check whether we are on the 'Checkout Complete' page");
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        String expectedPageTitleText = "Checkout Complete";
        if (checkoutCompletePageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Checkout Complete' page");
        } else {
            LOG.error("We are not on the 'Checkout Complete' page");
        }
        Assert.assertEquals(checkoutCompletePageTitleText, expectedPageTitleText,
                "The page title should be 'Checkout Complete', but it is not.");

        checkoutCompletePage.pressContinueShoppingButton();

        LOG.info("We check if the cart is empty");
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info("The cart is empty");
        } else {
            LOG.error("The cart is not empty");
        }
        Assert.assertTrue(isDisplayedNoItemsText, "The cart should be empty, but it is not.");

        LOG.info("We check if the cart counter is available");
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info("The cart counter is not available");
        } else {
            LOG.error("The cart counter is available");
        }
        Assert.assertFalse(isDisplayedProductCounter,
                "The cart counter should not be available, but it is.");

        AppiumActions.navigateBack(driver);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        LOG.info("We check whether we are on the 'Login' page");
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        String expectedLoginPageTitleText = "Login";
        if (loginPageTitleText.equals(expectedLoginPageTitleText)) {
            LOG.info("We are on the 'Login' page");
        } else {
            LOG.error("We are not on the 'Login' page");
        }
        Assert.assertEquals(loginPageTitleText, expectedLoginPageTitleText,
                "The page title should be 'Login', but it is not.");
    }
}