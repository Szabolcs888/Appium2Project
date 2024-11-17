package com.myappium2project.pages.saucelab;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPaymentPage {
    private static final Logger LOG = LogManager.getLogger(CheckoutPaymentPage.class);
    private WebDriverWait wait;

    public CheckoutPaymentPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CheckoutPaymentPage(AndroidDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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

    public void fillFullNameInput(String fullName) {
        wait.until(ExpectedConditions.elementToBeClickable(fullNameInput));
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
