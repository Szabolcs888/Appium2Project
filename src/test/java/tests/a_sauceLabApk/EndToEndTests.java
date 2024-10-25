package tests.a_sauceLabApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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

@Listeners(TestListener.class)
public class EndToEndTests extends SauceLabApkBaseTest {
    private static final Logger log = LogManager.getLogger(EndToEndTests.class);
    private static final String testDataPath = "src/test/resources/testData/SauceLabCredentials.txt";

    @Test(priority = 1,
            description = "Login first then shopping")
    public void testEndToEnd() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.pressDropdownMenuButton();
        productsPage.pressAbcOrderOption();

        productsPage.pressBikeLightProductText();
        BikeLightPage BikeLightPage = new BikeLightPage(driver);
        BikeLightPage.pressCounterPlusButton();
        BikeLightPage.pressAddToCartButton();
        AppiumActions appiumActions = new AppiumActions();
        appiumActions.navigateBack(driver);

        productsPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        boltTShirtPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);
        appiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);

        productsPage.pressOnesieProductText();
        OnesiePage OnesiePage = new OnesiePage(driver);
        OnesiePage.pressBlackCircleButton();
        OnesiePage.pressCounterPlusButton();
        OnesiePage.pressCounterPlusButton();
        OnesiePage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        productsPage.pressTestAllTheThingsTShirtProductText();
        TestAllTheThingsTShirtPage testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        testAllTheThingsTShirtPage.pressGrayCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        productsPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        log.info("We check whether the correct products are in the cart");
        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        List<String> productsNamesListInMyCart = cartPage.getTheListOfProductNamesInMyCart(driver);
        Collections.sort(productsNamesListInMyCart);
        List<String> theListAsItShouldBe = Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println("The products in the cart: \n" + productsNamesListInMyCart);
        System.out.println("The cart should contain these products: \n" + theListAsItShouldBe);
        if (productsNamesListInMyCart.equals(theListAsItShouldBe)) {
            log.info("The correct products are in the cart");
        } else {
            log.error("There are no correct products in the cart");
        }
        Assert.assertEquals(productsNamesListInMyCart, theListAsItShouldBe);

        log.info("We check the number of products in the cart");
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        System.out.println("The number of products in the cart: " + productsQuantityInMyCart);
        System.out.println("This should be the number of products in the cart: 11");
        if (productsQuantityInMyCart == 11) {
            log.info("The number of products in the cart is correct");
        } else {
            log.error("The number of products in the cart is not correct");
        }
        Assert.assertEquals(productsQuantityInMyCart, 11);

        cartPage.pressProceedToCheckoutButton();

        log.info("We check whether we are on the 'Checkout' page");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        String expectedTitleText = "Checkout";
        if (checkoutPageTitleText.equals(expectedTitleText)) {
            log.info("We are on the 'Checkout' page");
        } else {
            log.error("We are not on the 'Checkout' page");
        }
        Assert.assertEquals(checkoutPageTitleText, expectedTitleText);

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

        log.info("We check that the delivery data and payment data are correct");
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        appiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);

        List<String> originalDeliveryData = Arrays.asList(testData.get(3), testData.get(4), testData.get(5), testData.get(6), testData.get(7), testData.get(8));
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println("Delivery data is on the page: \n" + deliveryDataOnOrderReviewPage);
        System.out.println("Original delivery data: \n" + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            log.info("The delivery data is correct");
        } else {
            log.error("The delivery data is not correct");
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData);

        List<String> originalPaymentData = Arrays.asList(testData.get(3), testData.get(9), testData.get(10));
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println("Payment data is on the page: \n" + paymentDataOnOrderReviewPage);
        System.out.println("Original payment data: \n" + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            log.info("The payment data is correct");
        } else {
            log.error("The payment data is not correct");
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        log.info("We check whether we are on the 'Checkout Complete' page");
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        String expectedPageTitleText = "Checkout Complete";
        if (checkoutCompletePageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Checkout Complete' page");
        } else {
            log.error("We are not on the 'Checkout Complete' page");
        }
        Assert.assertEquals(checkoutCompletePageTitleText, expectedPageTitleText);

        checkoutCompletePage.pressContinueShoppingButton();

        log.info("We check if the cart is empty");
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            log.info("The cart is empty");
        } else {
            log.error("The cart is not empty");
        }
        Assert.assertTrue(isDisplayedNoItemsText);

        log.info("We check if the cart counter is available");
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            log.info("The cart counter is not available");
        } else {
            log.error("The cart counter is available");
        }
        Assert.assertFalse(isDisplayedProductCounter);

        appiumActions.navigateBack(driver);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        log.info("We check whether we are on the 'Login' page");
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        String expectedLoginPageTitleText = "Login";
        if (loginPageTitleText.equals(expectedLoginPageTitleText)) {
            log.info("We are on the 'Login' page");
        } else {
            log.error("We are not on the 'Login' page");
        }
        Assert.assertEquals(loginPageTitleText, expectedLoginPageTitleText);
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
        AppiumActions appiumActions = new AppiumActions();
        appiumActions.navigateBack(driver);

        productsPage.pressOnesieProductText();
        OnesiePage OnesiePage = new OnesiePage(driver);
        OnesiePage.pressCounterPlusButton();
        OnesiePage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        productsPage.pressBikeLightProductText();
        BikeLightPage BikeLightPage = new BikeLightPage(driver);
        BikeLightPage.pressCounterPlusButton();
        BikeLightPage.pressCounterPlusButton();
        BikeLightPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        productsPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);
        appiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);

        productsPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        productsPage.pressBackpackProductText();
        BackPackPage backPackPage = new BackPackPage(driver);
        backPackPage.pressBlueCircleButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        log.info("We check whether the correct products are in the cart");
        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        List<String> productsNamesListInMyCart = cartPage.getTheListOfProductNamesInMyCart(driver);
        Collections.sort(productsNamesListInMyCart);
        List<String> theListAsItShouldBe = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt");
        System.out.println("The products in the cart: \n" + productsNamesListInMyCart);
        System.out.println("The cart should contain these products: \n" + theListAsItShouldBe);
        if (productsNamesListInMyCart.equals(theListAsItShouldBe)) {
            log.info("The correct products are in the cart");
        } else {
            log.error("There are no correct products in the cart");
        }
        Assert.assertEquals(productsNamesListInMyCart, theListAsItShouldBe);

        log.info("We check the number of products in the cart");
        int productsQuantityInMyCart = productsPage.getProductCounterOnCartBadgeButton();
        System.out.println("The number of products in the cart: " + productsQuantityInMyCart);
        System.out.println("This should be the number of products in the cart: 12");
        if (productsQuantityInMyCart == 12) {
            log.info("The number of products in the cart is correct");
        } else {
            log.error("The number of products in the cart is not correct");
        }
        Assert.assertEquals(productsQuantityInMyCart, 12);

        cartPage.pressProceedToCheckoutButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(13), "valid");
        loginPage.fillPasswordInput(testData.get(14), "valid");
        loginPage.pressLoginButton();

        log.info("We check whether we are on the 'Checkout' page");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String checkoutPageTitleText = checkoutPage.getCheckoutPageTitleText();
        String expectedTitleText = "Checkout";
        if (checkoutPageTitleText.equals(expectedTitleText)) {
            log.info("We are on the 'Checkout' page");
        } else {
            log.error("We are not on the 'Checkout' page");
        }
        Assert.assertEquals(checkoutPageTitleText, expectedTitleText);

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

        log.info("We check that the delivery data and payment data are correct");
        CheckoutOrderReviewPage checkoutOrderReviewPage = new CheckoutOrderReviewPage(driver);
        appiumActions.scrollWithFixCoordinates(driver, 2, "DOWN", 0.5);
        List<String> originalDeliveryData = Arrays.asList(testData.get(15), testData.get(16), testData.get(17), testData.get(18), testData.get(19), testData.get(20));
        List<String> deliveryDataOnOrderReviewPage = checkoutOrderReviewPage.getDeliveryAddressData();
        System.out.println("Delivery data is on the page: \n" + deliveryDataOnOrderReviewPage);
        System.out.println("Original delivery data: \n" + originalDeliveryData);
        if (deliveryDataOnOrderReviewPage.equals(originalDeliveryData)) {
            log.info("The delivery data is correct");
        } else {
            log.error("The delivery data is not correct");
        }
        Assert.assertEquals(deliveryDataOnOrderReviewPage, originalDeliveryData);

        List<String> originalPaymentData = Arrays.asList(testData.get(15), testData.get(21), testData.get(22));
        List<String> paymentDataOnOrderReviewPage = checkoutOrderReviewPage.getPaymentData();
        System.out.println("Payment data is on the page: \n" + paymentDataOnOrderReviewPage);
        System.out.println("Original payment data: \n" + originalPaymentData);
        if (paymentDataOnOrderReviewPage.equals(originalPaymentData)) {
            log.info("The payment data is correct");
        } else {
            log.error("The payment data is not correct");
        }
        Assert.assertEquals(paymentDataOnOrderReviewPage, originalPaymentData);

        checkoutOrderReviewPage.pressPlaceOrderButton();

        log.info("We check whether we are on the 'Checkout Complete' page");
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String checkoutCompletePageTitleText = checkoutCompletePage.getCheckoutCompletePageTitleText();
        String expectedPageTitleText = "Checkout Complete";
        if (checkoutCompletePageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Checkout Complete' page");
        } else {
            log.error("We are not on the 'Checkout Complete' page");
        }
        Assert.assertEquals(checkoutCompletePageTitleText, expectedPageTitleText);

        checkoutCompletePage.pressContinueShoppingButton();

        log.info("We check if the cart is empty");
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver);
        productsPage.pressCartBadgeButton();
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            log.info("The cart is empty");
        } else {
            log.error("The cart is not empty");
        }
        Assert.assertTrue(isDisplayedNoItemsText);

        log.info("We check if the cart counter is available");
        boolean isDisplayedProductCounter = productsPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            log.info("The cart counter is not available");
        } else {
            log.error("The cart counter is available");
        }
        Assert.assertFalse(isDisplayedProductCounter);

        appiumActions.navigateBack(driver);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();

        log.info("We check whether we are on the 'Login' page");
        String loginPageTitleText = loginPage.getLoginPageTitleText();
        String expectedLoginPageTitleText = "Login";
        if (loginPageTitleText.equals(expectedLoginPageTitleText)) {
            log.info("We are on the 'Login' page");
        } else {
            log.error("We are not on the 'Login' page");
        }
        Assert.assertEquals(loginPageTitleText, expectedLoginPageTitleText);
    }
}
