package pages.a_sauceLabApk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartNoItemsPage {
    private static final Logger LOG = LogManager.getLogger(CartNoItemsPage.class);
    private WebDriverWait wait;

    public CartNoItemsPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CartNoItemsPage(AndroidDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Go Shopping\")")
    private WebElement goShoppingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"No Items\")")
    private WebElement noItemsText;

    public void pressGoShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(goShoppingButton));
        LOG.info("We press the 'Go Shopping' button");
        goShoppingButton.click();
    }

    public boolean isDisplayedNoItemsTextOnCartNoItemsPage() {
        try {
            return noItemsText.isDisplayed() && noItemsText.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
