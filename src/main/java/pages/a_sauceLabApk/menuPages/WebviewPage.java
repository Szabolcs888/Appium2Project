package pages.a_sauceLabApk.menuPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebviewPage {
    private static final Logger LOG = LogManager.getLogger(WebviewPage.class);

    public WebviewPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Webview\")")
    private WebElement webviewTitleText;

    public String getWebviewPageTitleText() {
        try {
            return webviewTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}
