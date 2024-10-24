package pages.a_sauceLabApk.productsPages;

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

public class FleeceJacketPage {
    private static final Logger log = LogManager.getLogger(FleeceJacketPage.class);
    private WebDriverWait wait;

    public FleeceJacketPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public FleeceJacketPage(AndroidDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uDB81\uDCCF\").instance(4)")
    private WebElement fifthStarButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Close Modal\")")
    private WebElement closeModalButtonOnFeedbackPopup;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Thank you for submitting your review!\")")
    private WebElement feedbackPopupText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]")
    private WebElement counterPlusButton;


    public void pressAddToCartButton() {
        log.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }

    public void pressCounterPlusButton() {
        log.info("We press the counter plus button");
        counterPlusButton.click();
    }

    public void pressFifthStarButton() {
        log.info("We press the fifth star button under the 'Fleece Jacket's picture");
        fifthStarButton.click();
    }

    public void pressCloseModalButtonOnFeedbackPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(closeModalButtonOnFeedbackPopup));
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
}