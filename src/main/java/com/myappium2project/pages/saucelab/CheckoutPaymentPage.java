package com.myappium2project.pages.saucelab;

import com.myappium2project.pages.BasePage;
import com.myappium2project.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPaymentPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]")
    private WebElement fullNameInput;

    @AndroidFindBy(accessibility = "Card Number* input field")
    private WebElement cardNumberInput;

    @AndroidFindBy(accessibility = "Expiration Date* input field")
    private WebElement expirationDateInput;

    @AndroidFindBy(accessibility = "Security Code* input field")
    private WebElement securityCodeInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Review Order\")")
    private WebElement reviewOrderButton;

    public CheckoutPaymentPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void fillFullNameInput(String fullName) {
        CommonUtils.threadSleep(600);
        LOG.info("We fill the 'Full Name' input field");
        fullNameInput.sendKeys(fullName);
    }

    public void fillCardNumberInput(String cardNumber) {
        LOG.info("We fill the 'Card Number' input field");
        cardNumberInput.sendKeys(cardNumber);
    }

    public void fillExpirationDateInput(String expirationDate) {
        LOG.info("We fill the 'Expiration Date' input field");
        expirationDateInput.sendKeys(expirationDate);
    }

    public void fillSecurityCodeInput(String securityCode) {
        LOG.info("We fill the 'Security Code' input field");
        securityCodeInput.sendKeys(securityCode);
    }

    public void pressReviewOrderButton() {
        LOG.info("We press the 'Review Order' button");
        reviewOrderButton.click();
    }
}