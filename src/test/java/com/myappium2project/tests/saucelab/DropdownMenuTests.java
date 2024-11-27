package com.myappium2project.tests.saucelab;

import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.ProductsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropdownMenuTests extends SauceLabApkBaseTest {
    private static final String LOG_CHECK_PRODUCT_ORDER = "We check whether the app switches to the selected language";
    private static final String LOG_PRODUCT_ORDER = "The order of the items as they are: \n";
    private static final String LOG_EXPECTED_PRODUCT_ORDER = "As they should be: \n";
    private static final String LOG_PRODUCT_ORDER_CORRECT = "The products are in the correct order";
    private static final String LOG_PRODUCT_ORDER_INCORRECT = "The products are not in the correct order";
    private static final String ASSERT_MESSAGE_PRODUCT_ORDER = "The products should be in the correct order, but they are not.";

    @Test(priority = 1)
    public void testDropdownMenuAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();

        LOG.info(LOG_CHECK_PRODUCT_ORDER);
        List<String> productsNamesList = productPage.getTheListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        System.out.println(LOG_PRODUCT_ORDER + productsNamesList);
        System.out.println(LOG_EXPECTED_PRODUCT_ORDER + expectedList);
        if (productsNamesList.equals(expectedList)) {
            LOG.info(LOG_PRODUCT_ORDER_CORRECT);
        } else {
            LOG.error(LOG_PRODUCT_ORDER_INCORRECT);
        }
        Assert.assertEquals(productsNamesList, expectedList,
                ASSERT_MESSAGE_PRODUCT_ORDER);
    }

    @Test(priority = 2)
    public void testDropdownMenuReverseAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderBackwardsOption();

        LOG.info(LOG_CHECK_PRODUCT_ORDER);
        List<String> productsNamesList = productPage.getTheListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println(LOG_PRODUCT_ORDER + productsNamesList);
        System.out.println(LOG_EXPECTED_PRODUCT_ORDER + expectedList);
        if (productsNamesList.equals(expectedList)) {
            LOG.info(LOG_PRODUCT_ORDER_CORRECT);
        } else {
            LOG.error(LOG_PRODUCT_ORDER_INCORRECT);
        }
        Assert.assertEquals(productsNamesList, expectedList,
                ASSERT_MESSAGE_PRODUCT_ORDER);
    }

    @Test(priority = 3)
    public void testDropdownMenuPricesOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceAscendingOrderOption();

        LOG.info(LOG_CHECK_PRODUCT_ORDER);
        List<Float> productsPricesList = productPage.getTheListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        System.out.println(LOG_PRODUCT_ORDER + productsPricesList);
        System.out.println(LOG_EXPECTED_PRODUCT_ORDER + expectedList);
        if (productsPricesList.equals(expectedList)) {
            LOG.info(LOG_PRODUCT_ORDER_CORRECT);
        } else {
            LOG.error(LOG_PRODUCT_ORDER_INCORRECT);
        }
        Assert.assertEquals(productsPricesList, expectedList,
                ASSERT_MESSAGE_PRODUCT_ORDER);
    }

    @Test(priority = 4)
    public void testDropdownMenuPricesOrderBackwards() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceDescendingOrderOption();

        LOG.info(LOG_CHECK_PRODUCT_ORDER);
        List<Float> productsPricesList = productPage.getTheListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println(LOG_PRODUCT_ORDER + productsPricesList);
        System.out.println(LOG_EXPECTED_PRODUCT_ORDER + expectedList);
        if (productsPricesList.equals(expectedList)) {
            LOG.info(LOG_PRODUCT_ORDER_CORRECT);
        } else {
            LOG.error(LOG_PRODUCT_ORDER_INCORRECT);
        }
        Assert.assertEquals(productsPricesList, expectedList,
                ASSERT_MESSAGE_PRODUCT_ORDER);
    }
}