package pages.b_curaHealthcareWithChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenu {
    private static final Logger LOG = LogManager.getLogger(HamburgerMenu.class);

    public HamburgerMenu(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "menu-toggle")
    private WebElement hamburgerMenuButton;

    @FindBy(xpath = "//a[@href='profile.php#login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='profile.php#profile']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@href='history.php#history']")
    private WebElement historyButton;

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
