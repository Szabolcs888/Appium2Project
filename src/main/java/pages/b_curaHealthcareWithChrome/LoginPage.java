package pages.b_curaHealthcareWithChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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

    public void fillUserNameInput(String userName, String validOrInvalidUsername) {
        log.info("We fill the 'Username' input field with the " + validOrInvalidUsername + " username");
        usernameInput.sendKeys(userName);
    }

    public void fillPasswordInput(String password, String validOrInvalidPassword) {
        log.info("We fill the 'Password' input field with the " + validOrInvalidPassword + " password");
        passwordInput.sendKeys(password);
    }

    public void pressLoginButton() {
        log.info("We press the 'Login' button");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
    }

    public void pressLoginText() {
        log.info("We press the 'Login' text");
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
