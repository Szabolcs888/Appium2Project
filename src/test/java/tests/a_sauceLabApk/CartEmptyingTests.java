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

import java.util.List;

@Listeners(TestListener.class)
public class CartEmptyingTests extends SauceLabApkBaseTest {
    private static final Logger log = LogManager.getLogger(CartEmptyingTests.class);
    private static final String testDataPath = "src/test/resources/testData/sauceLabCredentials.txt";

    @Test(timeOut = 45000, priority = 1)
    public void testPlacingProductsInTheCartAndThenEmptyingThemSL() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginButton();

        ProductsPage productPage = new ProductsPage(driver, wait);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceAscendingOrderOption();
        productPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        AppiumActions appiumActions = new AppiumActions();
        appiumActions.navigateBack(driver);

        productPage.pressTestAllTheThingsTShirtProductText();
        TestAllTheThingsTShirtPage testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        testAllTheThingsTShirtPage.pressGrayCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);
        appiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);

        productPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressAddToCartButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);

        productPage.pressBackpackProductText();
        BackPackPage backPackPage = new BackPackPage(driver);
        backPackPage.pressAddToCartButton();
        backPackPage.pressRedCircleButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressAddToCartButton();
        appiumActions.navigateBack(driver);
        appiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        productPage.pressBikeLightProductText();
        BikeLightPage BikeLightPage = new BikeLightPage(driver);
        BikeLightPage.pressCounterPlusButton();
        BikeLightPage.pressCounterPlusButton();
        BikeLightPage.pressCounterPlusButton();
        BikeLightPage.pressAddToCartButton();

        productPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.pressRemoveItemButtons();

        log.info("We check if the cart is empty");
        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver, wait);
        boolean isDisplayedNoItemsText = cartNoItemsPage.isDisplayedNoItemsTextOnCartNoItemsPage();
        if (isDisplayedNoItemsText) {
            log.info("The cart is empty");
        } else {
            log.error("The cart is not empty");
        }
        Assert.assertTrue(isDisplayedNoItemsText, "The cart should be empty, but it is not.");

        cartNoItemsPage.pressGoShoppingButton();

        log.info("We check if the cart counter is available");
        boolean isDisplayedProductCounter = productPage.isDisplayedProductCounterOnCartBadgeButton();
        if (!isDisplayedProductCounter) {
            log.info("The cart counter is not available");
        } else {
            log.error("The cart counter is available");
        }
        Assert.assertFalse(isDisplayedProductCounter, "The cart counter should not be available, but it is.");
    }
}
