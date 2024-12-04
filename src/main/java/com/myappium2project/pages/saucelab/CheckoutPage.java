package com.myappium2project.pages.saucelab;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Checkout\")")
    private WebElement checkoutPageTitleText;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]")
    private WebElement fullNameInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")
    private WebElement addressLine1Input;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City* input field\"]")
    private WebElement cityInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"State/Region input field\"]")
    private WebElement stateRegionInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")
    private WebElement zipCodeInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country* input field\"]")
    private WebElement countryInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"To Payment\")")
    private WebElement toPaymentButton;

    public CheckoutPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getCheckoutPageTitleText() {
        try {
            return checkoutPageTitleText.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.getTextIsNotAvailableLog("title");
        }
    }

    public void fillFullNameInput(String fullName) {
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "Full Name", fullName);
        fullNameInput.sendKeys(fullName);
    }

    public void fillAddressLine1Input(String addressLine1) {
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "Address Line 1", addressLine1);
        addressLine1Input.sendKeys(addressLine1);
    }

    public void fillCityInput(String city) {
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "City", city);
        cityInput.sendKeys(city);
    }

    public void fillStateRegionInput(String stateRegion) {
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "State Region", stateRegion);
        stateRegionInput.sendKeys(stateRegion);
    }

    public void fillZipCodeInput(String zipCode) {
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "Zip Code", zipCode);
        zipCodeInput.sendKeys(zipCode);
    }

    public void fillCountryInput(String country) {
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "Country", country);
        countryInput.sendKeys(country);
    }

    public void pressToPaymentButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "To Payment");
        toPaymentButton.click();
    }
}