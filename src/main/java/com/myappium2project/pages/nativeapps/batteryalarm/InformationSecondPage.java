package com.myappium2project.pages.nativeapps.batteryalarm;

import com.myappium2project.logging.pagelogmessages.BatteryAPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InformationSecondPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"For every good rating on google play\")")
    private WebElement secondInformationText;

    public InformationSecondPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getInformationText() {
        try {
            return secondInformationText.getText();
        } catch (NoSuchElementException e) {
            return BatteryAPageLogMessages.INFORMATION_TEXT_NOT_AVAILABLE_LOG;
        }
    }
}