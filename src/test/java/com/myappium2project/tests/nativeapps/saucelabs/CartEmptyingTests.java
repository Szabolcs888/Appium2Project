package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.configdata.models.accounts.SauceLabsAppAccount;
import com.myappium2project.configdata.providers.accounts.SauceLabsAppAccountProvider;
import com.myappium2project.pages.nativeapps.saucelabs.*;
import com.myappium2project.pages.nativeapps.saucelabs.productspages.*;
import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.common.AppiumActions;
import org.testng.annotations.Test;

/**
 * End-to-end test for verifying that items can be added to the cart and then successfully removed.
 * Covers full product selection, navigation, and cart-clearing workflow.
 */
@Test(groups = {TestGroups.E2E})
public class CartEmptyingTests extends SauceLabsAppTestBase {
    private static final SauceLabsAppAccount SAUCE_ACC1 = SauceLabsAppAccountProvider.getAccount(0);

    @Test(timeOut = 62_000, priority = 1)
    public void testPlacingProductsInCartAndThenEmptyingThem() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        SauceLabsCommonSteps.loginToSauceLabs(driver, hamburgerMenu, SAUCE_ACC1);

        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.pressDropdownMenuButton();
        productsPage.pressPriceAscendingOrderOption();
        productsPage.pressBoltTShirtProductText();
        BoltTShirtPage boltTShirtPage = new BoltTShirtPage(driver);
        boltTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressTestAllTheThingsTShirtProductText();
        TestAllTheThingsTShirtPage testAllTheThingsTShirtPage = new TestAllTheThingsTShirtPage(driver);
        testAllTheThingsTShirtPage.pressGrayCircleButton();
        testAllTheThingsTShirtPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        SauceLabsCommonSteps.scrollDown(driver);

        productsPage.pressFleeceJacketProductText();
        FleeceJacketPage fleeceJacketPage = new FleeceJacketPage(driver);
        fleeceJacketPage.pressAddToCartButton();
        fleeceJacketPage.pressCounterPlusButton();
        fleeceJacketPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);

        productsPage.pressBackpackProductText();
        BackPackPage backPackPage = new BackPackPage(driver);
        backPackPage.pressAddToCartButton();
        backPackPage.pressRedCircleButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressCounterPlusButton();
        backPackPage.pressAddToCartButton();
        AppiumActions.navigateBack(driver);
        SauceLabsCommonSteps.scrollUp(driver);

        productsPage.pressBikeLightProductText();
        BikeLightPage bikeLightPage = new BikeLightPage(driver);
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressCounterPlusButton();
        bikeLightPage.pressAddToCartButton();

        productsPage.pressCartBadgeButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.pressRemoveItemButtons();

        CartNoItemsPage cartNoItemsPage = new CartNoItemsPage(driver, wait);
        SauceLabsCommonAssertions.verifyCartIsEmpty(cartNoItemsPage);

        cartNoItemsPage.pressGoShoppingButton();

        SauceLabsCommonAssertions.verifyCartCounterIsNotAvailable(productsPage);
    }
}