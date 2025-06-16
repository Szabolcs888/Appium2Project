package com.myappium2project.pages.nativeapps.saucelabs;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.logging.pagelogmessages.SlabsPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import com.myappium2project.utils.ListUtils;
import com.myappium2project.utils.ScrollUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.myappium2project.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePageClass {
    private static final String PRESS_TEXT_LOG = "We press the '{}'s text";
    private static final String SELECT_ORDER_OPTION_LOG = "We select the '{}' order option";
    private WebDriverWait wait;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Products\"]")
    private WebElement productTitleText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sort button\"]/android.widget.ImageView")
    private WebElement dropdownMenuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Name - Ascending\"]")
    private WebElement abcAscendingOrderOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Name - Descending\"]")
    private WebElement abcDescendingOrderOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price - Ascending\"]")
    private WebElement priceAscendingOrderOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price - Descending\"]")
    private WebElement priceDescendingOrderOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='store item text']")
    private List<WebElement> productsNamesListAsElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='store item price']")
    private List<WebElement> productsPricesListAsElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Bike Light']")
    private WebElement bikeLightProductText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Onesie']")
    private WebElement onesieProductText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Fleece Jacket\"]")
    private WebElement fleeceJacketProductText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Bolt T-Shirt\"]")
    private WebElement boltTShirtProductText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Test.allTheThings() T-Shirt\"]")
    private WebElement testAllTheThingsTShirtProductText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Backpack\"]")
    private WebElement backpackProductText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]")
    private WebElement cartBadgeButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]//android.widget.TextView")
    private WebElement productCounterOnCartBadgeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uDB81\uDCCF\").instance(2)")
    private WebElement thirdStarButtonUnderTheBackpack;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Close Modal\")")
    private WebElement closeModalButtonOnFeedbackPopup;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Thank you for submitting your review!\")")
    private WebElement feedbackPopupText;

    public ProductsPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ProductsPage(AndroidDriver driver, WebDriverWait wait) {
        super();
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getProductPageTitleText() {
        try {
            return productTitleText.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.textNotAvailableLog("title");
        }
    }

    public boolean isDisplayedProductCounterOnCartBadgeButton() {
        try {
            return productCounterOnCartBadgeButton.isDisplayed() && productCounterOnCartBadgeButton.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int getProductCounterOnCartBadgeButton() {
        int productCounter = Integer.parseInt(productCounterOnCartBadgeButton.getText());
        return productCounter;
    }

    public void pressDropdownMenuButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "dropdown menu");
        dropdownMenuButton.click();
    }

    public void pressAbcOrderOption() {
        LOG.info(SELECT_ORDER_OPTION_LOG, "abc");
        abcAscendingOrderOption.click();
    }

    public void pressAbcOrderBackwardsOption() {
        LOG.info(SELECT_ORDER_OPTION_LOG, "reverse abc");
        abcDescendingOrderOption.click();
    }

    public void pressPriceAscendingOrderOption() {
        LOG.info(SELECT_ORDER_OPTION_LOG, "ascending price");
        priceAscendingOrderOption.click();
    }

    public void pressPriceDescendingOrderOption() {
        LOG.info(SELECT_ORDER_OPTION_LOG, "descending price");
        priceDescendingOrderOption.click();
    }

    public void pressBikeLightProductText() {
        LOG.info(PRESS_TEXT_LOG, "Bike Light");
        bikeLightProductText.click();
    }

    public void pressOnesieProductText() {
        wait.until(ExpectedConditions.elementToBeClickable(onesieProductText));
        LOG.info(PRESS_TEXT_LOG, "Onesie");
        onesieProductText.click();
    }

    public void pressFleeceJacketProductText() {
        LOG.info(PRESS_TEXT_LOG, "Fleece Jacket");
        fleeceJacketProductText.click();
    }

    public void pressBoltTShirtProductText() {
        LOG.info(PRESS_TEXT_LOG, "Bolt T-shirt");
        boltTShirtProductText.click();
    }

    public void pressTestAllTheThingsTShirtProductText() {
        LOG.info(PRESS_TEXT_LOG, "Test allTheThings T-shirt");
        testAllTheThingsTShirtProductText.click();
    }

    public void pressBackpackProductText() {
        LOG.info(PRESS_TEXT_LOG, "Backpack");
        backpackProductText.click();
    }

    public void pressCartBadgeButton() {
        CommonUtils.threadSleep(500);
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "cart badge");
        cartBadgeButton.click();
    }

    public void pressThirdStarButtonUnderBackpack() {
        LOG.info(SlabsPageLogMessages.PRESS_BUTTON_UNDER_LOG, "third star", "Backpack");
        thirdStarButtonUnderTheBackpack.click();
    }

    public void pressCloseModalButtonOnFeedbackPopup() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Close Modal");
        closeModalButtonOnFeedbackPopup.click();
    }

    public String getFeedbackPopupText() {
        try {
            return feedbackPopupText.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.textNotAvailableLog("feedback popup");

        }
    }

    public boolean isCloseModalButtonAvailable() {
        try {
            boolean isDisplayed = closeModalButtonOnFeedbackPopup.isDisplayed();
            return isDisplayed;
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Collects all product names from the products list by scrolling through the page
     * until no new items appear.
     * <p>
     * Uses {@link ListUtils#addUniqueItemsToStringList(List, List)} to ensure no duplicates
     * and {@link ScrollUtils#attemptScrollForward(AndroidDriver)} to scroll the product list.
     *
     * @param driver the AndroidDriver used to perform scrolling actions
     * @return a list of all unique product names found on the page
     */
    public List<String> getListOfProductNames(AndroidDriver driver) {
        List<String> productNameList = new ArrayList<>();
        boolean moreElements = true;
        int previousSize = 0;
        while (moreElements) {
            ListUtils.addUniqueItemsToStringList(productNameList, productsNamesListAsElements);
            if (productNameList.size() > previousSize) {
                previousSize = productNameList.size();
                moreElements = ScrollUtils.attemptScrollForward(driver);
            } else {
                moreElements = false;
            }
        }
        return productNameList;
    }

    /**
     * Collects all product prices from the products list by scrolling through the page
     * until no new items appear.
     * <p>
     * Uses {@link ListUtils#addUniqueItemsToFloatList(List, List)} to ensure no duplicates
     * and {@link ScrollUtils#attemptScrollForward(AndroidDriver)} to scroll the product list.
     *
     * @param driver the AndroidDriver used to perform scrolling actions
     * @return a list of all unique product prices found on the page
     */
    public List<Float> getListOfProductPrices(AndroidDriver driver) {
        List<Float> productPriceList = new ArrayList<>();
        boolean moreElements = true;
        int previousSize = 0;
        while (moreElements) {
            ListUtils.addUniqueItemsToFloatList(productPriceList, productsPricesListAsElements);
            if (productPriceList.size() > previousSize) {
                previousSize = productPriceList.size();
                moreElements = ScrollUtils.attemptScrollForward(driver);
            } else {
                moreElements = false;
            }
        }
        return productPriceList;
    }
}