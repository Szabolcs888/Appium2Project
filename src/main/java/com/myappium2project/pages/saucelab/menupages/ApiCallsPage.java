package com.myappium2project.pages.saucelab.menupages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ApiCallsPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"API calls\")")
    private WebElement apiCallsTitleText;

    public ApiCallsPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getApiCallsPageTitleText() {
        try {
            return apiCallsTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}