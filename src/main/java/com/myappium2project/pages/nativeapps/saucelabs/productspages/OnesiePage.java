package com.myappium2project.pages.nativeapps.saucelabs.productspages;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnesiePage extends BasePageClass {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add To Cart\"]")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]")
    private WebElement counterPlusButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"black circle\"]")
    private WebElement blackCircleButton;

    public OnesiePage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressBlackCircleButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "black circle");
        blackCircleButton.click();
    }

    public void pressCounterPlusButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "counter plus");
        counterPlusButton.click();
    }

    public void pressAddToCartButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Add To Cart");
        addToCartButton.click();
    }
}