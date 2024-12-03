package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SLabTestLogMessages;
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
    // I used an inner class in this class because there are too many variables and I wanted to separate them from the tests.
    private static class E2ELogMessages {
        private static final String CHECK_CORRECT_PRODUCT_IN_CART_LOG = "We check if the correct products are in the cart";
        private static final String PRODUCTS_IN_CART_CONSOLELOG = "The products in the cart: \n";
        private static final String EXPECTED_PRODUCTS_IN_CART_CONSOLELOG = "The cart should contain these products: \n";
        private static final String CORRECT_PRODUCTS_IN_CART_LOG = "The correct products are in the cart";
        private static final String NOT_RIGHT_PRODUCTS_IN_CART_ERRORLOG = "There are not the right products in the cart.";
        private static final String CART_DOES_NOT_CONTAIN_CORRECT_PRODUCTS_VALIDATION_ASSERTLOG = "The cart should contain the correct products, but it does not.";

        private static final String CHECK_NUMBER_OF_PRODUCTS_IN_CART_LOG = "We check the number of products in the cart";
        private static final String NUMBER_OF_PRODUCTS_IN_CART_LOG = "The number of products in the cart: ";
        private static final String EXPECTED_NUMBER_OF_PRODUCTS_IN_CART_LOG = "This should be the number of products in the cart: ";
        private static final String CORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG = "The number of products in the cart is correct";
        private static final String INCORRECT_NUMBER_OF_PRODUCTS_IN_CART_ERRORLOG = "The number of products in the cart is not correct";

        private static final String CHECK_CORRECT_DELIVERY_AND_PAYMENT_DATA_LOG = "We check that the delivery data and payment data are correct";
        private static final String DELIVERY_DATA_ON_PAGE_CONSOLELOG = "Delivery data is on the page: \n";
        private static final String ORIGINAL_DELIVERY_DATA_CONSOLELOG = "Original delivery data: \n";
        private static final String CORRECT_DELIVERY_DATA_LOG = "The delivery data is correct";
        private static final String INCORRECT_DELIVERY_DATA_ERRORLOG = "The delivery data is correct";
        private static final String DELIVERY_DATA_MATCH_VALIDATION_ASSERTLOG = "The delivery data should match the provided data, but it does not.";

        private static final String PAYMENT_DATA_ON_PAGE_CONSOLELOG = "Payment data is on the page: \n";
        private static final String ORIGINAL_PAYMENT_DATA_CONSOLELOG = "Original payment data: \n";
        private static final String CORRECT_PAYMENT_DATA_LOG = "The payment data is correct";
        private static final String INCORRECT_PAYMENT_DATA_ERRORLOG = "The payment data is not correct";
        private static final String PAYMENT_DATA_MATCH_VALIDATION_ASSERTLOG = "The payment data should match the provided data, but it does not.";

        private static String getCorrectNumberOfProductsValidationAssertLog(int expectedProductsQuantityInMyCart, int productsQuantityInMyCart) {
            return String.format("The number of products in the cart should be %s, but it is %s.",
                    expectedProductsQuantityInMyCart, productsQuantityInMyCart);
        }
    }

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

        LOG.info(E2ELogMessages.CHECK_CORRECT_PRODUCT_IN_CART_LOG);
        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        List<String> productsNamesListInMyCart = cartPage.getListOfProductNamesInMyCart(driver);
        Collections.sort(productsNamesListInMyCart);
        List<String> productsNamesListAsItShouldBe = Arrays.asList(
                "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println(E2ELogMessages.PRODUCTS_IN_CART_CONSOLELOG + productsNamesListInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_PRODUCTS_IN_CART_CONSOLELOG + productsNamesListAsItShouldBe);
        if (productsNamesListInMyCart.equals(productsNamesListAsItShouldBe)) {
            LOG.info(E2ELogMessages.CORRECT_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.NOT_RIGHT_PRODUCTS_IN_CART_ERRORLOG);
        }
        Assert.assertEquals(productsNamesListInMyCart, productsNamesListAsItShouldBe,
                E2ELogMessages.CART_DOES_NOT_CONTAIN_CORRECT_PRODUCTS_VALIDATION_ASSERTLOG);

        LOG.info(E2ELogMessages.CHECK_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 11;
        System.out.println(E2ELogMessages.NUMBER_OF_PRODUCTS_IN_CART_LOG + productsQuantityInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_NUMBER_OF_PRODUCTS_IN_CART_LOG + expectedProductsQuantityInMyCart);
        if (productsQuantityInMyCart == expectedProductsQuantityInMyCart) {
            LOG.info(E2ELogMessages.CORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_NUMBER_OF_PRODUCTS_IN_CART_ERRORLOG);
        }
        Assert.assertEquals(productsQuantityInMyCart, expectedProductsQuantityInMyCart,
                E2ELogMessages.getCorrectNumberOfProductsValidationAssertLog(expectedProductsQuantityInMyCart, productsQuantityInMyCart));

        cartPage.pressProceedToCheckoutButton();

        String checkoutPageName = "Checkout";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), checkoutPageName);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        if (checkoutPageTitleText.equals(checkoutPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), checkoutPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), checkoutPageName);
        }
        Assert.assertEquals(checkoutPageTitleText, checkoutPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(checkoutPageName));

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

        LOG.info(E2ELogMessages.CHECK_CORRECT_DELIVERY_AND_PAYMENT_DATA_LOG);
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);

        List<String> originalDeliveryData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC1, TestDataSaucelab.ADDRESS_LINE1_ACC1, TestDataSaucelab.CITY_ACC1,
                TestDataSaucelab.STATE_REGION_ACC1, TestDataSaucelab.ZIP_CODE_ACC1, TestDataSaucelab.COUNTRY_ACC1);
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println(E2ELogMessages.DELIVERY_DATA_ON_PAGE_CONSOLELOG + deliveryDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_DELIVERY_DATA_CONSOLELOG + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info(E2ELogMessages.CORRECT_DELIVERY_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_DELIVERY_DATA_ERRORLOG);
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData,
                E2ELogMessages.DELIVERY_DATA_MATCH_VALIDATION_ASSERTLOG);

        List<String> originalPaymentData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC1, TestDataSaucelab.CARD_NUMBER_ACC1, TestDataSaucelab.EXPIRATION_DATE_ACC1);
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println(E2ELogMessages.PAYMENT_DATA_ON_PAGE_CONSOLELOG + paymentDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_PAYMENT_DATA_CONSOLELOG + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info(E2ELogMessages.CORRECT_PAYMENT_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_PAYMENT_DATA_ERRORLOG);
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData,
                E2ELogMessages.PAYMENT_DATA_MATCH_VALIDATION_ASSERTLOG);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        String checkoutCompletePageName = "Checkout Complete";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), checkoutCompletePageName);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        if (checkoutCompletePageTitleText.equals(checkoutCompletePageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), checkoutCompletePageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), checkoutCompletePageName);
        }
        Assert.assertEquals(checkoutCompletePageTitleText, checkoutCompletePageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(checkoutCompletePageName));

        checkoutCompletePage.pressContinueShoppingButton();

        LOG.info(SLabTestLogMessages.CHECK_CART_EMPTY_LOG);
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info(SLabTestLogMessages.CART_EMPTY_LOG);
        } else {
            LOG.error(SLabTestLogMessages.CART_NOT_EMPTY_ERRORLOG);
        }
        Assert.assertTrue(isDisplayedNoItemsText, SLabTestLogMessages.CART_EMPTY_VALIDATION_ASSERTLOG);

        LOG.info(SLabTestLogMessages.CHECK_CART_COUNTER_AVAILABLE_LOG);
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info(SLabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(SLabTestLogMessages.CART_COUNTER_AVAILABLE_ERRORLOG);
        }
        Assert.assertFalse(isDisplayedProductCounter, SLabTestLogMessages.CART_COUNTER_AVAILABLE_VALIDATION_ASSERTLOG);

        AppiumActions.navigateBack(driver);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        String loginPageName = "Login";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), loginPageName);
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        if (loginPageTitleText.equals(loginPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), loginPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), loginPageName);
        }
        Assert.assertEquals(loginPageTitleText, loginPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(loginPageName));
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

        LOG.info(E2ELogMessages.CHECK_CORRECT_PRODUCT_IN_CART_LOG);
        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        List<String> productsNamesListInMyCart = cartPage.getListOfProductNamesInMyCart(driver);
        Collections.sort(productsNamesListInMyCart);
        List<String> productsNamesListAsItShouldBe = Arrays.asList(
                "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println(E2ELogMessages.PRODUCTS_IN_CART_CONSOLELOG + productsNamesListInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_PRODUCTS_IN_CART_CONSOLELOG + productsNamesListAsItShouldBe);
        if (productsNamesListInMyCart.equals(productsNamesListAsItShouldBe)) {
            LOG.info(E2ELogMessages.CORRECT_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.NOT_RIGHT_PRODUCTS_IN_CART_ERRORLOG);
        }
        Assert.assertEquals(productsNamesListInMyCart, productsNamesListAsItShouldBe,
                E2ELogMessages.CART_DOES_NOT_CONTAIN_CORRECT_PRODUCTS_VALIDATION_ASSERTLOG);

        LOG.info(E2ELogMessages.CHECK_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 12;
        System.out.println(E2ELogMessages.NUMBER_OF_PRODUCTS_IN_CART_LOG + productsQuantityInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_NUMBER_OF_PRODUCTS_IN_CART_LOG + expectedProductsQuantityInMyCart);
        if (productsQuantityInMyCart == expectedProductsQuantityInMyCart) {
            LOG.info(E2ELogMessages.CORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_NUMBER_OF_PRODUCTS_IN_CART_ERRORLOG);
        }
        Assert.assertEquals(productsQuantityInMyCart, expectedProductsQuantityInMyCart,
                E2ELogMessages.getCorrectNumberOfProductsValidationAssertLog(expectedProductsQuantityInMyCart, productsQuantityInMyCart));

        cartPage.pressProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataSaucelab.VALID_USERNAME_ACC2, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataSaucelab.VALID_PASSWORD_ACC2, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginButton();

        String checkoutPageName = "Checkout";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), checkoutPageName);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        if (checkoutPageTitleText.equals(checkoutPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), checkoutPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), checkoutPageName);
        }
        Assert.assertEquals(checkoutPageTitleText, checkoutPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(checkoutPageName));

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

        LOG.info(E2ELogMessages.CHECK_CORRECT_DELIVERY_AND_PAYMENT_DATA_LOG);
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC2, TestDataSaucelab.ADDRESS_LINE1_ACC2, TestDataSaucelab.CITY_ACC2,
                TestDataSaucelab.STATE_REGION_ACC2, TestDataSaucelab.ZIP_CODE_ACC2, TestDataSaucelab.COUNTRY_ACC2);
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println(E2ELogMessages.DELIVERY_DATA_ON_PAGE_CONSOLELOG + deliveryDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_DELIVERY_DATA_CONSOLELOG + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info(E2ELogMessages.CORRECT_DELIVERY_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_DELIVERY_DATA_ERRORLOG);
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData,
                E2ELogMessages.DELIVERY_DATA_MATCH_VALIDATION_ASSERTLOG);

        List<String> originalPaymentData = Arrays.asList(
                TestDataSaucelab.FULL_NAME_ACC2, TestDataSaucelab.CARD_NUMBER_ACC2, TestDataSaucelab.EXPIRATION_DATE_ACC2);
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println(E2ELogMessages.PAYMENT_DATA_ON_PAGE_CONSOLELOG + paymentDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_PAYMENT_DATA_CONSOLELOG + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info(E2ELogMessages.CORRECT_PAYMENT_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_PAYMENT_DATA_ERRORLOG);
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData,
                E2ELogMessages.PAYMENT_DATA_MATCH_VALIDATION_ASSERTLOG);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        String checkoutCompletePageName = "Checkout Complete";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), checkoutCompletePageName);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        if (checkoutCompletePageTitleText.equals(checkoutCompletePageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), checkoutCompletePageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), checkoutCompletePageName);
        }
        Assert.assertEquals(checkoutCompletePageTitleText, checkoutCompletePageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(checkoutCompletePageName));

        checkoutCompletePage.pressContinueShoppingButton();

        LOG.info(SLabTestLogMessages.CHECK_CART_EMPTY_LOG);
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info(SLabTestLogMessages.CART_EMPTY_LOG);
        } else {
            LOG.error(SLabTestLogMessages.CART_NOT_EMPTY_ERRORLOG);
        }
        Assert.assertTrue(isDisplayedNoItemsText, SLabTestLogMessages.CART_EMPTY_VALIDATION_ASSERTLOG);

        LOG.info(SLabTestLogMessages.CHECK_CART_COUNTER_AVAILABLE_LOG);
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info(SLabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(SLabTestLogMessages.CART_COUNTER_AVAILABLE_ERRORLOG);
        }
        Assert.assertFalse(isDisplayedProductCounter, SLabTestLogMessages.CART_COUNTER_AVAILABLE_VALIDATION_ASSERTLOG);

        AppiumActions.navigateBack(driver);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        String loginPageName = "Login";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), loginPageName);
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        if (loginPageTitleText.equals(loginPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), loginPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), loginPageName);
        }
        Assert.assertEquals(loginPageTitleText, loginPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(loginPageName));
    }
}