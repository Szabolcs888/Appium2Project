package com.myappium2project.pages.webapps.curahealthcare;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePageClass {
    @FindBy(xpath = "//p[text()='Under construction.']")
    private WebElement underConstructionsText;

    @FindBy(className = "btn-default")
    private WebElement logoutButton;

    public ProfilePage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressLogoutButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Logout");
        logoutButton.click();
    }

    public boolean isPageLoaded() {
        try {
            return underConstructionsText.isDisplayed() &&
                    underConstructionsText.isEnabled() &&
                    "Under construction.".equals(underConstructionsText.getText());
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}