package com.myappium2project.pages.curahealthcarewithchrome;

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
        LOG.info("We fill the 'Username' input field with the {} username", usernameValidityStatus);
        usernameInput.sendKeys(userName);
    }

    public void fillPasswordInput(String password, String passwordValidityStatus) {
        LOG.info("We fill the 'Password' input field with the {} password", passwordValidityStatus);
        passwordInput.sendKeys(password);
    }

    public void pressLoginButton() {
        LOG.info("We press the 'Login' button");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
    }

    public void pressLoginText() {
        LOG.info("We press the 'Login' text");
        loginText.click();
    }

    public String getErrorMessageText() {
        try {
            return errorMessage.getText();
        } catch (NoSuchElementException e) {
            return "The error message is not available";
        }
    }
}
