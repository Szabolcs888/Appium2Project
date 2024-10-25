package pages.b_curaHealthcareWithChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private static final Logger log = LogManager.getLogger(ProfilePage.class);

    public ProfilePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = ("//p[text()='Under construction.']"))
    private WebElement underConstructionsText;

    @FindBy(className = ("btn-default"))
    private WebElement logoutButton;

    public void pressLogoutButton() {
        log.info("We press the 'Logout' Button");
        logoutButton.click();
    }

    public boolean isPageLoaded() {
        try {
            return underConstructionsText.isDisplayed() && underConstructionsText.isEnabled() && underConstructionsText.getText().equals("Under construction.");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
