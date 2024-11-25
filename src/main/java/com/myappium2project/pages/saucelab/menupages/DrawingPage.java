package com.myappium2project.pages.saucelab.menuPages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DrawingPage extends BasePage {

    public DrawingPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drawing\")")
    private WebElement drawingTitleText;

    public String getDrawingPageTitleText() {
        try {
            return drawingTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}
