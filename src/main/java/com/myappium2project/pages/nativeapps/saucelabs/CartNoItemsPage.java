package com.myappium2project.pages.nativeapps.saucelabs;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartNoItemsPage extends BasePageClass {
    private WebDriverWait wait;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Go Shopping\")")
    private WebElement goShoppingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"No Items\")")
    private WebElement noItemsText;

    public CartNoItemsPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CartNoItemsPage(AndroidDriver driver, WebDriverWait wait) {
        super();
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressGoShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(goShoppingButton));
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Go Shopping");
        goShoppingButton.click();
    }

    public boolean isDisplayedNoItemsTextOnCartNoItemsPage() {
        try {
            return noItemsText.isDisplayed() && noItemsText.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}