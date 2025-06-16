package com.myappium2project.pages.nativeapps.batteryalarm;

import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object representing the Android phone's desktop (home screen),
 * specifically for interactions needed by the Battery Alarm app tests.
 * <p>
 * This class encapsulates actions outside the app itself, such as launching the app
 * by tapping its icon on the home screen.
 * <p>
 * Only used in the context of Battery Alarm tests, so it resides in the same package.
 */
public class PhoneDesktopPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Battery Alarm\")")
    private WebElement batteryAlarmAppIcon;

    public PhoneDesktopPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressBatteryAlarmAppIcon() {
        LOG.info("We press the 'Battery Alarm' app icon on phone desktop");
        batteryAlarmAppIcon.click();
    }
}