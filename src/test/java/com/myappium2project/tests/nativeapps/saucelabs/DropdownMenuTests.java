package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myappium2project.pages.nativeapps.saucelabs.ProductsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tests the sorting functionality of the dropdown menu on the Sauce Labs app's product listing page.
 * Verifies correct ordering of products by name and price.
 */
@Test(groups = {TestGroups.INTEGRATION})
public class DropdownMenuTests extends SauceLabsAppTestBase {
    private static final String CHECK_PRODUCT_ORDER_LOG = "We check if the products are in the correct order";
    private static final String PRODUCT_ORDER_LOG = "The order of the items as they are: " + System.lineSeparator();
    private static final String EXPECTED_PRODUCT_ORDER_LOG = "As they should be: " + System.lineSeparator();
    private static final String CORRECT_PRODUCT_ORDER_LOG = "The products are in the correct order";
    private static final String INCORRECT_PRODUCT_ORDER_LOG = "The products are not in the correct order";
    private static final String INCORRECT_PRODUCT_ORDER_ASSERT_LOG = "The products should be in the correct order, but they are not.";

    private ProductsPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void initializeProductsPage() {
        productPage = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void testDropdownMenuAbcOrder() {
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();

        List<String> productsNamesList = productPage.getListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        verifyProductNameOrder(productsNamesList, expectedList);
    }

    @Test(priority = 2)
    public void testDropdownMenuReverseAbcOrder() {
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderBackwardsOption();

        List<String> productsNamesList = productPage.getListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        verifyProductNameOrder(productsNamesList, expectedList);
    }

    @Test(priority = 3)
    public void testDropdownMenuPricesOrder() {
        productPage.pressDropdownMenuButton();
        productPage.pressPriceAscendingOrderOption();

        List<Float> productsPricesList = productPage.getListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        verifyProductPriceOrder(productsPricesList, expectedList);
    }

    @Test(priority = 4)
    public void testDropdownMenuPricesOrderBackwards() {
        productPage.pressDropdownMenuButton();
        productPage.pressPriceDescendingOrderOption();

        List<Float> productsPricesList = productPage.getListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        verifyProductPriceOrder(productsPricesList, expectedList);
    }

    private void verifyProductNameOrder(List<String> actual, List<String> expected) {
        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        System.out.println(PRODUCT_ORDER_LOG + actual);
        System.out.println(EXPECTED_PRODUCT_ORDER_LOG + expected);

        if (actual.equals(expected)) {
            LOG.info(CORRECT_PRODUCT_ORDER_LOG);
        } else {
            LOG.error(INCORRECT_PRODUCT_ORDER_LOG);
        }

        Assert.assertEquals(actual, expected, INCORRECT_PRODUCT_ORDER_ASSERT_LOG);
    }

    private void verifyProductPriceOrder(List<Float> actual, List<Float> expected) {
        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        System.out.println(PRODUCT_ORDER_LOG + actual);
        System.out.println(EXPECTED_PRODUCT_ORDER_LOG + expected);
        if (actual.equals(expected)) {
            LOG.info(CORRECT_PRODUCT_ORDER_LOG);
        } else {
            LOG.error(INCORRECT_PRODUCT_ORDER_LOG);
        }

        Assert.assertEquals(actual, expected, INCORRECT_PRODUCT_ORDER_ASSERT_LOG);
    }
}