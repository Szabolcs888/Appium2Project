package com.myappium2project.pages.saucelab.menuPages;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GeoLocationPage extends BasePage {

    public GeoLocationPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Geo Location\"]")
    private WebElement geoLocationTitleText;

    public String getGeoLocationPageTitleText() {
        try {
            return geoLocationTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }
}
