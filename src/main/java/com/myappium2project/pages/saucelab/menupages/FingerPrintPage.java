package com.myappium2project.pages.saucelab.menuPages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FingerPrintPage extends BasePage {

    public FingerPrintPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FingerPrint\")")
    private WebElement fingerPrintTitleText;

    public String getFingerPrintPageTitleText() {
        try {
            return fingerPrintTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}
