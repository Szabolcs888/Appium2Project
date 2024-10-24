package pages.b_curaHealthcareWithChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static final Logger log = LogManager.getLogger(MainPage.class);
    AndroidDriver driver;

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = ("//h1[text()='CURA Healthcare Service']"))
    private WebElement curaHealthcareServiceText;

    public boolean isPageLoaded() {
        try {
            return curaHealthcareServiceText.isDisplayed() && curaHealthcareServiceText.isEnabled() && curaHealthcareServiceText.getText().equals("CURA Healthcare Service");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
