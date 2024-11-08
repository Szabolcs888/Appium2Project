package pages.a_sauceLabApk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Username input field")
    private WebElement usernameInput;

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "Login button")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\").instance(0)")
    private WebElement loginTitleText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]")
    private WebElement errorMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement okButtonOnSuccessfulLogoutAlert;


    public void fillUserNameInput(String userName, String validOrInvalidUsername) {
        log.info("We fill the 'Username' input field with the {} username", validOrInvalidUsername);
        usernameInput.sendKeys(userName);
    }

    public void fillPasswordInput(String password, String validOrInvalidPassword) {
        log.info("We fill the 'Password' input field with the {} password", validOrInvalidPassword);
        passwordInput.sendKeys(password);
    }

    public void pressLoginButton() {
        log.info("We press the 'Login' button");
        loginButton.click();
    }

    public boolean isDisplayedErrorMessage() {
        try {
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            return errorMessage.getText();
        } catch (NoSuchElementException e) {
            return "The error message is not available";
        }
    }

    public void pressOkButtonOnSuccessfulLoggedOutAlert() {
        log.info("We press 'Ok' button on the alert window");
        okButtonOnSuccessfulLogoutAlert.click();
    }

    public String getLoginPageTitleText() {
        try {
            return loginTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}
