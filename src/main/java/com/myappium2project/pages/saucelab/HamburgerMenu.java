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

public class HamburgerMenu {
    private static final Logger LOG = LogManager.getLogger(HamburgerMenu.class);
    private WebDriverWait wait;

    public HamburgerMenu(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HamburgerMenu(AndroidDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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

    public void pressHamburgerMenuButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuButton));
        LOG.info("We press the 'Hamburger menu' button");
        hamburgerMenuButton.click();
    }

    public void pressLogInButton() {
        LOG.info("We press the 'Log In' button");
        logInButton.click();
    }

    public void pressLogOutButton() {
        LOG.info("We press the 'Log Out' button");
        logOutButton.click();
    }

    public void pressLogOutButtonOnLogOutAlert() {
        LOG.info("We press the 'Log Out' button On the 'Log Out' Alert");
        logOutButtonOnLogOutAlert.click();
    }

    public void pressWebviewButton() {
        LOG.info("We press the 'Webview' button");
        webviewButton.click();
    }

    public void pressQrCodeScannerButton() {
        LOG.info("We press the 'QR Code Scanner' button");
        qrCodeScannerButton.click();
    }

    public void pressGeoLocationButton() {
        LOG.info("We press the 'Geo Location' button");
        geoLocationButton.click();
    }

    public void pressDrawingButton() {
        LOG.info("We press the 'Drawing' button");
        drawingButton.click();
    }

    public void pressFingerPrintButton() {
        LOG.info("We press the 'Finger Print' button");
        fingerPrintButton.click();
    }

    public void pressAboutButton() {
        LOG.info("We press the 'About' button");
        aboutButton.click();
    }

    public void pressApiCallsButton() {
        LOG.info("We press the 'Api Calls' button");
        apiCallsButton.click();
    }

    public void pressSauceBotVideoButton() {
        LOG.info("We press the 'Sauce Bot Video' button");
        sauceBotVideoButton.click();
    }
}
