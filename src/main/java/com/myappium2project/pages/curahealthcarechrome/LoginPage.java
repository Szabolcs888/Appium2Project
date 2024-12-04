package com.myappium2project.pages.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    AndroidDriver driver;

    @FindBy(id = "txt-username")
    private WebElement usernameInput;

    @FindBy(id = "txt-password")
    private WebElement passwordInput;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    @FindBy(className = "text-danger")
    private WebElement errorMessage;

    @FindBy(id = "login")
    private WebElement loginText;

    public LoginPage(AndroidDriver driver) {
        super();
        this.driver = driver;
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
    }

    public String getErrorMessageText() {
        try {
            return errorMessage.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.ERROR_MESSAGE_IS_NOT_AVAILABLE_LOG;
        }
    }
}