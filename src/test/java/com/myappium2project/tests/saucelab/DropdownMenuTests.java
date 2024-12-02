package com.myappium2project.tests.saucelab;

import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.ProductsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropdownMenuTests extends SauceLabApkBaseTest {
    private static final String CHECK_PRODUCT_ORDER_LOG = "We check if the products are in the correct order";
    private static final String PRODUCT_ORDER_CONSOLELOG = "The order of the items as they are: \n";
    private static final String EXPECTED_PRODUCT_ORDER_CONSOLELOG = "As they should be: \n";
    private static final String PRODUCT_ORDER_CORRECT_LOG = "The products are in the correct order";
    private static final String PRODUCT_ORDER_INCORRECT_ERRORLOG = "The products are not in the correct order";
    private static final String MESSAGE_PRODUCT_ORDER_ASSERTLOG = "The products should be in the correct order, but they are not.";

    @Test(priority = 1)
    public void testDropdownMenuAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();

        LOG.info(CHECK_PRODUCT_ORDER_LOG);
        List<String> productsNamesList = productPage.getListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        System.out.println(PRODUCT_ORDER_CONSOLELOG + productsNamesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_CONSOLELOG + expectedList);
        if (productsNamesList.equals(expectedList)) {
            LOG.info(PRODUCT_ORDER_CORRECT_LOG);
        } else {
            LOG.error(PRODUCT_ORDER_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(productsNamesList, expectedList,
                MESSAGE_PRODUCT_ORDER_ASSERTLOG);
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
        System.out.println(PRODUCT_ORDER_CONSOLELOG + productsNamesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_CONSOLELOG + expectedList);
        if (productsNamesList.equals(expectedList)) {
            LOG.info(PRODUCT_ORDER_CORRECT_LOG);
        } else {
            LOG.error(PRODUCT_ORDER_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(productsNamesList, expectedList,
                MESSAGE_PRODUCT_ORDER_ASSERTLOG);
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
        System.out.println(PRODUCT_ORDER_CONSOLELOG + productsPricesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_CONSOLELOG + expectedList);
        if (productsPricesList.equals(expectedList)) {
            LOG.info(PRODUCT_ORDER_CORRECT_LOG);
        } else {
            LOG.error(PRODUCT_ORDER_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(productsPricesList, expectedList,
                MESSAGE_PRODUCT_ORDER_ASSERTLOG);
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
        System.out.println(PRODUCT_ORDER_CONSOLELOG + productsPricesList);
        System.out.println(EXPECTED_PRODUCT_ORDER_CONSOLELOG + expectedList);
        if (productsPricesList.equals(expectedList)) {
            LOG.info(PRODUCT_ORDER_CORRECT_LOG);
        } else {
            LOG.error(PRODUCT_ORDER_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(productsPricesList, expectedList,
                MESSAGE_PRODUCT_ORDER_ASSERTLOG);
    }
}