package com.myappium2project.pages.common;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PhoneDesktop extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Battery Alarm\")")
    private WebElement batteryAlarmAppIcon;

    public PhoneDesktop(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressBatteryAlarmAppIcon() {
        LOG.info("We press the 'Battery Alarm' app icon");
        batteryAlarmAppIcon.click();
    }
}
