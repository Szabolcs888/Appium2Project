package com.myappium2project.pages.saucelab.menupages;

import com.myappium2project.logging.pagelogmessages.SlabPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class QrCodeScannerPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"QR Code Scanner\")")
    private WebElement qRCodeScannerTitleText;

    public QrCodeScannerPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getQrCodeScannerPageTitleText() {
        try {
            return qRCodeScannerTitleText.getText();
        } catch (NoSuchElementException e) {
            return SlabPageLogMessages.pageTitleTextNotAvailableLog("QR Code Scanner");
        }
    }
}