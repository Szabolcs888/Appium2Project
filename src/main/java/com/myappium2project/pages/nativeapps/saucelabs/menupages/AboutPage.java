package com.myappium2project.pages.nativeapps.saucelabs.menupages;

import com.myappium2project.logging.pagelogmessages.SlabsPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AboutPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"About\")")
    private WebElement aboutTitleText;

    public AboutPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getAboutPageTitleText() {
        try {
            return aboutTitleText.getText();
        } catch (NoSuchElementException e) {
            return SlabsPageLogMessages.pageTitleTextNotAvailableLog("About");
        }
    }
}