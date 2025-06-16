package com.myappium2project.pages.nativeapps.batteryalarm;

import com.myappium2project.logging.pagelogmessages.BatteryAPageLogMessages;
import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InformationPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"In order to avoid issue, find the power saving\")")
    private WebElement informationText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\">>>\")")
    private WebElement nextPageButton;

    public InformationPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getInformationText() {
        try {
            return informationText.getText();
        } catch (NoSuchElementException e) {
            return BatteryAPageLogMessages.INFORMATION_TEXT_NOT_AVAILABLE_LOG;
        }
    }

    public void pressNextPageButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "next page' '>>>");
        nextPageButton.click();
    }
}