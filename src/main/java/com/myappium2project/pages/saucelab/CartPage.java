package com.myappium2project.pages.saucelab;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import com.myappium2project.utils.ListUtils;
import com.myappium2project.utils.ScrollUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Proceed To Checkout\")")
    private WebElement proceedToCheckoutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Remove Item\"]")
    private List<WebElement> removeItemButtons;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"product label\"]")
    private List<WebElement> productsNamesListInMyCartAsElements;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter amount\"]")
    private List<WebElement> productsQuantityListInMyCartAsElements;

    public CartPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressProceedToCheckoutButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Proceed To Checkout");
        proceedToCheckoutButton.click();
    }

    public List<String> getListOfProductNamesInMyCart(AndroidDriver driver) {
        List<String> productsNamesListInMyCart = new ArrayList<>();
        boolean moreElements = true;
        int previousSize = 0;
        while (moreElements) {
            ListUtils.addUniqueItemsToStringList(productsNamesListInMyCart, productsNamesListInMyCartAsElements);
            // We check if new items have appeared
            if (productsNamesListInMyCart.size() > previousSize) {
                previousSize = productsNamesListInMyCart.size();
                moreElements = ScrollUtils.tryScroll(driver);
            } else {
                moreElements = false;
            }
        }
        return productsNamesListInMyCart;
    }

    public void pressRemoveItemButtons() {
        LOG.info("We press the 'Remove Item' button until the cart is empty");
        boolean moreElements = true;
        while (moreElements) {
            if (removeItemButtons.isEmpty()) {
                moreElements = false;
            } else {
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
}