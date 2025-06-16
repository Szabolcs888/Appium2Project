package com.myappium2project.pages.nativeapps.saucelabs.productspages;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// This class name contains the term "test" because that is its original name
public class TestAllTheThingsTShirtPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"gray circle\"]")
    private WebElement grayCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"black circle\"]")
    private WebElement blackCircleButton;

    public TestAllTheThingsTShirtPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressAddToCartButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Add To Cart");
        addToCartButton.click();
    }

    public void pressGrayCircleButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "gray circle");
        grayCircleButton.click();
    }

    public void pressBlackCircleButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "black circle");
        blackCircleButton.click();
    }
}