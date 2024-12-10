package com.myappium2project.pages.saucelab.productspages;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.logging.pagelogmessages.SlabPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FleeceJacketPage extends BasePageClass {
    private WebDriverWait wait;

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

    public FleeceJacketPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public FleeceJacketPage(AndroidDriver driver, WebDriverWait wait) {
        super();
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressAddToCartButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Add To Cart");
        addToCartButton.click();
    }

    public void pressCounterPlusButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "counter plus");
        counterPlusButton.click();
    }

    public void pressFifthStarButton() {
        LOG.info(SlabPageLogMessages.PRESS_BUTTON_UNDER_LOG, "fifth star", "Fleece Jacket");
        fifthStarButton.click();
    }

    public void pressCloseModalButtonOnFeedbackPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(closeModalButtonOnFeedbackPopup));
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
}