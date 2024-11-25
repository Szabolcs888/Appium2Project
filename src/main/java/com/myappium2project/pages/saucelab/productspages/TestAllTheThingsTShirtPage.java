package com.myappium2project.pages.saucelab.productsPages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TestAllTheThingsTShirtPage extends BasePage {

    public TestAllTheThingsTShirtPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add To Cart\")")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"gray circle\"]")
    private WebElement grayCircleButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"black circle\"]")
    private WebElement blackCircleButton;

    public void pressAddToCartButton() {
        LOG.info("We press the 'Add To Cart' button");
        addToCartButton.click();
    }

    public void pressGrayCircleButton() {
        LOG.info("We press the gray circle button");
        grayCircleButton.click();
    }

    public void pressBlackCircleButton() {
        LOG.info("We press the black circle button");
        blackCircleButton.click();
    }
}
