package com.myappium2project.pages.curahealthcarechrome;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = "//h1[text()='CURA Healthcare Service']")
    private WebElement curaHealthcareServiceText;

    public MainPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isPageLoaded() {
        try {
            return curaHealthcareServiceText.isDisplayed() &&
                    curaHealthcareServiceText.isEnabled() &&
                    curaHealthcareServiceText.getText().equals("CURA Healthcare Service");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}