package com.myappium2project.pages.saucelab;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private static final Logger LOG = LogManager.getLogger(CartPage.class);

    public CartPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Proceed To Checkout\")")
    private WebElement proceedToCheckoutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Remove Item\"]")
    private List<WebElement> removeItemButtons;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"product label\"]")
    private List<WebElement> productsNamesListInMyCartAsElements;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter amount\"]")
    private List<WebElement> productsQuantityListInMyCartAsElements;

    public void pressProceedToCheckoutButton() {
        LOG.info("We press the Proceed To Checkout button");
        proceedToCheckoutButton.click();
    }

    public List<String> getTheListOfProductNamesInMyCart(AndroidDriver driver) {
        List<String> productsNamesListInMyCartAsString = new ArrayList<>();
        boolean moreElements = true;
        int previousSize = 0;
        while (moreElements) {
            for (WebElement item : productsNamesListInMyCartAsElements) {
                String productName = item.getText();
                if (!productsNamesListInMyCartAsString.contains(productName)) {
                    productsNamesListInMyCartAsString.add(productName);
                }
            }
            // We check if new items have appeared
            if (productsNamesListInMyCartAsString.size() > previousSize) {
                previousSize = productsNamesListInMyCartAsString.size();
                try {
                    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
                } catch (Exception e) {
                    moreElements = false;
                }
            } else {
                moreElements = false;
            }
        }
        return productsNamesListInMyCartAsString;
    }

    public void pressRemoveItemButtons() {
        LOG.info("We press the 'Remove Item' button until the cart is empty");
        boolean moreElements = true;
        while (moreElements) {
            for (WebElement item : removeItemButtons) {
                try {
                    item.click();
                } catch (StaleElementReferenceException e) {
                    moreElements = false;
                }
            }
        }
    }
}