package com.myappium2project.pages.nativeapps.saucelabs.productspages;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BackPackPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"red circle\"]")
    private WebElement redCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"blue circle\"]")
    private WebElement blueCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]")
    private WebElement counterPlusButton;

    public BackPackPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressAddToCartButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Add To Cart");
        addToCartButton.click();
    }

    public void pressRedCircleButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "red circle");
        redCircleButton.click();
    }

    public void pressBlueCircleButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "blue circle");
        redCircleButton.click();
    }

    public void pressCounterPlusButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "counter plus");
        counterPlusButton.click();
    }
}