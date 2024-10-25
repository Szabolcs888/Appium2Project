package pages.a_sauceLabApk.productsPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BackPackPage {
    private static final Logger log = LogManager.getLogger(BackPackPage.class);

    public BackPackPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"red circle\"]")
    private WebElement redCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"blue circle\"]")
    private WebElement blueCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]")
    private WebElement counterPlusButton;

    public void pressAddToCartButton() {
        log.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }

    public void pressRedCircleButton() {
        log.info("We press the red circle button");
        redCircleButton.click();
    }

    public void pressBlueCircleButton() {
        log.info("We press the blue circle button");
        redCircleButton.click();
    }

    public void pressCounterPlusButton() {
        log.info("We press the counter plus button");
        counterPlusButton.click();
    }
}
