package com.myappium2project.pages.saucelab;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HamburgerMenu extends BasePageClass {
    private WebDriverWait wait;

    @AndroidFindBy(className = "android.widget.ImageView")
    private WebElement hamburgerMenuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log In\"]")
    private WebElement logInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log Out\"]")
    private WebElement logOutButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement logOutButtonOnLogOutAlert;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Webview\")")
    private WebElement webviewButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"QR Code Scanner\")")
    private WebElement qrCodeScannerButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Geo Location\")")
    private WebElement geoLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drawing\")")
    private WebElement drawingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"About\")")
    private WebElement aboutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FingerPrint\")")
    private WebElement fingerPrintButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Api Calls\")")
    private WebElement apiCallsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sauce Bot Video\")")
    private WebElement sauceBotVideoButton;

    public HamburgerMenu(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HamburgerMenu(AndroidDriver driver, WebDriverWait wait) {
        super();
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressHamburgerMenuButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuButton));
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Hamburger menu");
        hamburgerMenuButton.click();
    }

    public void pressLogInButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Log In");
        logInButton.click();
    }

    public void pressLogOutButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Log Out");
        logOutButton.click();
    }

    public void pressLogOutButtonOnLogOutAlert() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_ON_LOG, "Log Out", "'Log Out' alert");
        logOutButtonOnLogOutAlert.click();
    }

    public void pressWebviewButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Webview");
        webviewButton.click();
    }

    public void pressQrCodeScannerButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "QR Code Scanner");
        qrCodeScannerButton.click();
    }

    public void pressGeoLocationButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Geo Location");
        geoLocationButton.click();
    }

    public void pressDrawingButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Drawing");
        drawingButton.click();
    }

    public void pressFingerPrintButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Finger Print");
        fingerPrintButton.click();
    }

    public void pressAboutButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "About");
        aboutButton.click();
    }

    public void pressApiCallsButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Api Calls");
        apiCallsButton.click();
    }

    public void pressSauceBotVideoButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Sauce Bot Video");
        sauceBotVideoButton.click();
    }
}