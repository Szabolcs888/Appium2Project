package com.myappium2project.pages.saucelab.productspages;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BoltTShirtPage extends BasePageClass {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    public BoltTShirtPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressAddToCartButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Add To Cart");
        addToCartButton.click();
    }
}