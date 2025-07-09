package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.configdata.models.accounts.SauceLabsAppAccount;
import com.myappium2project.configdata.providers.accounts.SauceLabsAppAccountProvider;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.pages.nativeapps.saucelabs.*;
import com.myappium2project.pages.nativeapps.saucelabs.productspages.*;
import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.common.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Performs full end-to-end tests.
 * Covers complete shopping flows both with login before and after product selection,
 * including product selection, cart validation, checkout, and logout.
 */
@Test(groups = {TestGroups.E2E})
public class EndToEndTests extends SauceLabsAppTestBase {
    private static final SauceLabsAppAccount SAUCE_ACC1 = SauceLabsAppAccountProvider.getAccount(0);
    private static final SauceLabsAppAccount SAUCE_ACC2 = SauceLabsAppAccountProvider.getAccount(1);

    private LoginPage loginPage;
    private HamburgerMenu hamburgerMenu;
    private ProductsPage productsPage;
    private BikeLightPage bikeLightPage;
    private BoltTShirtPage boltTShirtPage;
    private OnesiePage onesiePage;
    private TestAllTheThingsTShirtPage testAllTheThingsTShirtPage;
    private FleeceJacketPage fleeceJacketPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutPaymentPage checkoutPaymentPage;
    private CheckoutOrderReviewPage checkoutOrderReviewPage;
    private CheckoutCompletePage checkoutCompletePage;
    private CartNoItemsPage cartNoItemsPage;

    @BeforeMethod(alwaysRun = true)
    public void initializePageObjects() {
        hamburgerMenu = new HamburgerMenu(driver, wait);
        productsPage = new ProductsPage(driver, wait);
        bikeLightPage = new BikeLightPage(driver);
        boltTShirtPage = new BoltTShirtPage(driver);
        onesiePage = new OnesiePage(driver);
        testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        fleeceJacketPage = new FleeceJacketPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        cartNoItemsPage = new CartNoItemsPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1,
            description = "Login first then shopping")
    public void testEndToEndWithLoginBeforeShopping() throws InterruptedException {
        SauceLabsCommonSteps.loginToSauceLabs(driver, hamburgerMenu, SAUCE_ACC1);

        productsPage.pressDropdownMenuButton();
        productsPage.pressAbcOrderOption();

        productsPage.pressBikeLightProductText();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBoltTShirtProductText();
        boltTShirtPage.pressAddToCartButton();
        boltTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        SauceLabsCommonSteps.scrollDown(driver);

        productsPage.pressOnesieProductText();
        onesiePage.pressBlackCircleButton();
        onesiePage.pressCounterPlusButton();
        onesiePage.pressCounterPlusButton();
        onesiePage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressTestAllTheThingsTShirtProductText();
        testAllTheThingsTShirtPage.pressGrayCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressFleeceJacketProductText();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressCartBadgeButton();
        List<String> productsNamesListInMyCart = cartPage.getListOfProductNamesInMyCart(driver);
        List<String> productsNamesListAsItShouldBe = Arrays.asList(
                "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        verifyProductsInCart(productsNamesListInMyCart, productsNamesListAsItShouldBe);

        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 11;
        verifyProductCount(productsQuantityInMyCart, expectedProductsQuantityInMyCart);

        cartPage.pressProceedToCheckoutButton();

        String checkoutPageName = "Checkout";
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(checkoutPageTitleText, checkoutPageName);

        checkoutPage.fillFullNameInput(SAUCE_ACC1.getName());
        checkoutPage.fillAddressLine1Input(SAUCE_ACC1.getAddressLine());
        checkoutPage.fillCityInput(SAUCE_ACC1.getCity());
        checkoutPage.fillStateRegionInput(SAUCE_ACC1.getRegion());
        checkoutPage.fillZipCodeInput(SAUCE_ACC1.getZipCode());
        checkoutPage.fillCountryInput(SAUCE_ACC1.getCountry());
        checkoutPage.pressToPaymentButton();

        checkoutPaymentPage.fillFullNameInput(SAUCE_ACC1.getName());
        checkoutPaymentPage.fillCardNumberInput(SAUCE_ACC1.getCardNumber());
        checkoutPaymentPage.fillExpirationDateInput(SAUCE_ACC1.getExpDate());
        checkoutPaymentPage.fillSecurityCodeInput(SAUCE_ACC1.getSecCode());
        checkoutPaymentPage.pressReviewOrderButton();

        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(
                SAUCE_ACC1.getName(), SAUCE_ACC1.getAddressLine(), SAUCE_ACC1.getCity(),
                SAUCE_ACC1.getRegion(), SAUCE_ACC1.getZipCode(), SAUCE_ACC1.getCountry());
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        verifyDeliveryData(deliveryDataOnOrderReviewPage, originalDeliveryData);

        List<String> originalPaymentData = Arrays.asList(
                SAUCE_ACC1.getName(), SAUCE_ACC1.getCardNumber(), SAUCE_ACC1.getExpDate());
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        verifyPaymentData(paymentDataOnOrderReviewPage, originalPaymentData);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        String checkoutCompletePageName = "Checkout Complete";
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(checkoutCompletePageTitleText, checkoutCompletePageName);

        checkoutCompletePage.pressContinueShoppingButton();

        productsPage.pressCartBadgeButton();
        SauceLabsCommonAssertions.verifyCartIsEmpty(cartNoItemsPage);
        SauceLabsCommonAssertions.verifyCartCounterIsNotAvailable(productsPage);

        AppiumActions.navigateBack(driver);

        SauceLabsCommonSteps.logOutToSauceLabs(hamburgerMenu, loginPage);

        String loginPageName = "Login";
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(loginPageTitleText, loginPageName);
    }

    @Test(priority = 2,
            description = "Shopping first then login")
    public void testEndToEndWithShoppingBeforeLogin() throws InterruptedException {
        productsPage.pressDropdownMenuButton();
        productsPage.pressPriceAscendingOrderOption();
        productsPage.pressTestAllTheThingsTShirtProductText();

        testAllTheThingsTShirtPage.pressBlackCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressOnesieProductText();
        onesiePage.pressCounterPlusButton();
        onesiePage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBikeLightProductText();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBoltTShirtProductText();
        boltTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        SauceLabsCommonSteps.scrollDown(driver);

        productsPage.pressFleeceJacketProductText();
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

        productsPage.pressCartBadgeButton();
        List<String> productsNamesListInMyCart = cartPage.getListOfProductNamesInMyCart(driver);
        List<String> productsNamesListAsItShouldBe = Arrays.asList(
                "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        verifyProductsInCart(productsNamesListInMyCart, productsNamesListAsItShouldBe);

        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        int expectedProductsQuantityInMyCart = 12;
        verifyProductCount(productsQuantityInMyCart, expectedProductsQuantityInMyCart);

        cartPage.pressProceedToCheckoutButton();

        loginPage.fillUserNameInput(SAUCE_ACC2.getEmail(), CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(SAUCE_ACC2.getPassword(), CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        String checkoutPageName = "Checkout";
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(checkoutPageTitleText, checkoutPageName);

        checkoutPage.fillFullNameInput(SAUCE_ACC2.getName());
        checkoutPage.fillAddressLine1Input(SAUCE_ACC2.getAddressLine());
        checkoutPage.fillCityInput(SAUCE_ACC2.getCity());
        checkoutPage.fillStateRegionInput(SAUCE_ACC2.getRegion());
        checkoutPage.fillZipCodeInput(SAUCE_ACC2.getZipCode());
        checkoutPage.fillCountryInput(SAUCE_ACC2.getCountry());
        checkoutPage.pressToPaymentButton();

        checkoutPaymentPage.fillFullNameInput(SAUCE_ACC2.getName());
        checkoutPaymentPage.fillCardNumberInput(SAUCE_ACC2.getCardNumber());
        checkoutPaymentPage.fillExpirationDateInput(SAUCE_ACC2.getExpDate());
        checkoutPaymentPage.fillSecurityCodeInput(SAUCE_ACC2.getSecCode());
        checkoutPaymentPage.pressReviewOrderButton();

        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(
                SAUCE_ACC2.getName(), SAUCE_ACC2.getAddressLine(), SAUCE_ACC2.getCity(),
                SAUCE_ACC2.getRegion(), SAUCE_ACC2.getZipCode(), SAUCE_ACC2.getCountry());
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        verifyDeliveryData(deliveryDataOnOrderReviewPage, originalDeliveryData);

        List<String> originalPaymentData = Arrays.asList(
                SAUCE_ACC2.getName(), SAUCE_ACC2.getCardNumber(), SAUCE_ACC2.getExpDate());
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        verifyPaymentData(paymentDataOnOrderReviewPage, originalPaymentData);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        String checkoutCompletePageName = "Checkout Complete";
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(checkoutCompletePageTitleText, checkoutCompletePageName);

        checkoutCompletePage.pressContinueShoppingButton();

        productsPage.pressCartBadgeButton();
        SauceLabsCommonAssertions.verifyCartIsEmpty(cartNoItemsPage);
        SauceLabsCommonAssertions.verifyCartCounterIsNotAvailable(productsPage);

        AppiumActions.navigateBack(driver);

        SauceLabsCommonSteps.logOutToSauceLabs(hamburgerMenu, loginPage);

        String loginPageName = "Login";
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(loginPageTitleText, loginPageName);
    }

    private void verifyProductsInCart(List<String> actual, List<String> expected) {
        LOG.info("We check if the correct products are in the cart");
        Collections.sort(actual);
        Collections.sort(expected);
        System.out.println("The products in the cart: " + System.lineSeparator() + actual);
        System.out.println("The cart should contain these products: " + System.lineSeparator() + expected);

        if (actual.equals(expected)) {
            LOG.info("The correct products are in the cart");
        } else {
            LOG.error("There are not the right products in the cart");
        }

        Assert.assertEquals(actual, expected, "The cart should contain the correct products, but it does not.");
    }

    private void verifyProductCount(int actualProductCount, int expectedProductCount) {
        LOG.info("We check the number of products in the cart");
        System.out.println("The number of products in the cart: " + actualProductCount);
        System.out.println("This should be the number of products in the cart: " + expectedProductCount);

        if (actualProductCount == expectedProductCount) {
            LOG.info("The number of products in the cart is correct");
        } else {
            LOG.error("The number of products in the cart is not correct");
        }

        Assert.assertEquals(actualProductCount, expectedProductCount,
                "The number of products in the cart should be " + expectedProductCount + ", but it is " + actualProductCount + ".");
    }

    private void verifyDeliveryData(List<String> actualDeliveryData, List<String> expectedDeliveryData) {
        LOG.info("We check that the delivery data is correct");
        System.out.println("Delivery data is on the page: " + System.lineSeparator() + actualDeliveryData);
        System.out.println("Original delivery data: " + System.lineSeparator() + expectedDeliveryData);

        if (actualDeliveryData.equals(expectedDeliveryData)) {
            LOG.info("The delivery data is correct");
        } else {
            LOG.error("The delivery data is not correct");
        }

        Assert.assertEquals(actualDeliveryData, expectedDeliveryData,
                "The delivery data should match the provided data, but it does not.");
    }

    private void verifyPaymentData(List<String> actualPaymentData, List<String> expectedPaymentData) {
        LOG.info("We check that the payment data is correct");
        System.out.println("Payment data is on the page: " + System.lineSeparator() + actualPaymentData);
        System.out.println("Original payment data: " + System.lineSeparator() + expectedPaymentData);

        if (actualPaymentData.equals(expectedPaymentData)) {
            LOG.info("The payment data is correct");
        } else {
            LOG.error("The payment data is not correct");
        }

        Assert.assertEquals(actualPaymentData, expectedPaymentData,
                "The payment data should match the provided data, but it does not.");
    }
}