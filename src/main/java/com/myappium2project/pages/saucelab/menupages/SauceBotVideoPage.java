package com.myappium2project.pages.saucelab.menupages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SauceBotVideoPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SauceBot - The Beginning\")")
    private WebElement sauceBotVideoTitleText;

    public SauceBotVideoPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getSauceBotVideoPageTitleText() {
        try {
            return sauceBotVideoTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}