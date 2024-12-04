package com.myappium2project.pages.saucelab.menupages;

import com.myappium2project.logging.pagelogmessages.SlabPageLogMessages;
import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FingerPrintPage extends BasePage {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FingerPrint\")")
    private WebElement fingerPrintTitleText;

    public FingerPrintPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getFingerPrintPageTitleText() {
        try {
            return fingerPrintTitleText.getText();
        } catch (NoSuchElementException e) {
            return SlabPageLogMessages.getPageTitleTextIsNotAvailableLog("Finger Print");
        }
    }
}