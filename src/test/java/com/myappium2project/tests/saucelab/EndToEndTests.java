package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SlabTestLogMessages;
import com.myappium2project.pages.saucelab.*;
import com.myappium2project.pages.saucelab.productspages.*;
import com.myappium2project.tests.basetests.SauceLabApkTestBase;
import com.myappium2project.testsdata.SaucelabData;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Test(groups = {TestGroups.E2E})
public class EndToEndTests extends SauceLabApkTestBase {
    // I used an inner class in this class because there are too many variables and I wanted to separate them from the tests.
    private static final class E2ELogMessages {
        private static final String CHECK_CORRECT_PRODUCT_IN_CART_LOG = "We check if the correct products are in the cart";
        private static final String PRODUCTS_IN_CART_LOG = "The products in the cart: " + System.lineSeparator();
        private static final String EXPECTED_PRODUCTS_IN_CART_LOG = "The cart should contain these products: " + System.lineSeparator();
        private static final String CORRECT_PRODUCTS_IN_CART_LOG = "The correct products are in the cart";
        private static final String NOT_RIGHT_PRODUCTS_IN_CART_LOG = "There are not the right products in the cart.";
        private static final String NOT_RIGHT_PRODUCTS_IN_CART_ASSERT_LOG = "The cart should contain the correct products, but it does not.";

        private static final String CHECK_NUMBER_OF_PRODUCTS_IN_CART_LOG = "We check the number of products in the cart";
        private static final String NUMBER_OF_PRODUCTS_IN_CART_LOG = "The number of products in the cart: ";
        private static final String EXPECTED_NUMBER_OF_PRODUCTS_IN_CART_LOG = "This should be the number of products in the cart: ";
        private static final String CORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG = "The number of products in the cart is correct";
        private static final String INCORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG = "The number of products in the cart is not correct";

        private static final String CHECK_CORRECT_DELIVERY_AND_PAYMENT_DATA_LOG = "We check that the delivery data and payment data are correct";
        private static final String DELIVERY_DATA_ON_PAGE_LOG = "Delivery data is on the page: " + System.lineSeparator();
        private static final String ORIGINAL_DELIVERY_DATA_LOG = "Original delivery data: " + System.lineSeparator();
        private static final String CORRECT_DELIVERY_DATA_LOG = "The delivery data is correct";
        private static final String INCORRECT_DELIVERY_DATA_LOG = "The delivery data is correct";
        private static final String INCORRECT_DELIVERY_DATA_ASSERT_LOG = "The delivery data should match the provided data, but it does not.";

        private static final String PAYMENT_DATA_ON_PAGE_LOG = "Payment data is on the page: " + System.lineSeparator();
        private static final String ORIGINAL_PAYMENT_DATA_LOG = "Original payment data: " + System.lineSeparator();
        private static final String CORRECT_PAYMENT_DATA_LOG = "The payment data is correct";
        private static final String INCORRECT_PAYMENT_DATA_LOG = "The payment data is not correct";
        private static final String INCORRECT_PAYMENT_DATA_ASSERT_LOG = "The payment data should match the provided data, but it does not.";

        private static String incorrectNumberOfProductsAssertLog(
                int expectedProductsQuantityInMyCart, int productsQuantityInMyCart) {
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
        loginPage.fillUserNameInput(SaucelabData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(SaucelabData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
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
        System.out.println(E2ELogMessages.PRODUCTS_IN_CART_LOG + productsNamesListInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_PRODUCTS_IN_CART_LOG + productsNamesListAsItShouldBe);
        if (productsNamesListInMyCart.equals(productsNamesListAsItShouldBe)) {
            LOG.info(E2ELogMessages.CORRECT_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.NOT_RIGHT_PRODUCTS_IN_CART_LOG);
        }
        Assert.assertEquals(productsNamesListInMyCart, productsNamesListAsItShouldBe,
                E2ELogMessages.NOT_RIGHT_PRODUCTS_IN_CART_ASSERT_LOG);

        LOG.info(E2ELogMessages.CHECK_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 11;
        System.out.println(E2ELogMessages.NUMBER_OF_PRODUCTS_IN_CART_LOG + productsQuantityInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_NUMBER_OF_PRODUCTS_IN_CART_LOG + expectedProductsQuantityInMyCart);
        if (productsQuantityInMyCart == expectedProductsQuantityInMyCart) {
            LOG.info(E2ELogMessages.CORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        }
        Assert.assertEquals(productsQuantityInMyCart, expectedProductsQuantityInMyCart,
                E2ELogMessages.incorrectNumberOfProductsAssertLog(expectedProductsQuantityInMyCart, productsQuantityInMyCart));

        cartPage.pressProceedToCheckoutButton();

        String checkoutPageName = "Checkout";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, checkoutPageName);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        if (checkoutPageTitleText.equals(checkoutPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, checkoutPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, checkoutPageName);
        }
        Assert.assertEquals(checkoutPageTitleText, checkoutPageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(checkoutPageName));

        checkoutPage.fillFullNameInput(SaucelabData.FULL_NAME_ACC1);
        checkoutPage.fillAddressLine1Input(SaucelabData.ADDRESS_LINE1_ACC1);
        checkoutPage.fillCityInput(SaucelabData.CITY_ACC1);
        checkoutPage.fillStateRegionInput(SaucelabData.STATE_REGION_ACC1);
        checkoutPage.fillZipCodeInput(SaucelabData.ZIP_CODE_ACC1);
        checkoutPage.fillCountryInput(SaucelabData.COUNTRY_ACC1);
        checkoutPage.pressToPaymentButton();

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.fillFullNameInput(SaucelabData.FULL_NAME_ACC1);
        checkoutPaymentPage.fillCardNumberInput(SaucelabData.CARD_NUMBER_ACC1);
        checkoutPaymentPage.fillExpirationDateInput(SaucelabData.EXPIRATION_DATE_ACC1);
        checkoutPaymentPage.fillSecurityCodeInput(SaucelabData.SECURITY_CODE_ACC1);
        checkoutPaymentPage.pressReviewOrderButton();

        LOG.info(E2ELogMessages.CHECK_CORRECT_DELIVERY_AND_PAYMENT_DATA_LOG);
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);

        List<String> originalDeliveryData = Arrays.asList(
                SaucelabData.FULL_NAME_ACC1, SaucelabData.ADDRESS_LINE1_ACC1, SaucelabData.CITY_ACC1,
                SaucelabData.STATE_REGION_ACC1, SaucelabData.ZIP_CODE_ACC1, SaucelabData.COUNTRY_ACC1);
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println(E2ELogMessages.DELIVERY_DATA_ON_PAGE_LOG + deliveryDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_DELIVERY_DATA_LOG + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info(E2ELogMessages.CORRECT_DELIVERY_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_DELIVERY_DATA_LOG);
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData,
                E2ELogMessages.INCORRECT_DELIVERY_DATA_ASSERT_LOG);

        List<String> originalPaymentData = Arrays.asList(
                SaucelabData.FULL_NAME_ACC1, SaucelabData.CARD_NUMBER_ACC1, SaucelabData.EXPIRATION_DATE_ACC1);
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println(E2ELogMessages.PAYMENT_DATA_ON_PAGE_LOG + paymentDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_PAYMENT_DATA_LOG + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info(E2ELogMessages.CORRECT_PAYMENT_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_PAYMENT_DATA_LOG);
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData,
                E2ELogMessages.INCORRECT_PAYMENT_DATA_ASSERT_LOG);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        String checkoutCompletePageName = "Checkout Complete";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, checkoutCompletePageName);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        if (checkoutCompletePageTitleText.equals(checkoutCompletePageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, checkoutCompletePageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, checkoutCompletePageName);
        }
        Assert.assertEquals(checkoutCompletePageTitleText, checkoutCompletePageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(checkoutCompletePageName));

        checkoutCompletePage.pressContinueShoppingButton();

        LOG.info(SlabTestLogMessages.CHECK_CART_EMPTY_LOG);
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info(SlabTestLogMessages.CART_EMPTY_LOG);
        } else {
            LOG.error(SlabTestLogMessages.CART_NOT_EMPTY_LOG);
        }
        Assert.assertTrue(isDisplayedNoItemsText, SlabTestLogMessages.CART_NOT_EMPTY_ASSERT_LOG);

        LOG.info(SlabTestLogMessages.CHECK_CART_COUNTER_AVAILABLE_LOG);
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info(SlabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(SlabTestLogMessages.CART_COUNTER_AVAILABLE_LOG);
        }
        Assert.assertFalse(isDisplayedProductCounter, SlabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_ASSERT_LOG);

        AppiumActions.navigateBack(driver);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        String loginPageName = "Login";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, loginPageName);
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        if (loginPageTitleText.equals(loginPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, loginPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, loginPageName);
        }
        Assert.assertEquals(loginPageTitleText, loginPageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(loginPageName));
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
        System.out.println(E2ELogMessages.PRODUCTS_IN_CART_LOG + productsNamesListInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_PRODUCTS_IN_CART_LOG + productsNamesListAsItShouldBe);
        if (productsNamesListInMyCart.equals(productsNamesListAsItShouldBe)) {
            LOG.info(E2ELogMessages.CORRECT_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.NOT_RIGHT_PRODUCTS_IN_CART_LOG);
        }
        Assert.assertEquals(productsNamesListInMyCart, productsNamesListAsItShouldBe,
                E2ELogMessages.NOT_RIGHT_PRODUCTS_IN_CART_ASSERT_LOG);

        LOG.info(E2ELogMessages.CHECK_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 12;
        System.out.println(E2ELogMessages.NUMBER_OF_PRODUCTS_IN_CART_LOG + productsQuantityInMyCart);
        System.out.println(E2ELogMessages.EXPECTED_NUMBER_OF_PRODUCTS_IN_CART_LOG + expectedProductsQuantityInMyCart);
        if (productsQuantityInMyCart == expectedProductsQuantityInMyCart) {
            LOG.info(E2ELogMessages.CORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_NUMBER_OF_PRODUCTS_IN_CART_LOG);
        }
        Assert.assertEquals(productsQuantityInMyCart, expectedProductsQuantityInMyCart,
                E2ELogMessages.incorrectNumberOfProductsAssertLog(expectedProductsQuantityInMyCart, productsQuantityInMyCart));

        cartPage.pressProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(SaucelabData.VALID_USERNAME_ACC2, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(SaucelabData.VALID_PASSWORD_ACC2, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        String checkoutPageName = "Checkout";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, checkoutPageName);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        if (checkoutPageTitleText.equals(checkoutPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, checkoutPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, checkoutPageName);
        }
        Assert.assertEquals(checkoutPageTitleText, checkoutPageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(checkoutPageName));

        checkoutPage.fillFullNameInput(SaucelabData.FULL_NAME_ACC2);
        checkoutPage.fillAddressLine1Input(SaucelabData.ADDRESS_LINE1_ACC2);
        checkoutPage.fillCityInput(SaucelabData.CITY_ACC2);
        checkoutPage.fillStateRegionInput(SaucelabData.STATE_REGION_ACC2);
        checkoutPage.fillZipCodeInput(SaucelabData.ZIP_CODE_ACC2);
        checkoutPage.fillCountryInput(SaucelabData.COUNTRY_ACC2);
        checkoutPage.pressToPaymentButton();

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.fillFullNameInput(SaucelabData.FULL_NAME_ACC2);
        checkoutPaymentPage.fillCardNumberInput(SaucelabData.CARD_NUMBER_ACC2);
        checkoutPaymentPage.fillExpirationDateInput(SaucelabData.EXPIRATION_DATE_ACC2);
        checkoutPaymentPage.fillSecurityCodeInput(SaucelabData.SECURITY_CODE_ACC2);
        checkoutPaymentPage.pressReviewOrderButton();

        LOG.info(E2ELogMessages.CHECK_CORRECT_DELIVERY_AND_PAYMENT_DATA_LOG);
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(
                SaucelabData.FULL_NAME_ACC2, SaucelabData.ADDRESS_LINE1_ACC2, SaucelabData.CITY_ACC2,
                SaucelabData.STATE_REGION_ACC2, SaucelabData.ZIP_CODE_ACC2, SaucelabData.COUNTRY_ACC2);
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println(E2ELogMessages.DELIVERY_DATA_ON_PAGE_LOG + deliveryDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_DELIVERY_DATA_LOG + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info(E2ELogMessages.CORRECT_DELIVERY_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_DELIVERY_DATA_LOG);
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData,
                E2ELogMessages.INCORRECT_DELIVERY_DATA_ASSERT_LOG);

        List<String> originalPaymentData = Arrays.asList(
                SaucelabData.FULL_NAME_ACC2, SaucelabData.CARD_NUMBER_ACC2, SaucelabData.EXPIRATION_DATE_ACC2);
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println(E2ELogMessages.PAYMENT_DATA_ON_PAGE_LOG + paymentDataOnOrderReviewPage);
        System.out.println(E2ELogMessages.ORIGINAL_PAYMENT_DATA_LOG + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info(E2ELogMessages.CORRECT_PAYMENT_DATA_LOG);
        } else {
            LOG.error(E2ELogMessages.INCORRECT_PAYMENT_DATA_LOG);
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData,
                E2ELogMessages.INCORRECT_PAYMENT_DATA_ASSERT_LOG);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        String checkoutCompletePageName = "Checkout Complete";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, checkoutCompletePageName);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        if (checkoutCompletePageTitleText.equals(checkoutCompletePageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, checkoutCompletePageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, checkoutCompletePageName);
        }
        Assert.assertEquals(checkoutCompletePageTitleText, checkoutCompletePageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(checkoutCompletePageName));

        checkoutCompletePage.pressContinueShoppingButton();

        LOG.info(SlabTestLogMessages.CHECK_CART_EMPTY_LOG);
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            LOG.info(SlabTestLogMessages.CART_EMPTY_LOG);
        } else {
            LOG.error(SlabTestLogMessages.CART_NOT_EMPTY_LOG);
        }
        Assert.assertTrue(isDisplayedNoItemsText, SlabTestLogMessages.CART_NOT_EMPTY_ASSERT_LOG);

        LOG.info(SlabTestLogMessages.CHECK_CART_COUNTER_AVAILABLE_LOG);
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            LOG.info(SlabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_LOG);
        } else {
            LOG.error(SlabTestLogMessages.CART_COUNTER_AVAILABLE_LOG);
        }
        Assert.assertFalse(isDisplayedProductCounter, SlabTestLogMessages.CART_COUNTER_NOT_AVAILABLE_ASSERT_LOG);

        AppiumActions.navigateBack(driver);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        String loginPageName = "Login";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, loginPageName);
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        if (loginPageTitleText.equals(loginPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, loginPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, loginPageName);
        }
        Assert.assertEquals(loginPageTitleText, loginPageName,
                SlabTestLogMessages.incorrectPageTitleAssertLog(loginPageName));
    }
}