package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PhoneDesktop {
    private static final Logger log = LogManager.getLogger(PhoneDesktop.class);

    public PhoneDesktop(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Battery Alarm\")")
    private WebElement batteryAlarmAppIcon;

    public void pressBatteryAlarmAppIcon() {
        log.info("We press the 'Battery Alarm' app icon");
        batteryAlarmAppIcon.click();
    }
}
