package com.myappium2project.pages.saucelab;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOrderReviewPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Place Order\")")
    private WebElement placeOrderButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"checkout delivery address\"]//android.widget.TextView")
    private List<WebElement> deliveryDataListAsElements;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"checkout payment info\"]//android.widget.TextView")
    private List<WebElement> paymentDataListAsElements;

    public CheckoutOrderReviewPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pressPlaceOrderButton() {
        LOG.info("We press the 'Place Order' button");
        placeOrderButton.click();
    }

    public List<String> getDeliveryAddressData() {
        List<String> deliveryDataListBeforeRefactoring = new ArrayList<>();
        List<String> deliveryDataList = new ArrayList<>();
        for (WebElement item : deliveryDataListAsElements) {
            String deliveryData = item.getText();
            deliveryDataListBeforeRefactoring.add(deliveryData);
        }
        deliveryDataList.add(deliveryDataListBeforeRefactoring.get(1));
        deliveryDataList.add(deliveryDataListBeforeRefactoring.get(2));
        deliveryDataList.add(deliveryDataListBeforeRefactoring.get(3).split(",")[0]);
        deliveryDataList.add(deliveryDataListBeforeRefactoring.get(3).split(",")[1].trim());
        deliveryDataList.add(deliveryDataListBeforeRefactoring.get(4).split(",")[1].trim());
        deliveryDataList.add(deliveryDataListBeforeRefactoring.get(4).split(",")[0]);
        return deliveryDataList;
    }

    public List<String> getPaymentData() {
        List<String> paymentDataListBeforeRefactoring = new ArrayList<>();
        List<String> paymentDataList = new ArrayList<>();
        for (WebElement item : paymentDataListAsElements) {
            String paymentData = item.getText();
            paymentDataListBeforeRefactoring.add(paymentData);
        }
        paymentDataList.add(paymentDataListBeforeRefactoring.get(1));
        paymentDataList.add(paymentDataListBeforeRefactoring.get(2).replace(" ", ""));
        paymentDataList.add(paymentDataListBeforeRefactoring.get(3).split(":")[1].trim().replace("/", ""));
        return paymentDataList;
    }
}