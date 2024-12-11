package com.myappium2project.pages.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenu extends BasePageClass {
    @FindBy(id = "menu-toggle")
    private WebElement hamburgerMenuButton;

    @FindBy(xpath = "//a[@href='profile.php#login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='profile.php#profile']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@href='history.php#history']")
    private WebElement historyButton;

    public HamburgerMenu(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressHamburgerMenuButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "hamburger menu");
        hamburgerMenuButton.click();
    }

    public void pressLoginButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Login");
        loginButton.click();
    }

    public void pressProfileButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Profile");
        profileButton.click();
    }

    public void pressHistoryButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "History");
        historyButton.click();
    }
}