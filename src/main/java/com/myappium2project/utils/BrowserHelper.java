package com.myappium2project.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class for handling browser-specific interactions that are outside the tested app's scope.
 * <p>
 * Currently supports dismissing the Chrome password save popup that may appear during authentication flows.
 * This class is designed to be reused across test suites where Chrome's native UI interrupts app automation.
 * </p>
 */
public class BrowserHelper {
    private static final Logger LOG = LogManager.getLogger(BrowserHelper.class);

    private final AndroidDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "com.android.chrome:id/positive_button")
    private WebElement popup;

    public BrowserHelper(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void dismissPasswordPopupInChrome() {
        LOG.info("We handle the Chrome password popup window");
        String webContext = driver.getContext();
        try {
            driver.context("NATIVE_APP");
            wait.until(ExpectedConditions.elementToBeClickable(popup)).click();
        } catch (Exception e) {
            LOG.warn("Password popup not found or could not be dismissed.");
            driver.context(webContext);
        } finally {
            driver.context(webContext);
        }
    }
}