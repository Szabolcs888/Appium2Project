package com.myappium2project.pages.saucelab;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageClass {
    @AndroidFindBy(accessibility = "Username input field")
    private WebElement usernameInput;

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "Login button")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\").instance(0)")
    private WebElement loginTitleText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]")
    private WebElement incorrectDataErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Username is required\"]")
    private WebElement emptyUsernameErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Password is required\"]")
    private WebElement emptyPasswordErrorMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement okButtonOnSuccessfulLogoutAlert;

    public LoginPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void fillUserNameInput(String userName, String usernameValidityStatus) {
        LOG.info(CommonPageLogMessages.FILL_USERNAME_INPUT_LOG, usernameValidityStatus);
        usernameInput.sendKeys(userName);
    }

    public void fillPasswordInput(String password, String passwordValidityStatus) {
        LOG.info(CommonPageLogMessages.FILL_PASSWORD_INPUT_LOG, passwordValidityStatus);
        passwordInput.sendKeys(password);
    }

    public void pressLoginButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Login");
        loginButton.click();
    }

    public boolean isDisplayedIncorrectDataErrorMessage() {
        try {
            return incorrectDataErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getIncorrectDataErrorMessageText() {
        try {
            return incorrectDataErrorMessage.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.ERROR_MESSAGE_NOT_AVAILABLE_LOG;
        }
    }

    public boolean isDisplayedEmptyUsernameErrorMessage() {
        try {
            return emptyUsernameErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getEmptyUsernameErrorMessageText() {
        try {
            return emptyUsernameErrorMessage.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.ERROR_MESSAGE_NOT_AVAILABLE_LOG;
        }
    }

    public boolean isDisplayedEmptyPasswordErrorMessage() {
        try {
            return emptyPasswordErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getEmptyPasswordErrorMessageText() {
        try {
            return emptyPasswordErrorMessage.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.ERROR_MESSAGE_NOT_AVAILABLE_LOG;
        }
    }

    public void pressOkButtonOnSuccessfulLoggedOutAlert() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_ON_LOG, "Ok", "'successfully logged out' alert");
        okButtonOnSuccessfulLogoutAlert.click();
    }

    public String getLoginPageTitleText() {
        try {
            return loginTitleText.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.textNotAvailableLog("title");
        }
    }
}