package pages.a_sauceLabApk.productsPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BikeLightPage {
    private static final Logger LOG = LogManager.getLogger(BikeLightPage.class);

    public BikeLightPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add To Cart\"]")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]")
    private WebElement counterPlusButton;

    public void pressCounterPlusButton() {
        LOG.info("We press the counter plus button");
        counterPlusButton.click();
    }

    public void pressAddToCartButton() {
        LOG.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }
}
