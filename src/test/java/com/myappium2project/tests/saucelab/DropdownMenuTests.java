package com.myappium2project.tests.saucelab;

import com.myappium2project.tests.basetests.SauceLabApkTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.ProductsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Test(groups = {TestGroups.INTEGRATION})
public class DropdownMenuTests extends SauceLabApkTestBase {
    private static final String CHECK_PRODUCT_ORDER_LOG = "We check if the products are in the correct order";
    private static final String PRODUCT_ORDER_LOG = "The order of the items as they are: " + System.lineSeparator();
    private static final String EXPECTED_PRODUCT_ORDER_LOG = "As they should be: " + System.lineSeparator();
    private static final String CORRECT_PRODUCT_ORDER_LOG = "The products are in the correct order";
    private static final String INCORRECT_PRODUCT_ORDER_LOG = "The products are not in the correct order";
    private static final String INCORRECT_PRODUCT_ORDER_ASSERT_LOG = "The products should be in the correct order, but they are not.";

    @Test(priority = 1)
    public void testDropdownMenuAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();

        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        List<String> productsNamesList = productPage.getListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        System.out.println(PRODUCT_ORDER_LOG + productsNamesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_LOG + expectedList);
        if (productsNamesList.equals(expectedList)) {
            LOG.info(CORRECT_PRODUCT_ORDER_LOG);
        } else {
            LOG.error(INCORRECT_PRODUCT_ORDER_LOG);
        }
        Assert.assertEquals(productsNamesList, expectedList,
                INCORRECT_PRODUCT_ORDER_ASSERT_LOG);
    }

    @Test(priority = 2)
    public void testDropdownMenuReverseAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderBackwardsOption();

        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        List<String> productsNamesList = productPage.getListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println(PRODUCT_ORDER_LOG + productsNamesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_LOG + expectedList);
        if (productsNamesList.equals(expectedList)) {
            LOG.info(CORRECT_PRODUCT_ORDER_LOG);
        } else {
            LOG.error(INCORRECT_PRODUCT_ORDER_LOG);
        }
        Assert.assertEquals(productsNamesList, expectedList,
                INCORRECT_PRODUCT_ORDER_ASSERT_LOG);
    }

    @Test(priority = 3)
    public void testDropdownMenuPricesOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceAscendingOrderOption();

        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        List<Float> productsPricesList = productPage.getListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        System.out.println(PRODUCT_ORDER_LOG + productsPricesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_LOG + expectedList);
        if (productsPricesList.equals(expectedList)) {
            LOG.info(CORRECT_PRODUCT_ORDER_LOG);
        } else {
            LOG.error(INCORRECT_PRODUCT_ORDER_LOG);
        }
        Assert.assertEquals(productsPricesList, expectedList,
                INCORRECT_PRODUCT_ORDER_ASSERT_LOG);
    }

    @Test(priority = 4)
    public void testDropdownMenuPricesOrderBackwards() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceDescendingOrderOption();

        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        List<Float> productsPricesList = productPage.getListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println(PRODUCT_ORDER_LOG + productsPricesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_LOG + expectedList);
        if (productsPricesList.equals(expectedList)) {
            LOG.info(CORRECT_PRODUCT_ORDER_LOG);
        } else {
            LOG.error(INCORRECT_PRODUCT_ORDER_LOG);
        }
        Assert.assertEquals(productsPricesList, expectedList,
                INCORRECT_PRODUCT_ORDER_ASSERT_LOG);
    }
}