package com.myappium2project.pages.saucelab;

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
            return "The title text is not available";
        }
    }

    public void fillFullNameInput(String fullName) {
        LOG.info("We fill the 'Full Name' input field");
        fullNameInput.sendKeys(fullName);
    }

    public void fillAddressLine1Input(String addressLine1) {
        LOG.info("We fill the 'Address Line 1' input field");
        addressLine1Input.sendKeys(addressLine1);
    }

    public void fillCityInput(String city) {
        LOG.info("We fill the 'City' input field");
        cityInput.sendKeys(city);
    }

    public void fillStateRegionInput(String stateRegion) {
        LOG.info("We fill the 'State Region' input field");
        stateRegionInput.sendKeys(stateRegion);
    }

    public void fillZipCodeInput(String zipCode) {
        LOG.info("We fill the 'Zip Code' input field");
        zipCodeInput.sendKeys(zipCode);
    }

    public void fillCountryInput(String country) {
        LOG.info("We fill the 'Country' input field");
        countryInput.sendKeys(country);
    }

    public void pressToPaymentButton() {
        LOG.info("We press the 'To Payment' button");
        toPaymentButton.click();
    }
}