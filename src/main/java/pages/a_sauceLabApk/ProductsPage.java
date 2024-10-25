package pages.a_sauceLabApk;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private static final Logger log = LogManager.getLogger(ProductsPage.class);
    private WebDriverWait wait;

    public ProductsPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ProductsPage(AndroidDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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

    public String getProductPageTitleText() {
        try {
            return productTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }

    public boolean isDisplayedProductCounterOnCartBadgeButton() {
        try {
            return productCounterOnCartBadgeButton.isDisplayed() && productCounterOnCartBadgeButton.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Integer getProductCounterOnCartBadgeButton() {
        int productCounter = Integer.parseInt(productCounterOnCartBadgeButton.getText());
        return productCounter;
    }

    public void pressDropdownMenuButton() {
        log.info("We press the dropdown menu button");
        dropdownMenuButton.click();
    }

    public void pressAbcOrderOption() {
        log.info("We select the abc order option");
        abcAscendingOrderOption.click();
    }

    public void pressAbcOrderBackwardsOption() {
        log.info("We select the reverse abc order option");
        abcDescendingOrderOption.click();
    }

    public void pressPriceAscendingOrderOption() {
        log.info("We select the ascending price order option");
        priceAscendingOrderOption.click();
    }

    public void pressPriceDescendingOrderOption() {
        log.info("We select the descending price order option");
        priceDescendingOrderOption.click();
    }

    public void pressBikeLightProductText() {
        log.info("We press the 'Bike Light's text");
        bikeLightProductText.click();
    }

    public void pressOnesieProductText() {
        wait.until(ExpectedConditions.elementToBeClickable(onesieProductText));
        log.info("We press the 'Onesie's text");
        onesieProductText.click();
    }

    public void pressFleeceJacketProductText() {
        log.info("We press the 'Fleece Jacket's text");
        fleeceJacketProductText.click();
    }

    public void pressBoltTShirtProductText() {
        log.info("We press the 'Bolt T-shirt's text");
        boltTShirtProductText.click();
    }

    public void pressTestAllTheThingsTShirtProductText() {
        log.info("We press the 'Test allTheThings T-shirt's text");
        testAllTheThingsTShirtProductText.click();
    }

    public void pressBackpackProductText() {
        log.info("We press the 'Backpack's text");
        backpackProductText.click();
    }

    public void pressCartBadgeButton() {
        CommonUtils.threadSleep(500);
        log.info("We press the cart badge button");
        cartBadgeButton.click();
    }

    public void pressThirdStarButtonUnderTheBackpack() {
        log.info("We press the third star button under the 'Backpack'");
        thirdStarButtonUnderTheBackpack.click();
    }

    public void pressCloseModalButtonOnFeedbackPopup() {
        log.info("We press the 'Close Modal' button");
        closeModalButtonOnFeedbackPopup.click();
    }

    public String getFeedbackPopupText() {
        try {
            return feedbackPopupText.getText();
        } catch (NoSuchElementException e) {
            return "The feedback popup text is not available";
        }
    }

    public boolean isTheCloseModalButtonAvailable() {
        try {
            boolean isDisplayed = closeModalButtonOnFeedbackPopup.isDisplayed();
            return isDisplayed;
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }

    public List<String> getTheListOfProductNames(AndroidDriver driver) {
        List<String> productNameListAsString = new ArrayList<>();
        boolean moreElements = true;
        int previousSize = 0;

        while (moreElements) {
            for (WebElement item : productsNamesListAsElements) {
                String productName = item.getText();
                if (!productNameListAsString.contains(productName)) {
                    productNameListAsString.add(productName);
                }
            }
            // We check if new items have appeared
            if (productNameListAsString.size() > previousSize) {
                previousSize = productNameListAsString.size();
                try {
                    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
                } catch (Exception e) {
                    moreElements = false;
                }
            } else {
                moreElements = false;
            }
        }
        return productNameListAsString;
    }

    public List<Float> getTheListOfProductPrices(AndroidDriver driver) {
        List<Float> productPriceListAsFloat = new ArrayList<>();
        boolean moreElements = true;
        int previousSize = 0;

        while (moreElements) {
            for (WebElement item : productsPricesListAsElements) {
                float price = Float.parseFloat(item.getText().substring(1));
                if (!productPriceListAsFloat.contains(price)) {
                    productPriceListAsFloat.add(price);
                }
            }
            if (productPriceListAsFloat.size() > previousSize) {
                previousSize = productPriceListAsFloat.size();
                try {
                    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
                } catch (Exception e) {
                    moreElements = false;
                }
            } else {
                moreElements = false;
            }
        }
        return productPriceListAsFloat;
    }
}