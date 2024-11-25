package com.myappium2project.pages.curahealthcarewithchrome;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenu extends BasePage {

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
        LOG.info("We press the 'Hamburger menu' button");
        hamburgerMenuButton.click();
    }

    public void pressLoginButton() {
        LOG.info("We press the 'Login' button");
        loginButton.click();
    }

    public void pressProfileButton() {
        LOG.info("We press the 'Profile' button");
        profileButton.click();
    }

    public void pressHistoryButton() {
        LOG.info("We press the 'History' button");
        historyButton.click();
    }
}
