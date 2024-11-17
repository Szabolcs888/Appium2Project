package pages.a_sauceLabApk.productsPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BoltTShirtPage {
    private static final Logger LOG = LogManager.getLogger(BoltTShirtPage.class);

    public BoltTShirtPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    public void pressAddToCartButton() {
        LOG.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }
}
