package com.myappium2project.pages.saucelab.menuPages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class QrCodeScannerPage extends BasePage {

    public QrCodeScannerPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"QR Code Scanner\")")
    private WebElement qRCodeScannerTitleText;

    public String getQrCodeScannerPageTitleText() {
        try {
            return qRCodeScannerTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}