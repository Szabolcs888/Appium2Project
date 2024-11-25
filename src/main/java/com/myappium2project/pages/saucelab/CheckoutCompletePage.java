package com.myappium2project.pages.saucelab;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue Shopping\")")
    private WebElement continueShoppingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Checkout Complete\")")
    private WebElement checkoutCompleteText;

    public CheckoutCompletePage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressContinueShoppingButton() {
        LOG.info("We press the 'Continue Shopping' button");
        continueShoppingButton.click();
    }

    public String getCheckoutCompletePageTitleText() {
        try {
            return checkoutCompleteText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}