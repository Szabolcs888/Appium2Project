package com.myappium2project.pages.curahealthcarewithchrome;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

    public ProfilePage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = ("//p[text()='Under construction.']"))
    private WebElement underConstructionsText;

    @FindBy(className = ("btn-default"))
    private WebElement logoutButton;

    public void pressLogoutButton() {
        LOG.info("We press the 'Logout' Button");
        logoutButton.click();
    }

    public boolean isPageLoaded() {
        try {
            return underConstructionsText.isDisplayed() &&
                    underConstructionsText.isEnabled() &&
                    underConstructionsText.getText().equals("Under construction.");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}