package com.myappium2project.pages.saucelab.productspages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BackPackPage extends BasePage {

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
        LOG.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }

    public void pressRedCircleButton() {
        LOG.info("We press the red circle button");
        redCircleButton.click();
    }

    public void pressBlueCircleButton() {
        LOG.info("We press the blue circle button");
        redCircleButton.click();
    }

    public void pressCounterPlusButton() {
        LOG.info("We press the counter plus button");
        counterPlusButton.click();
    }
}