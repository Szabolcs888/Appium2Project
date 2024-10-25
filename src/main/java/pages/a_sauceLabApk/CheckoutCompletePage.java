package pages.a_sauceLabApk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private static final Logger log = LogManager.getLogger(CheckoutCompletePage.class);

    public CheckoutCompletePage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue Shopping\")")
    private WebElement continueShoppingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Checkout Complete\")")
    private WebElement CheckoutCompleteText;

    public void pressContinueShoppingButton() {
        log.info("We press the 'Continue Shopping' button");
        continueShoppingButton.click();
    }

    public String getCheckoutCompletePageTitleText() {
        try {
            return CheckoutCompleteText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}
