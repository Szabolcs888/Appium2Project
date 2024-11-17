package tests.a_sauceLabApk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.a_sauceLabApk.*;
import pages.a_sauceLabApk.ProductsPage;
import pages.a_sauceLabApk.productsPages.*;
import tests._baseTests.SauceLabApkBaseTest;
import utils.AppiumActions;
import utils.CommonUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EndToEndTests extends SauceLabApkBaseTest {
    private static final Logger LOG = LogManager.getLogger(EndToEndTests.class);
    private static final String TEST_DATA_PATH = "src/test/resources/testData/sauceLabCredentials.txt";

    @Test(priority = 1,
            description = "Login first then shopping")
    public void testEndToEnd() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
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
        List<String> theListAsItShouldBe = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println("The products in the cart: \n" + productsNamesListInMyCart);
        System.out.println("The cart should contain these products: \n" + theListAsItShouldBe);
        if (productsNamesListInMyCart.equals(theListAsItShouldBe)) {
            LOG.info("The correct products are in the cart");
        } else {
            LOG.error("There are no correct products in the cart");
        }
        Assert.assertEquals(productsNamesListInMyCart, theListAsItShouldBe, "The cart should contain the correct products, but it does not.");

        LOG.info("We check the number of products in the cart");
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        System.out.println("The number of products in the cart: " + productsQuantityInMyCart);
        System.out.println("This should be the number of products in the cart: 11");
        if (productsQuantityInMyCart == 11) {
            LOG.info("The number of products in the cart is correct");
        } else {
            LOG.error("The number of products in the cart is not correct");
        }
        Assert.assertEquals(productsQuantityInMyCart, 11, "The number of products in the cart should be 11, but it is " + productsQuantityInMyCart + ".");

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
        Assert.assertEquals(checkoutPageTitleText, expectedTitleText, "The page title should be 'Checkout', but it is not.");

        checkoutPage.fillFullNameInput(testData.get(3));
        checkoutPage.fillAddressLine1Input(testData.get(4));
        checkoutPage.fillCityInput(testData.get(5));
        checkoutPage.fillStateRegionInput(testData.get(6));
        checkoutPage.fillZipCodeInput(testData.get(7));
        checkoutPage.fillCountryInput(testData.get(8));
        checkoutPage.pressToPaymentButton();

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver, wait);
        checkoutPaymentPage.fillFullNameInput(testData.get(3));
        checkoutPaymentPage.fillCardNumberInput(testData.get(9));
        checkoutPaymentPage.fillExpirationDateInput(testData.get(10));
        checkoutPaymentPage.fillSecurityCodeInput(testData.get(11));
        checkoutPaymentPage.pressReviewOrderButton();

        LOG.info("We check that the delivery data and payment data are correct");
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);

        List<String> originalDeliveryData = Arrays.asList(testData.get(3), testData.get(4), testData.get(5), testData.get(6), testData.get(7), testData.get(8));
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println("Delivery data is on the page: \n" + deliveryDataOnOrderReviewPage);
        System.out.println("Original delivery data: \n" + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info("The delivery data is correct");
        } else {
            LOG.error("The delivery data is not correct");
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData, "The delivery data should match the provided data, but it does not.");

        List<String> originalPaymentData = Arrays.asList(testData.get(3), testData.get(9), testData.get(10));
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println("Payment data is on the page: \n" + paymentDataOnOrderReviewPage);
        System.out.println("Original payment data: \n" + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info("The payment data is correct");
        } else {
            LOG.error("The payment data is not correct");
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData, "The payment data should match the provided data, but it does not.");

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
        Assert.assertEquals(checkoutCompletePageTitleText, expectedPageTitleText, "The page title should be 'Checkout Complete', but it is not.");

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
        Assert.assertFalse(isDisplayedProductCounter, "The cart counter should not be available, but it is.");

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
        Assert.assertEquals(loginPageTitleText, expectedLoginPageTitleText, "The page title should be 'Login', but it is not.");
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
        List<String> theListAsItShouldBe = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println("The products in the cart: \n" + productsNamesListInMyCart);
        System.out.println("The cart should contain these products: \n" + theListAsItShouldBe);
        if (productsNamesListInMyCart.equals(theListAsItShouldBe)) {
            LOG.info("The correct products are in the cart");
        } else {
            LOG.error("There are no correct products in the cart");
        }
        Assert.assertEquals(productsNamesListInMyCart, theListAsItShouldBe, "The cart should contain the correct products, but it does not.");

        LOG.info("We check the number of products in the cart");
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        System.out.println("The number of products in the cart: " + productsQuantityInMyCart);
        System.out.println("This should be the number of products in the cart: 12");
        if (productsQuantityInMyCart == 12) {
            LOG.info("The number of products in the cart is correct");
        } else {
            LOG.error("The number of products in the cart is not correct");
        }
        Assert.assertEquals(productsQuantityInMyCart, 12, "The number of products in the cart should be 12, but it is " + productsQuantityInMyCart + ".");

        cartPage.pressProceedToCheckoutButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(13), "valid");
        loginPage.fillPasswordInput(testData.get(14), "valid");
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
        Assert.assertEquals(checkoutPageTitleText, expectedTitleText, "The page title should be 'Checkout', but it is not.");

        checkoutPage.fillFullNameInput(testData.get(15));
        checkoutPage.fillAddressLine1Input(testData.get(16));
        checkoutPage.fillCityInput(testData.get(17));
        checkoutPage.fillStateRegionInput(testData.get(18));
        checkoutPage.fillZipCodeInput(testData.get(19));
        checkoutPage.fillCountryInput(testData.get(20));
        checkoutPage.pressToPaymentButton();

        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver, wait);
        checkoutPaymentPage.fillFullNameInput(testData.get(15));
        checkoutPaymentPage.fillCardNumberInput(testData.get(21));
        checkoutPaymentPage.fillExpirationDateInput(testData.get(22));
        checkoutPaymentPage.fillSecurityCodeInput(testData.get(23));
        checkoutPaymentPage.pressReviewOrderButton();

        LOG.info("We check that the delivery data and payment data are correct");
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        AppiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(testData.get(15), testData.get(16), testData.get(17), testData.get(18), testData.get(19), testData.get(20));
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println("Delivery data is on the page: \n" + deliveryDataOnOrderReviewPage);
        System.out.println("Original delivery data: \n" + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            LOG.info("The delivery data is correct");
        } else {
            LOG.error("The delivery data is not correct");
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData, "The delivery data should match the provided data, but it does not.");

        List<String> originalPaymentData = Arrays.asList(testData.get(15), testData.get(21), testData.get(22));
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println("Payment data is on the page: \n" + paymentDataOnOrderReviewPage);
        System.out.println("Original payment data: \n" + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            LOG.info("The payment data is correct");
        } else {
            LOG.error("The payment data is not correct");
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData, "The payment data should match the provided data, but it does not.");

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
        Assert.assertEquals(checkoutCompletePageTitleText, expectedPageTitleText, "The page title should be 'Checkout Complete', but it is not.");

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
        Assert.assertFalse(isDisplayedProductCounter, "The cart counter should not be available, but it is.");

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
        Assert.assertEquals(loginPageTitleText, expectedLoginPageTitleText, "The page title should be 'Login', but it is not.");
    }
}
