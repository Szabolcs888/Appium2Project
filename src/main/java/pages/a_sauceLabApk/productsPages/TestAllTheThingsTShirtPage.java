package pages.a_sauceLabApk.productsPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestAllTheThingsTShirtPage {
    private static final Logger log = LogManager.getLogger(TestAllTheThingsTShirtPage.class);

    public TestAllTheThingsTShirtPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"gray circle\"]")
    private WebElement grayCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"black circle\"]")
    private WebElement blackCircleButton;

    public void pressAddToCartButton() {
        log.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }

    public void pressGrayCircleButton() {
        log.info("We press the gray circle button");
        grayCircleButton.click();
    }

    public void pressBlackCircleButton() {
        log.info("We press the black circle button");
        blackCircleButton.click();
    }
}
