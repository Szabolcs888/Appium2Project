package com.myappium2project.pages.batteryalarm;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InformationPage extends BasePage {

    public InformationPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"In order to avoid issue, find the power saving option on your phone," +
            " open it and add Battery app to protected apps or disable optimization for Battery app." +
            " It is usually under Phone battery settings.\n" +
            "This option might be called: \n" +
            "Power saving\n" +
            "Battery optimization\n" +
            "Battery usage\n" +
            "App optimization\n" +
            "\n" +
            "Lock app in recently used apps! Huawei, Xiaomi, Oneplus.. \n" +
            "\n" +
            "PRO version supports: \n" +
            "multi-language voice alert, \n" +
            "different alarm delay periods, \n" +
            "hide app icon from Android 7.0, \n" +
            "sound alert selection, \n" +
            "male Or female voice alert selection some languages only, \n" +
            "Widget\")")
    private WebElement informationText;

    public String getInformationText() {
        try {
            return informationText.getText();
        } catch (NoSuchElementException e) {
            return "The information text is not available";
        }
    }
}
