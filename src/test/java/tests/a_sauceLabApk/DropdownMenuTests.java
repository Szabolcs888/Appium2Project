package tests.a_sauceLabApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.a_sauceLabApk.ProductsPage;
import tests._baseTests.SauceLabApkBaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(TestListener.class)
public class DropdownMenuTests extends SauceLabApkBaseTest {
    private static final Logger log = LogManager.getLogger(DropdownMenuTests.class);

    @Test(priority = 1)
    public void testDropdownMenuAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderOption();

        log.info("We check whether the products are in the correct order");
        List<String> productsNamesList = productPage.getTheListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        System.out.println("The order of the items as they are: \n" + productsNamesList);
        System.out.println("As they should be: \n" + expectedList);
        if (productsNamesList.equals(expectedList)) {
            log.info("The products are in the correct order");
        } else {
            log.error("The products are not in the correct order");
        }
        Assert.assertEquals(productsNamesList, expectedList, "The products should be in the correct order, but they are not.");
    }

    @Test(priority = 2)
    public void testDropdownMenuReverseAbcOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressAbcOrderBackwardsOption();

        log.info("We check whether the products are in the correct order");
        List<String> productsNamesList = productPage.getTheListOfProductNames(driver);
        List<String> expectedList = new ArrayList<>(productsNamesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println("The order of the items as they are: \n" + productsNamesList);
        System.out.println("As they should be: \n" + expectedList);
        if (productsNamesList.equals(expectedList)) {
            log.info("The products are in the correct order");
        } else {
            log.error("The products are not in the correct order");
        }
        Assert.assertEquals(productsNamesList, expectedList, "The products should be in the correct order, but they are not.");
    }

    @Test(priority = 3)
    public void testDropdownMenuPricesOrder() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceAscendingOrderOption();

        log.info("We check whether the products are in the correct order");
        List<Float> productsPricesList = productPage.getTheListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        System.out.println("The order of the items as they are: \n" + productsPricesList);
        System.out.println("As they should be: \n" + expectedList);
        if (productsPricesList.equals(expectedList)) {
            log.info("The products are in the correct order");
        } else {
            log.error("The products are not in the correct order");
        }
        Assert.assertEquals(productsPricesList, expectedList, "The products should be in the correct order, but they are not.");
    }

    @Test(priority = 4)
    public void testDropdownMenuPricesOrderBackwards() {
        ProductsPage productPage = new ProductsPage(driver);
        productPage.pressDropdownMenuButton();
        productPage.pressPriceDescendingOrderOption();

        log.info("We check whether the products are in the correct order");
        List<Float> productsPricesList = productPage.getTheListOfProductPrices(driver);
        List<Float> expectedList = new ArrayList<>(productsPricesList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println("The order of the items as they are: \n" + productsPricesList);
        System.out.println("As they should be: \n" + expectedList);
        if (productsPricesList.equals(expectedList)) {
            log.info("The products are in the correct order");
        } else {
            log.error("The products are not in the correct order");
        }
        Assert.assertEquals(productsPricesList, expectedList, "The products should be in the correct order, but they are not.");
    }
}